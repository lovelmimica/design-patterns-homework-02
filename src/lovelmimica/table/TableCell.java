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
public class TableCell extends TablePart{
    private String content="";
    private Integer maxLength = 20; 

    public TableCell(String content, TablePart parent) {
        super(parent);
        this.content = content;
    }
    
    @Override
    public String print(){
        String out = "|";
        if(content.length() > maxLength) content = content.substring(0, (maxLength-1));
        out+=content;
        while(out.length()<maxLength){
            out+=" ";
        }
        System.out.print(out);
        return out;
    }
    
    
}
