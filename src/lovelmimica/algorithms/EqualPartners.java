/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.algorithms;

import java.util.List;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public class EqualPartners extends Algorithm {   

    public EqualPartners() {
        name = "EqualPartners";
    }
    
    @Override
    protected boolean satisfies(List<Diver> partneri, Dive uron) {
        for(Diver partner : partneri){
            Integer sameLevel = 0;
            for(Diver p : partneri){
                if(p.getLevel().equals(partner.getLevel())) sameLevel++;
            }
            if(sameLevel>1) return true;
        }
        return false;
    }
    
    
}
