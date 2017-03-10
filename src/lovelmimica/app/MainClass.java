/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.app;

import lovelmimica.helpers.ParamsCheck;
import lovelmimica.helpers.RandomGenerator;

/**
 *
 * @author lovel_mimica
 */
public class MainClass {
    private static String diversFile, divesFile, seed, outputFile, algorithm_1, algorithm_2, algorithm_3;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if(ParamsCheck.correct(args) == false) return;
            loadParams(args);
           
            DivingClub.getInstance().loadDivers(diversFile);
            DivingClub.getInstance().loadDives(divesFile);
            RandomGenerator.getInstance().initialize(seed);
            DivingClub.getInstance().organizeDives();
            DivingClub.getInstance().detailOrganizeDives(algorithm_1, algorithm_2, algorithm_3);
            DivingClub.getInstance().printDiverTable();
            DivingClub.getInstance().notifyInstitutions();
            DivingClub.getInstance().printStatisticalData();
            DivingClub.getInstance().saveOutputData(outputFile);
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private static void loadParams(String[] params){
        seed = params[0];
        diversFile = params[1];
        divesFile = params[2];
        algorithm_1 = params[3];
        algorithm_2 = params[4];
        algorithm_3 = params[5];
        outputFile = params[6];
    }
}
