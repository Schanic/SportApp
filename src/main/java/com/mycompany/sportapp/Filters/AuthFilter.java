/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.Filters;

import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import com.mycompany.sportapp.bean.Credentialsbeans;
import com.mycompany.sportapp.entities.Credentials;
import javax.ws.rs.core.Response;

/**
 *
 * @author T4User
 */
@Provider
public class AuthFilter implements ContainerRequestFilter {

    @EJB
    Credentialsbeans credentialsbeans;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        if(requestContext.getMethod().equals("GET")){
            return;
        }
        
        try {
            String basicAuth = requestContext.getHeaderString("Authorization");
            System.out.println(basicAuth);
            Credentials credentials = credentialsbeans.createCredentials(basicAuth);
            if (credentialsbeans.checkcredentials(credentials)) {
                return;
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        Response unAuth = Response.status(Response.Status.UNAUTHORIZED)
                .entity(" NEJ NEJ WRONG CREDENTIALS").build();
        requestContext.abortWith(unAuth);
    }
}
