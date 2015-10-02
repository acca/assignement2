/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro.server;

import java.io.Serializable;

/**
 *
 * @author Daniele Santoro <daniele.santoro@studenti.unitn.it>
 */
public class Notebook implements Serializable {
    String body = null;
    public Notebook(){
        this.body = "This is the first line of Notebook object identified by: " + this + "\n";
    }
    
    public void setLine(String line){
        this.body += line + "\n";
    }
    
    public String getBody() {
        return this.body;
    }
    
    public void printBody(){
        System.out.println(this.body);
    }
    
    public void setBody(String body){
        this.body = body;
    }
    
}
