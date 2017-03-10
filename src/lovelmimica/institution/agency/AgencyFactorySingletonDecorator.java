/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency;

import lovelmimica.institution.agency.agencyconcrete.DefaultAgency;

/**
 *
 * @author lovel_mimica
 */
public class AgencyFactorySingletonDecorator extends AgencyFactoryDecorator{
    private static AgencyFactorySingletonDecorator instance;
    
    private AgencyFactorySingletonDecorator() {
        super(new AgencyFactory());
    }
    
    public static AgencyFactorySingletonDecorator getInstance(){
        if(instance == null) instance = new AgencyFactorySingletonDecorator();
        return instance;
    }

    @Override
    public Agency getAgency(String name) {
        Agency agency;
        agency = lookupAgency(name);
        if(agency == null){
            agency = super.getAgency(name);
            if((agency instanceof DefaultAgency) == false) addAgency(agency);
        } 
        return agency; 
    }
   
    //privatne metode
    private Agency lookupAgency(String name){
        for(Agency agency : PresentAgencies.getInstance().getAgencyList()){
            if(agency.getName().equalsIgnoreCase(name)){
                return agency;
            }
        }
        return null;
    }
    private void addAgency(Agency agency){
        PresentAgencies.getInstance().addNewAgency(agency);
    }
}
