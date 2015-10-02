/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro.client;

import it.unitn.dsantoro.server.Notebook;
import it.unitn.dsantoro.server.Signer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Daniele Santoro <daniele.santoro@studenti.unitn.it>
 */
public class NootebookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Look and bind the service            
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            String service1 = "Sign1";
            Signer server1 = (Signer) registry.lookup(service1);
            
            String service2 = "Sign2";
            Signer server2 = (Signer) registry.lookup(service2);

            Notebook nb = new Notebook();

            System.out.println("--- Please type an arbitrary number of lines. Input stops if a line in left empty");
            Scanner in = new Scanner(System.in);                       
            String line = in.nextLine();
            while ( (!line.equals("")) ){
                nb.setLine(line);
                line = in.nextLine();                
            }       
            
            System.out.println("--- Notebook object before call: \n" 
                    + nb.getBody());
            nb = server1.sign(nb);
            System.out.println("--- Notebook object after call to server 1: \n"
                    + nb.getBody());
            nb = server2.sign(nb);
            System.out.println("--- Notebook object after call to server 2: \n"
                    + nb.getBody());
            
        } catch (Exception e) {
            System.err.println("SingerServer exception in connecting:");
            e.printStackTrace();
        }
    }

}
