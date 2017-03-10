/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency.agencyconcrete;

import lovelmimica.institution.agency.Agency;

/**
 *
 * @author lovel_mimica
 */
public class CMASAgency extends Agency{
    public CMASAgency(){
        super("CMAS");
        //rekreativne licence
        licenses.put(2,"One Star Diver");
        licenses.put(3,"One Star Diver");
        licenses.put(3,"Two Star Diver ");
        licenses.put(4,"Two Star Diver");
        //profesionalne licence
        licenses.put(7,"Three Star Diver");
        licenses.put(9,"One Star Instructor");
        licenses.put(10, "Two Star Instructor");
    }
}
