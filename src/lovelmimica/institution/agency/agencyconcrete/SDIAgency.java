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
public class SDIAgency extends Agency{

    public SDIAgency() {
        super("SDI");
        //rekreativne licence
        licenses.put(1,"Supervised Diver");
        licenses.put(2,"Open Water Scuba Diver");
        licenses.put(3,"Advanced Advanture");
        licenses.put(4,"Rescue Diver");
        licenses.put(5,"Advanced Diver");
        licenses.put(6,"Master Scuba Diver");
        //profesionalne licence
        licenses.put(7,"Divemaster");
        licenses.put(9,"Assistant Instructor");
        licenses.put(10,"Open Water Scuba Diver Instructor");
        licenses.put(13,"IT Staff Instructor");
        licenses.put(14,"Instructor Trainter");
    }
    
}
