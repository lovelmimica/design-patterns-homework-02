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
public class BSACAgency extends Agency{
    public BSACAgency(){
        super("BSAC");
        //rekreativne licence
        licenses.put(2,"Ocean Diver");
        licenses.put(3,"Ocean Diver");
        licenses.put(4,"Sports Diver");
        licenses.put(5,"Sports Diver");
        //profesionalne licence
        licenses.put(7,"Dive Leader");
        licenses.put(9,"Assistand Open Water Instructor");
        licenses.put(10,"Open Water Instructor");
        licenses.put(11,"Advanced Instructor");
    }
    
    
    
}
