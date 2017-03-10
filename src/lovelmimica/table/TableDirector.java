/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.table;

/**
 *
 * @author lovel_mimica
 */
public class TableDirector {
    private TableBuilder builder;

    public TableDirector(TableBuilder builder) {
        this.builder = builder;
    }
    
    public void createTable(){
        builder.buildTable();
        builder.buildHeading();
        builder.buildBody();
    }
    public Table getTable(){
        return builder.getTable();
    }
    
    
}
