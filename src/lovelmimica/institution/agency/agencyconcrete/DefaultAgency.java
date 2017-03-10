/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency.agencyconcrete;

import lovelmimica.institution.agency.Agency;
import lovelmimica.institution.agency.Agency;

/**
 *
 * @author lovel_mimica
 */
public class DefaultAgency extends Agency{

    public DefaultAgency() {
        super("DefaultAgency");
        //rekreativne licence
        licenses.put(1,"Rekreativac_1");
        licenses.put(2,"Rekreativac_2");
        licenses.put(3,"Rekreativac_3");
        licenses.put(4,"Rekreativac_4");
        licenses.put(5,"Rekreativac_5");
        licenses.put(6,"Rekreativac_6");
        //profesionalne licence
        licenses.put(7,"Profesionalac_1");
        licenses.put(8,"Profesionalac_2");
        licenses.put(9,"Profesionalac_3");
        licenses.put(10,"Profesionalac_4");
        licenses.put(11,"Profesionalac_5");
        licenses.put(12,"Profesionalac_6");
        licenses.put(13,"Profesionalac_7");
        licenses.put(14,"Profesionalac_8");
    }
    
}
