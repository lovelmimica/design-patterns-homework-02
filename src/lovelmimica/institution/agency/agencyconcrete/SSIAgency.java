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
public class SSIAgency extends Agency{
    public SSIAgency(){
        super("SSI");
        //rekreativne licence
        licenses.put(1,"Scuba Diver"); 
        licenses.put(2,"Open Wather Diver"); 
        licenses.put(3,"Advanced Open Water");
        licenses.put(4,"Diver Stress & Rescue"); 
        licenses.put(5,"Advanced Open Water Diver"); 
        licenses.put(6,"Master Diver"); 
        //profesionalne licence
        licenses.put(7,"Dive Guide"); 
        licenses.put(8,"Divemaster"); 
        licenses.put(9,"Dive Control Specialist"); 
        licenses.put(10,"Open Water Instructor"); 
        licenses.put(11,"Advanced Open Water Instructor"); 
        licenses.put(12,"Divemaster Instructor"); 
        licenses.put(13,"Dive Control Specialist Instructor"); 
        licenses.put(14,"Instructor Trainter"); 
    }
}
