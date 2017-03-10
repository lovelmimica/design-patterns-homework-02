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
public abstract class TableBuilder {
    protected Table table;
    protected abstract void buildHeading();
    protected abstract void buildBody();

    public void buildTable(){
        this.table = new Table();
    }
    public Table getTable(){
        return this.table;
    }

    
}
