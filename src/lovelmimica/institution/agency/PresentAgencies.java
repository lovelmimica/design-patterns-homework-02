/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lovel_mimica
 */
public class PresentAgencies {
    private static PresentAgencies instance;
    private List<Agency> agencyList;
    private PresentAgencies() {
        agencyList = new ArrayList<Agency>();
    }
    
    public static PresentAgencies getInstance(){
        if(instance == null) instance = new PresentAgencies();
        return instance;        
    }
    
    public void addNewAgency(Agency agency){
        if(agencyList.contains(agency) == false) agencyList.add(agency);
    }

    public List<Agency> getAgencyList() {
        return agencyList;
    }
    
    
}
