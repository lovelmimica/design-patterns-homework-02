/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.table;

import lovelmimica.composite.Part;

/**
 *
 * @author lovel_mimica
 */
public abstract class TablePart extends Part{

    public abstract String print();
    
    public TablePart(TablePart parent) {
        super(parent);
    }

    
    
    
    
}
