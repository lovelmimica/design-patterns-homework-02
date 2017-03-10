/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lovel_mimica
 */
public class RandomGenerator {
    private static RandomGenerator instanca = new RandomGenerator();
    private RandomGenerator(){}
    public static RandomGenerator getInstance(){
        if(instanca == null) instanca = new RandomGenerator();
        return instanca;
    }
    
    private static Random generator = null;
    
    public void initialize(String seed){
        long seedLong = new Long(seed);
        generator = new Random(seedLong);
    }
    public List<Integer> getUniqueList(int size, int maxValue) throws Exception {
        if(generator == null) throw new Exception("RandomGenerator not have been seeded");
        if((maxValue + 1) < size) throw new Exception("Imposible to create unique list");
        List<Integer> uniqueList = new ArrayList<Integer>();
        while(size > 0){
            Integer temp = generator.nextInt(maxValue + 1);
            if(uniqueList.contains(temp) == false) {
                uniqueList.add(temp);
                size--;
            }
        }
    return uniqueList;
    }
    public Integer getInteger(int maxValue) throws Exception{
        if(generator == null) throw new Exception("RandomGenerator not have been seeded");
        return generator.nextInt(maxValue);
    }
}
