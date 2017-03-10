/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.table;

import java.util.List;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public class DiverTableBuilder extends TableBuilder{
    private List<Diver> diverList;
    private List<Dive> divesList;

    public DiverTableBuilder(List<Diver> divers, List<Dive> dives) {
        this.diverList = divers;
        this.divesList = dives;
    }

    @Override
    public void buildHeading() {
        TableRow row = new TableRow(table);
        TableCell headingCell1 = new TableCell("Name", row);
        TableCell headingCell2 = new TableCell("Diver count", row);
        TableCell headingCell3 = new TableCell("Date&time", row);
        TableCell headingCell14 = new TableCell("Max depth", row);    }

    @Override
    public void buildBody() {
        for(Diver diver : diverList){
            if(diver.getOwnDives(divesList).isEmpty()) continue;
            
            for(Dive dive : diver.getOwnDives(divesList)){
                //za svakog ronioca jedan redak
                TableRow row = new TableRow(table);
                TableCell headingCell1 = new TableCell(diver.getName(), row);
                TableCell headingCell2 = new TableCell(dive.getDiversCount().toString(), row);
                TableCell headingCell3 = new TableCell(dive.getDate().toString(), row);
                TableCell headingCell4 = new TableCell(dive.getMaxDepth().toString(), row);
            }
        }    
    }
}
