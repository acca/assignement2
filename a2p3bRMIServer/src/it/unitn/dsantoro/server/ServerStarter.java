/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Daniele Santoro <daniele.santoro@studenti.unitn.it>
 */
public class ServerStarter {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.getProperties().put("java.security.policy","java.policy");
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        String name1 = "Sign1";
        String name2 = "Sign2";
        
        try {            
            Signer signer1 = new SignerServer(name1);
            Signer stub = (Signer) UnicastRemoteObject.exportObject(signer1, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name1, stub);
            System.out.println("Server " + name1 + " bound");
        } catch (Exception e) {
            System.err.println("Server " + name1 + " exception:");
            e.printStackTrace();
        }
        
        try {            
            Signer signer2 = new SignerServer(name2);
            Signer stub = (Signer) UnicastRemoteObject.exportObject(signer2, 0);
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.rebind(name2, stub);
            System.out.println("Server " + name2 + " bound");
        } catch (Exception e) {
            System.err.println("Server " + name2 + " exception:");
            e.printStackTrace();
        }
    }   
}
