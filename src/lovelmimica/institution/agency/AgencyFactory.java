/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency;

import lovelmimica.institution.agency.agencyconcrete.SSIAgency;
import lovelmimica.institution.agency.agencyconcrete.RSTCAgency;
import lovelmimica.institution.agency.agencyconcrete.BSACAgency;
import lovelmimica.institution.agency.agencyconcrete.SDIAgency;
import lovelmimica.institution.agency.agencyconcrete.ISOAgency;
import lovelmimica.institution.agency.agencyconcrete.DefaultAgency;
import lovelmimica.institution.agency.agencyconcrete.CMASAgency;
import lovelmimica.institution.agency.agencyconcrete.NAUIAgency;
import lovelmimica.institution.agency.agencyconcrete.PDICAgency;
import lovelmimica.institution.agency.agencyconcrete.PADIAgency;

/**
 *
 * @author lovel_mimica
 */
public class AgencyFactory implements AgencyFactoryInterface{    
    protected AgencyFactory() {
    }

    @Override
    public Agency getAgency(String name){
        if(name.equalsIgnoreCase("ISO")) return new ISOAgency();
        if(name.equalsIgnoreCase("RSTC")) return new RSTCAgency();        
        if(name.equalsIgnoreCase("SSI")) return new SSIAgency();
        if(name.equalsIgnoreCase("PADI")) return new PADIAgency();
        if(name.equalsIgnoreCase("SDI")) return new SDIAgency();
        if(name.equalsIgnoreCase("PDIC")) return new PDICAgency();
        if(name.equalsIgnoreCase("NAUI")) return new NAUIAgency();   
        if(name.equalsIgnoreCase("BSAC")) return new BSACAgency();
        if(name.equalsIgnoreCase("CMAS")) return new CMASAgency();
        
        return new DefaultAgency();
    }
    
    
}
