/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.algorithms;

/**
 *
 * @author lovel_mimica
 */
public class AlgorithmFactory {
    public Algorithm getAlgorithm(String name) throws Exception{
        if(name.equalsIgnoreCase("RandomSelect")) return new RandomSelect();
        if(name.equalsIgnoreCase("MaxDepth")) return new MaxDepth();
        if(name.equalsIgnoreCase("EqualPartners")) return new EqualPartners();
        throw new Exception("No such algorithm");
    }
}
