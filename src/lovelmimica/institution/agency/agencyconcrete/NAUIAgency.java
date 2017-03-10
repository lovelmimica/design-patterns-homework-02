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
public class NAUIAgency extends Agency{
    public NAUIAgency(){
        super("NAUI");
        //rekreativne licence
        licenses.put(2,"Scuba Diver");
        licenses.put(3,"Advanced Scuba Diver");
        licenses.put(4,"Scuba Rescue Diver");
        licenses.put(5,"Master Scuba Diver");
        //profesionalne licence
        licenses.put(7,"Assistant Instructor");
        licenses.put(9,"Divemaster");
        licenses.put(10,"Instructor");
        licenses.put(14,"Instructor Trainter");
    }
}
