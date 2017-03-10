/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author lovel_mimica
 */
public class TxtFileHelper {
    public static String loadText(String file) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder builder = new StringBuilder();
        while(true){
            line = reader.readLine();
            if(line == null) break;
            builder.append("\n" + line);
        }
        String text = new String(builder);
        return text;
    }
    public static void writeText(String text, String file) throws Exception{
        File outputFile = new File(file);
        if(outputFile.exists() == false) outputFile.createNewFile();
        FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.flush();
        bw.close();
    }
    
}
