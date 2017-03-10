/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.algorithms;

import java.util.List;
import lovelmimica.app.DivingClub;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public class MaxDepth extends Algorithm{

    public MaxDepth() {
        name = "MaxDepth";
    }
    
    @Override
    protected boolean satisfies(List<Diver> partners, Dive dive) {
        Integer maxDepth = dive.getMaxDepth();
        for(Diver partner : partners){
            Diver adaptedPartner = (Diver)partner;
            Integer currentGeneralMaxDepth = adaptedPartner.getGeneralMaxDepth();
            Integer maxLevelPartner = 0; 
            for(Diver p : partners){
                if((p.equals(partner) == false) && (p.getLevel() > maxLevelPartner)) 
                    maxLevelPartner = p.getLevel();
            }
            Integer currentSpecificMaxDepth = DivingClub.getInstance().calculateMaxDepth(partner.getLevel(), maxLevelPartner);
            if(maxDepth < currentSpecificMaxDepth) return true;
            if((maxDepth > currentSpecificMaxDepth) && (currentSpecificMaxDepth.equals(currentGeneralMaxDepth))) return true;
        }
        return false;
    }
    
}
