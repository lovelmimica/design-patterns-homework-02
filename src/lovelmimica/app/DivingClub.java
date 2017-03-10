/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.app;

import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;
import java.util.ArrayList;
import java.util.List;
import lovelmimica.helpers.RandomGenerator;
import lovelmimica.helpers.TxtFileHelper;
import lovelmimica.table.InstitutionsTableBuilder;
import lovelmimica.table.DiverTableBuilder;
import lovelmimica.table.Table;
import lovelmimica.table.TableDirector;
import org.apache.commons.lang.time.DateUtils;
import lovelmimica.institution.InstitutionalSubject;
import lovelmimica.institution.InstitutionObserver;

/**
 *
 * @author lovel_mimica
 */
public class DivingClub{
    private static DivingClub instance = new DivingClub();
    private DivingClub(){}
    private String printString = "";
    public static DivingClub getInstance(){
        if(instance == null) 
            instance = new DivingClub();
        return instance;
    }
    
    private List<Diver> divers;
    private List<Dive> dives;

    public List<Diver> getDivers() {
        return divers;
    }

    public void setDivers(List<Diver> ronioci) {
        this.divers = ronioci;
    }

    public List<Dive> getDives() {
        return dives;
    }

    public void setDives(List<Dive> uroni) {
        this.dives = uroni;
    }
    public void loadDivers(String diversFile) throws Exception{
        this.divers = new ArrayList<Diver>();
        String diversTxt = TxtFileHelper.loadText(diversFile);
        String[] lines = diversTxt.trim().split("\\n");
        for(String line : lines){
            String[] roniocParametri = line.trim().split(";");
            if(roniocParametri.length == 4){
                String name = roniocParametri[0].trim();
                String federation = roniocParametri[1].trim();
                String level = roniocParametri[2].trim();
                String year = roniocParametri[3].trim();
            
                Diver diver = new Diver(name, federation, level, year);
                this.divers.add(diver);
            }
        }
    }
    public void loadDives(String datUroni) throws Exception{
        this.dives = new ArrayList<Dive>();
        String divesTxt = TxtFileHelper.loadText(datUroni);
        String[] lines = divesTxt.trim().split("\\n");
        for(String line : lines){
            String[] params = line.trim().split(";");
            if(params.length == 4){
                String date = params[0].trim();
                String time = params[1].trim();
                String maxDepth = params[2].trim();
                String diversCount = params[3].trim();
                Dive dive = new Dive(null, date, time, maxDepth, diversCount);
                this.dives.add(dive);
            }
        }
    }
    public void organizeDives() throws Exception{
        for(Dive dive : this.dives){
            if(getSameDayDives(dive).size() == 1){
                organizeRandomDivers(dive);
            }else{
                organizeSameDayDivers(dive);
            }
        }
    }
    public void detailOrganizeDives(String algorithm_1, String algorthm_2, String algorithm_3) throws Exception{
        for(Dive dive : this.dives){
            dive.detailOrganize(algorithm_1, algorthm_2, algorithm_3);
        }
    }    
    public void saveOutputData(String datIspis) throws Exception{
        TxtFileHelper.writeText(printString, datIspis);
        
    }
    public Integer calculateMaxDepth(Integer level, Integer maxPartner){
        if(level == 0) return 0;
        if(level == 1 && maxPartner <= 1) return 10;
        if(level == 1 && maxPartner > 1) return 20;
        if(level == 2 && maxPartner <= 2) return 30;
        if(level == 2 && maxPartner > 2) return 40;
        return 40;
    }

    private List<Dive> getSameDayDives(Dive dive){
        List<Dive> sameDayDives = new ArrayList<Dive>();
        for(Dive u : this.dives){
            if(DateUtils.isSameDay(dive.getDate(), u.getDate())) sameDayDives.add(u);
            
        }
        return sameDayDives;
    }
    private void organizeRandomDivers(Dive dive) throws Exception{
        Integer diversCount = dive.getDiversCount();
        Integer maxIndex = this.divers.size() - 1;
        List<Integer> diverIndexList = RandomGenerator.getInstance().getUniqueList(diversCount, maxIndex);
        for(Integer i : diverIndexList){
            Diver ronioc = this.divers.get(i);
            dive.getDivers().add(ronioc);
        }
    }
    private void organizeSameDayDivers(Dive dive){
        List<Dive> sameDayDives = getSameDayDives(dive);
        List<Diver> sameDayDivers = new ArrayList<Diver>();
        for(Dive d : sameDayDives){
            for(Diver diver : d.getDivers()){
                if(sameDayDivers.contains(diver) == false) sameDayDivers.add(diver);
            }
        }
        Integer requiredDivers = dive.getDiversCount();
        if(requiredDivers <= sameDayDivers.size()) dive.setDivers(sameDayDivers.subList(0, requiredDivers));
        else{
            int required = requiredDivers - sameDayDivers.size();
            while(required > 0){
                for(Diver d : this.divers){
                    if(sameDayDivers.contains(d) == false && required > 0){
                        sameDayDivers.add(d);
                        required--;
                    }
                }
            }
            dive.setDivers(sameDayDivers);
        }
    }
    
   
    public void printDiverTable(){        
        TableDirector director = new TableDirector(new DiverTableBuilder(this.divers, this.dives));
        director.createTable();
                
        Table table = director.getTable();
        
        this.printString += table.print();
    }
    
    public void notifyInstitutions() {
        for(Diver d : this.divers ){
            d.sendNotification();
        }   
        
    }

    public void printStatisticalData(){
       TableDirector director = new TableDirector(new InstitutionsTableBuilder());
       director.createTable();
       Table table = director.getTable();
        
       printString += table.print();
    }
}
