/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovelmimica.institution;


/**
 *
 * @author lovel_mimica
 */
public interface InstitutionalSubject {
    public void sendNotification();
    public void receiveObserver(InstitutionObserver observer);
}
