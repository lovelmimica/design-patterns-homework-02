/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.algorithms;

import java.util.ArrayList;
import java.util.List;
import lovelmimica.helpers.RandomGenerator;
import lovelmimica.datatypes.Diver;
import lovelmimica.datatypes.Dive;

/**
 *
 * @author lovel_mimica
 */
public class RandomSelect extends Algorithm{

    public RandomSelect() {
        name = "RandomSelect";
    }
    
    @Override
    public void organizeDive(Dive dive) throws Exception{
        List<Diver> divers = new ArrayList<Diver>(dive.getDivers());
        List<List<Diver>> allCombination = calculateAllCombinations(divers);
        Integer randomIndex = RandomGenerator.getInstance().getInteger(allCombination.size() - 1);
        List<Diver> selectedCombination = allCombination.get(randomIndex);
        organizeParticularDives(dive, selectedCombination);
    }
    @Override
    protected boolean satisfies(List<Diver> partners, Dive dive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
