/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution;

import java.util.List;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public class CroatianDivingFederation extends Institution{
    private static CroatianDivingFederation instance;

    private CroatianDivingFederation(){
        super("HRS");
    }
    
    public static CroatianDivingFederation getInstanca(){
        if(instance == null) instance = new CroatianDivingFederation();
        return instance;
    }
    
    @Override
    public void receiveNotification(Diver diver, List<Dive> allDives){
        for(Dive uron : diver.getOwnDives(allDives)){
            System.out.println("HRS receives notification for diver:  " + diver.getName()
                    + ", about dive at date: " + uron.getDate());
            
        }
    }

    
    
}
