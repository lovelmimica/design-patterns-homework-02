/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.datatypes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lovelmimica.algorithms.AlgorithmFactory;
import lovelmimica.composite.Part;
import lovelmimica.table.DiverTableBuilder;
import lovelmimica.table.Table;
import lovelmimica.table.TableDirector;

/**
 *
 * @author lovel_mimica
 */
public class Dive extends Part implements DiveCloning{
    private Date date;
    private Integer maxDepth;
    private Integer diverCount;
    private List<Diver> divers;
    private String selectedAlgorithm = "SelectedAlgorithm";

    public Dive(Part parent, Date date, Integer maxDepth, Integer diverCount, List<Diver> divers, List<Part> particularDives) {
        super(parent);
        this.date = date;
        this.maxDepth = maxDepth;
        this.diverCount = diverCount;
        this.divers = divers;
        this.partList = particularDives;
    }
        

    public Dive(Part parent, String datePart, String timePart, String maxDepth, String diverCount) throws Exception {
        super(parent);
        this.date = new SimpleDateFormat("yyyy.MM.dd hh:mm").parse(datePart+ " " + timePart);
        this.maxDepth = new Integer(maxDepth);
        this.diverCount = new Integer(diverCount);
    }
   
    private Dive(Part parent) {
        super(parent);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    public Integer getDiversCount() {
        return diverCount;
    }

    public void setDiverCount(Integer diverCount) {
        this.diverCount = diverCount;
    }

    public List<Diver> getDivers() {
        if(divers == null) divers = new ArrayList<Diver>();
        return divers;
    }

    public void setDivers(List<Diver> divers) {
        this.divers = divers;
    }

    public String getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    public void setSelectedAlgorithm(String selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }
    
    @Override
    public String toString() {
        return super.toString() + "->" + this.date.toString();
    }
    
   
    public void detailOrganize(String algorithm_1, String algorithm_2, String algorithm_3) throws Exception{
        List<Dive> clones = new ArrayList<Dive>();
        for(int i = 0; i<3; i++){
            Dive clone = new Dive(null);
            cloneItself(clone);
            clones.add(clone);
        }        

        AlgorithmFactory af = new AlgorithmFactory();
        List<String> algorithmNameList = new ArrayList<String>();
        algorithmNameList.add(algorithm_1);
        algorithmNameList.add(algorithm_2);
        algorithmNameList.add(algorithm_3);
        for(int i = 0; i<3; i++){
            af.getAlgorithm(algorithmNameList.get(i)).organizeDive(clones.get(i));
        }
         List<Float> securityRates = new ArrayList<Float>();
        for(Dive clone :clones){
            Float securityRate = rateSecurity(clone);
            securityRates.add(securityRate);
        }
        
        Float maxRate = Collections.max(securityRates);
        Integer maxIndex = securityRates.indexOf(maxRate);
        Dive safetiestClone = clones.get(maxIndex);
 
        safetiestClone.cloneItself(this);

        for(Diver d : this.getDivers()){
            briefeDiver(d);
        }
        printDivingPlan(algorithm_1, algorithm_2, algorithm_3, securityRates, selectedAlgorithm);
        printDivingPlanTable();       
    }
    
    /**
     * Metoda vraca sigurnosnu ocjenu za dobiveni uron.
     */
    private Float rateSecurity(Dive dive){
        //TODO implementirati metodu kako treba
        Float rate = (float)0;
        for(Part particularDive : dive.getPartList()){
            rate =rate + ratePartialSecurity((Dive)particularDive);
        }
        return rate;
    }
    /**
     * Metoda vraca sigurnostu ocjenu za partikularni uron
     */
    private Float ratePartialSecurity(Dive particularDive){
        Float teamMaxDepth = particularDive.getMaxDepth().floatValue();
        List<Integer> levelList = new ArrayList<Integer>();
        for(Diver diver : particularDive.getDivers()){
            levelList.add(diver.getLevel());
        }
        Integer levelDifference = Collections.max(levelList) - Collections.min(levelList);
        return teamMaxDepth/(levelDifference+1);
    }
    /**
     * Metoda dodjeljuje vrijednosti atributa orgiginala, atributima kopije.
     */
    @Override
    public void cloneItself(Dive clone){
        clone.setDiverCount(this.getDiversCount());
        clone.setMaxDepth(this.getMaxDepth());
        clone.setPartList(this.getPartList());
        clone.setDivers(this.getDivers());
        clone.setDate(this.getDate());
        clone.setSelectedAlgorithm(this.getSelectedAlgorithm());
        
    }
    /**
     * Metoda "salje" obavijest roniocu o planu ronjenja
     */ 
    private void briefeDiver(Diver diver){
        System.out.println("\nDiver briefed: " + diver.getName());
    }
    /**
     * Metoda ispisuje na konzolu postupak izrade i detalje plana ronjenja.
     */ 
    private void printDivingPlan(String alg_1, String alg_2, String alg_3, List<Float> rateList, String selectedAlgortihm){
        System.out.println("Briefing about dive at: " + this.date + ": ");
        System.out.println("Used algorithms: " +alg_1 + ", " + alg_2 + " i " + alg_3);
        //ocjena sigurnosti svakog
        System.out.println("Security rates: ");
        System.out.println("    " + alg_1 + ": " + rateList.get(0).toString());
        System.out.println("    " + alg_2 + ": " + rateList.get(1).toString());
        System.out.println("    " + alg_3 + ": " + rateList.get(2).toString());
        //odabrani algoritam
        System.out.println("Selected algorithm :" + selectedAlgortihm);
        //popis partikularnih urona
        int counter = 0;
        for(Part partDive : this.getPartList()){
            counter++;
            System.out.println("Particular dive no_ " + counter + ":");
            System.out.println("Divers: ");
            for(Diver ronioc : ((Dive)partDive).getDivers()){
                System.out.println("    Name: " + ronioc.getName()+ 
                        ", Agency: " + ronioc.getAgency().toString() + ", Level: " + ronioc.getLevel());
            }
            System.out.println("Max depth: " + ((Dive)partDive).getMaxDepth());
            System.out.println("Date: " + ((Dive)partDive).getDate());
            System.out.println("\n");
            
        }
    }
    
    private void printDivingPlanTable(){
        List<Dive> oneDiveList = new ArrayList<Dive>();
        oneDiveList.add(this);
        
        TableDirector director = new TableDirector(new DiverTableBuilder(this.divers, oneDiveList));
        director.createTable();
        Table table = director.getTable();
        
        table.print();
    }
   
}
