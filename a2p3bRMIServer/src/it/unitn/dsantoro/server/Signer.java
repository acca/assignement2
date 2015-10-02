/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Daniele Santoro <daniele.santoro@studenti.unitn.it>
 */
public interface Signer extends Remote {    
    Notebook sign(Notebook notebook) throws RemoteException;    
}
