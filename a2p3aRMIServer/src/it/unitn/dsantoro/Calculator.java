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
 * @author acca
 */
public interface Calculator extends Remote {
    int add() throws RemoteException;
}
