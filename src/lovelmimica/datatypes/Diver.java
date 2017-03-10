/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.datatypes;

import java.util.ArrayList;
import java.util.List;
import lovelmimica.app.DivingClub;
import lovelmimica.institution.agency.Agency;
import lovelmimica.institution.agency.AgencyFactorySingletonDecorator;
import lovelmimica.composite.Part;
import lovelmimica.institution.CroatianDivingFederation;
import lovelmimica.institution.InstitutionalSubject;
import lovelmimica.institution.InstitutionObserver;

/**
 *
 * @author lovel_mimica
 */
public class Diver implements InstitutionalSubject{

    private String name;
    private Agency agency;
    private Integer level;
    private Integer year;
    private String licence;
    private List<InstitutionObserver> observers;

    public Diver(String naziv, Agency agencija, Integer razina, Integer godiste) {
        this.name = naziv;
        this.agency = agencija;
        this.level = razina;
        this.year = godiste;
        licence = agencija.getLicence(razina);
        
        //dodavanje observera
        observers = new ArrayList<InstitutionObserver>();
        receiveObserver(this.agency);
        receiveObserver(CroatianDivingFederation.getInstanca());
        
    }

    @Override
    public void receiveObserver(InstitutionObserver observer) {
        this.observers.add(observer);
    }

    public Diver(String name, String agency, String level, String year) throws Exception {
        this.name = name;
        this.level = calculateLevel(level);
        this.year = new Integer(year);
        
        this.agency = AgencyFactorySingletonDecorator.getInstance().getAgency(agency);
        licence = this.agency.getLicence(this.level);
        
        //dodavanje observera
        observers = new ArrayList<InstitutionObserver>();
        receiveObserver(this.agency);
        receiveObserver(CroatianDivingFederation.getInstanca());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public List<InstitutionObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<InstitutionObserver> observers) {
        this.observers = observers;
    }

    private Integer calculateLevel(String levelString) {
        Integer level = 0;
        Character tip = levelString.charAt(0);
        if (tip.toString().equalsIgnoreCase("i")) {
            level = 6;
        }
        Integer temp = new Integer(levelString.substring(1, 2));
        level += temp;
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + this.name;
    }
    
    //metode koje prosiruju JavaBean tip sucelja
    public Integer getSpecialMaxDepth(Dive uron) {
        List<Diver> partners = uron.getDivers();
        Integer maxLevel = 0;
        for (Diver p : partners) {
            if (p.getLevel() > maxLevel) {
                maxLevel = p.getLevel();
            }
        }
        Integer maxDubina = DivingClub.getInstance().calculateMaxDepth(this.level, maxLevel);
        if(uron.getMaxDepth() > maxDubina)return maxDubina;
        else return uron.getMaxDepth();
    }
    public Integer getGeneralMaxDepth(){
        Integer fictivePartnerLevel = this.level + 1;
        Integer maxDepth = DivingClub.getInstance().calculateMaxDepth(this.level, fictivePartnerLevel);
        return maxDepth;
    }
    public List<Dive> getOwnDives(List<Dive> allDives) {
        List<Dive> ownDives = new ArrayList<Dive>();
        for (Dive dive : allDives) {
            for (Part particularDives : dive.getPartList()) {
                if (((Dive)particularDives).getDivers().contains(this)) {
                    ownDives.add((Dive)particularDives);
                }
            }
        }
        return ownDives;
    }

    @Override
    public void sendNotification() {
        for(InstitutionObserver observer : this.observers){
            List<Dive> u = DivingClub.getInstance().getDives();
            observer.receiveNotification(this, u);
        }
    }
    
    

}
