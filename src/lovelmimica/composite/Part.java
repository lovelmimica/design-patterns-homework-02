/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lovel_mimica
 */
public abstract class Part {

    protected List<Part> partList;
    protected Part parent;

    public Part(Part parent) {
        this.parent = parent;
        if (parent != null) {
            this.parent.addPart(this);
        }
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    public Part getParent() {
        return parent;
    }

    public void setParent(Part parent) {
        this.parent = parent;
    }

    public void addPart(Part dio) {
        if (partList == null) {
            partList = new ArrayList<Part>();
        }
        partList.add(dio);
    }

}
