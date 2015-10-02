/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro;

import java.net.SocketPermission;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Permission;
import java.util.Scanner;

/**
 *
 * @author Daniele Santoro <daniele.santoro@studenti.unitn.it>
 */
public class CalculatorClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Look and bind the service
            String serviceName = "Calculator";
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            Calculator comp = (Calculator) registry.lookup(serviceName);
            

            Scanner in = new Scanner(System.in);

            int add1 = 0, add2 = 0;
            boolean proceed = false;
            System.out.println("First operation is a sum. server will do the calculation and return the result.");
            try {
                System.out.println("Type first addend:");
                add1 = in.nextInt();
                System.out.println("Type second addend:");
                add2 = in.nextInt();
                proceed = true;
            } catch (Exception e) {
                System.err.println("You did not supply an integer. This request will not be sent to server");
            } finally {
                if (proceed == true) {
                    // Send request to server using RMI                    
                    try {                        
                        int sumResult = comp.sum(add1, add2);
                        System.out.println("Server say the result of the sum is: " + String.valueOf(sumResult));                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            int weight = 0, height = 0;
            proceed = false;
            System.out.println("\nNow the server will calculate your BMI.");
            try {
                System.out.println("Type your weight in kg (round to kg):");
                weight = in.nextInt();
                System.out.println("Type your height in cm (round to cm):");
                height = in.nextInt();
                proceed = true;
            } catch (Exception e) {
                System.err.println("You did not supply an integer. This request will not be sent to server");
            } finally {
                if (proceed == true) {
                    // Send request to server using RMI
                    try {
                        double bmi = comp.bmi(weight, height);
                        System.out.println("Server says your BMI is: " + Double.toString(bmi));
                        if (bmi < 16) {
                            System.out.println("You are seriously underweight");
                        } else if (bmi < 18) {
                            System.out.println("You are underweight");
                        } else if (bmi < 24) {
                            System.out.println("You are normal weight");
                        } else if (bmi < 29) {
                            System.out.println("You are overweight");
                        } else if (bmi < 35) {
                            System.out.println("You are seriously overweight");
                        } else {
                            System.out.println("You are gravely overweight");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("CalculatorClient exception:");
            e.printStackTrace();
        }
    }

}
