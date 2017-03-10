/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution;

import java.util.ArrayList;
import java.util.List;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public abstract class Institution implements InstitutionObserver{
    protected List<Diver> diverList;
    protected List<Dive> diveList;
    protected String name;

    public Institution(String name) {
    this.diverList = new ArrayList<Diver>();
        this.diveList = new ArrayList<Dive>();
        this.name = name;    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Diver> getDiverList() {
        return diverList;
    }

    public List<Dive> getDiveList() {
        return diveList;
    }
    @Override
    public void receiveNotification(Diver diver, List<Dive> diveList) {
        this.diverList.add(diver);
        for(Dive uron : diver.getOwnDives(diveList)){
            this.diveList.add(uron);
       
            System.out.println(name + " receiving notification for diver:  " + diver.getName() 
                    + ", about dive at date: " + uron.getDate());
        }    }
    
}
