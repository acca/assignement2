/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Daniele Santoro <daniele.santoro@studenti.unitn.it>
 */
public interface Calculator extends Remote {    
    int sum(int add1, int add2) throws RemoteException;
    double bmi(int weight, int height) throws RemoteException;
}
