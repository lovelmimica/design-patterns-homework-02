/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency;

import java.util.HashMap;
import java.util.Map;
import lovelmimica.institution.Institution;


/**
 *
 * @author lovel_mimica
 */
public abstract class Agency extends Institution{
   
    protected Map<Integer, String> licenses;
    
    protected Agency(String naziv) {
       super(naziv);
        licenses = new HashMap<Integer, String>();
    }

    public String getLicence(Integer razina){
        while(licenses.get(razina) == null){
            razina--;
            if(razina == 0) return "Nonexisting licence";
        }
        return licenses.get(razina);    
    }
    public void dodajLicencu(Integer razina, String naziv){
        licenses.put(razina, naziv);
    }

    @Override
    public String toString() {
        return name;
    }
    
}
