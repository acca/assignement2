/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.dsantoro.server;

import java.rmi.RemoteException;

/**
 *
 * @author acca
 */
public class SignerServer implements Signer {
    String name=null;
    
    public SignerServer(String name) throws RemoteException {
        super();
        this.name = name;
    }
     
    public String getName() {
        return this.name;
    }

    @Override
    public Notebook sign(Notebook notebook) throws RemoteException {
        //return "SERVER SIGN: " + this.name + " \n" + notebook.print();
        notebook.setBody(notebook.getBody() + "\nSERVER SIGN: " + this.name);
        return notebook;
    }
}
