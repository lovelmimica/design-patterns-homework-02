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
public class TableRow extends TablePart{

    public TableRow(TablePart parent) {
        super(parent);
    }

    @Override
    public String print(){
        String out = "";
        for(int i = 0; i<this.partList.size(); i++){
            TableCell cell = (TableCell)this.partList.get(i);
            out += cell.print();
        }
        System.out.println("");
        out += System.lineSeparator();
        return out;
    }
    
}
