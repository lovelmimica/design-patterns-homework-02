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
public class RSTCAgency extends Agency{
    public RSTCAgency(){
        super("RSTC");
        //rekreativne licence
        licenses.put(1, "Supervised Diver");
        licenses.put(2, "Open Water Diver");
        licenses.put(4, "Entry Level Rescue Diver");
       
        //profesionalne licence
        licenses.put(7, "Recreational Dive Supervisor");
        licenses.put(9, "Recreational Assistant Instructor");
        licenses.put(10, "Recreational Scuba Instructor");
        licenses.put(14, "Recreational Scuba Instructor Trainer");
    }
}
