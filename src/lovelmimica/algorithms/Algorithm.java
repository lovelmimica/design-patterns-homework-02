/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.algorithms;

import java.util.ArrayList;
import java.util.List;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public abstract class Algorithm {
    protected String name = "DefaultAlgorithm";
    protected abstract boolean satisfies(List<Diver> partners, Dive dive);
         
     public void organizeDive(Dive dive) throws Exception {
        List<Diver> divers = new ArrayList<Diver>(dive.getDivers());
        List<List<Diver>> allCombinations = calculateAllCombinations(divers);
        
        List<Integer> combinationRatingList = new ArrayList<Integer>(); 
        Integer maxRating = 0;
        for(List<Diver> combination : allCombinations){
            Integer rating = rateCombination(combination, dive);
            combinationRatingList.add(rating);
            if(rating>maxRating) maxRating = rating;
        }
        Integer selectedIndex = combinationRatingList.indexOf(maxRating);
        List<Diver> selectedCombination =allCombinations.get(selectedIndex);
        organizeParticularDives(dive, selectedCombination);
        markDive(dive);
    }
    
     private Integer rateCombination(List<Diver> combination, Dive uron) {
        boolean oddDiversCount = ((combination.size() % 2) == 1);
        Integer rate = 0;
        for(int i = 0; i<combination.size(); i+=2){ 
            List<Diver> partners;
            if(oddDiversCount == true && i == (combination.size() - 3)){
                   //3 diver team
                   partners = combination.subList(i, i+3);
                   if(satisfies(partners, uron)) rate++;
                   break;
            } else{
                   //2 divers team
                   partners = combination.subList(i, i + 2);
                   if(satisfies(partners, uron)) rate++;
            }
            
        }
        return rate;
    }   
    
    protected List<List<Diver>> calculateAllCombinations(List<Diver> original){
       if(original.size() == 0){
           List<List<Diver>> result = new ArrayList<List<Diver>>();
           result.add(new ArrayList<Diver>());
           return result;
       }
       Diver firstElement = original.remove(0);
       List<List<Diver>> returnValue = new ArrayList<List<Diver>>();
       List<List<Diver>> permutations = calculateAllCombinations(original);
       for(List<Diver> p : permutations){
           for(int i = 0; i <= p.size(); i++){
                List<Diver> temp = new ArrayList<Diver>(p);
                temp.add(i, firstElement);
                returnValue.add(temp);
           }     
       }
       return returnValue;
    }     
    protected void organizeParticularDives(Dive uron, List<Diver> selectedCombination){
        Integer particularDivesCount = uron.getDiversCount() / 2;
        boolean oddDiversCount = ((uron.getDiversCount() % 2) == 1);
        int next = 0; 
        for(int i = 0; i<particularDivesCount; i++){
            List<Diver> particularDiverList = new ArrayList<Diver>();
            Dive particularDive;
            if(i == (particularDivesCount - 1) && oddDiversCount == true){
                //add last 3 divers
                particularDiverList = selectedCombination.subList(next,next+3);
                next = next +3;
                particularDive = new Dive(uron,uron.getDate(), uron.getMaxDepth(), 3, particularDiverList, null);
            }else{
                //add next 2 divers
                particularDiverList = selectedCombination.subList(next, next+2);
                next = next + 2;
                particularDive = new Dive(uron,uron.getDate(), uron.getMaxDepth(), 2, particularDiverList, null);
            }
        }
    }
    protected void markDive(Dive uron){
        uron.setSelectedAlgorithm(name);
    }
}
