/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution.agency;

/**
 *
 * @author lovel_mimica
 */
public abstract class AgencyFactoryDecorator implements AgencyFactoryInterface{
    protected AgencyFactory decoratedAgencyFactory;
    
    public AgencyFactoryDecorator(AgencyFactory decoratedAgencyFactory){
        this.decoratedAgencyFactory = decoratedAgencyFactory;
    }
    
    @Override
    public Agency getAgency(String name){
        return decoratedAgencyFactory.getAgency(name);
    }
}