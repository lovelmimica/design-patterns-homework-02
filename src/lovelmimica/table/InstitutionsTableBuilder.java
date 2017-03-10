/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.table;

import lovelmimica.institution.CroatianDivingFederation;
import lovelmimica.institution.Institution;
import lovelmimica.institution.agency.Agency;
import lovelmimica.institution.agency.PresentAgencies;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public class InstitutionsTableBuilder extends TableBuilder{

    @Override
    public void buildHeading() {
            TableRow row = new TableRow(table);
            TableCell heading_1  = new TableCell("Agency", row);
            TableCell heading_2 = new TableCell("Dive count", row);
            TableCell heading_3  = new TableCell("Avg depth", row);
            TableCell heading_4  = new TableCell("Diver count", row);    
    }
   
    @Override
    public void buildBody() {
        for(Agency agencija : PresentAgencies.getInstance().getAgencyList()){
                writeInnstitution(agencija);
        }
        writeInnstitution(CroatianDivingFederation.getInstanca());
    }
    private void writeInnstitution(Institution institution){
        //ucitavanje svaku agenciju dodaj br urona, prosjecnu dubinu i ukupno ronioca
            Integer diveCount = institution.getDiveList().size();
            Float avgDepth = (float)0;
            int counter = 0;
            for(Dive dive : institution.getDiveList()){
                avgDepth += dive.getMaxDepth().floatValue();
                counter++;
            }
            avgDepth /=counter;
                                
            //dodavanje 1 retka tijela
            TableRow row = new TableRow(table);
            TableCell cell_1 = new TableCell(institution.getName(), row);
            TableCell cell_2 = new TableCell(new Integer(institution.getDiveList().size()).toString(), row);
            TableCell cell_3 = new TableCell(avgDepth.toString(), row);
            TableCell cell_4 = new TableCell(new Integer(institution.getDiverList().size()).toString(), row);
            }    
    }

        