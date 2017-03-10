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
public class Table extends TablePart{ 
    public Table(){
        super(null);
    }
 
    private String writeLine(){
        System.out.println("------------------------------------------------------------------------");
        return ("------------------------------------------------------------------------" + System.lineSeparator());
    }
   
    @Override
    public String print(){
        String printString = "";
        for(int i = 0; i < this.partList.size(); i++){
            TableRow row = (TableRow) this.partList.get(i);
            printString += row.print();
            printString += writeLine();
        }
        System.out.println("");
        printString += System.lineSeparator();
        return printString;
    }
    
}
