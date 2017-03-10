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
public class PDICAgency extends Agency{

    public PDICAgency() {
        super("PDIC");
        //rekreativne licence
        licenses.put(2,"Open Water Diver");
        licenses.put(3,"Advanced Open Water Diver");
        licenses.put(4,"Rescue Diver");
        licenses.put(6,"Master Scuba Diver");
        
        //profesionalne licence
        licenses.put(7,"Dive Supervisor");
        licenses.put(9,"Assistant Instructor");
        licenses.put(10,"Instructor");
        licenses.put(14,"Instructor Trainer");
    }
    
}
