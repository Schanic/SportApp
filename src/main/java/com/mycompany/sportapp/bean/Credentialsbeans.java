/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.bean;


import com.mycompany.sportapp.entities.Credentials;

import java.util.Base64;
import javax.ejb.Stateless;

/**
 *
 * @author T4User
 */
@Stateless
public class Credentialsbeans {

    public Credentials createCredentials(String basicaut) {

        basicaut = basicaut.substring(6).trim();
        byte[] bytes = Base64.getDecoder().decode(basicaut);
        basicaut = new String(bytes); // daniel:daniel
        int colonPos = basicaut.indexOf(":");
        String username = basicaut.substring(0, colonPos);
        String password = basicaut.substring(colonPos + 1);
        return new Credentials(username, password);
    }

    public boolean checkcredentials(Credentials credentials) {
        if (credentials.getUsername().equals("te4")
                && credentials.getPassword().equals("te4")) { //MOT DATABAS
            return true;
        }
        return false;
    }
} 
