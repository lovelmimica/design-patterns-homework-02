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
public class PADIAgency extends Agency{

    public PADIAgency() {
        super("PADI");
        //rekreativne licence
        licenses.put(1,"Scuba Diver");
        licenses.put(2,"Open Water Diver");
        licenses.put(3,"Advanced Open Water");
        licenses.put(4,"Rescue Diver");
        licenses.put(6,"Master Scuba Diver");
        //profesionalne licence
        licenses.put(7,"Divemaster");
        licenses.put(9,"Assistant Instructor");
        licenses.put(10,"Open Watch Scuba Instructor");
        licenses.put(11,"Master Scuba Diver Trainer");
        licenses.put(13,"Staff Instructor");
        licenses.put(14,"Course Director");
    }
    
}
