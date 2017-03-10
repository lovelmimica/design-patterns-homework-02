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
public class ISOAgency extends Agency{

    public ISOAgency() {
        super("ISO");
        licenses.put(1, "Supervised Diver");
        licenses.put(2, "Autonomus Diver");
        licenses.put(7, "Dive Leader");
        licenses.put(9, "Instructor - Level 1");
        licenses.put(10, "Instructor - Level 2");
    }
    
}
