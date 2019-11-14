/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.resources;

import com.mycompany.sportapp.bean.SportBean;
import com.mycompany.sportapp.entities.GamesStatistic;
import com.mycompany.sportapp.entities.SportStatistic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author T4User
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SportResources {

    @EJB
    SportBean sportBean;

    @GET
    @Path("teams")
    public Response getTeams() {
        List<SportStatistic> teams = sportBean.getTeams();
        return Response.ok(teams).build();
    }

    @GET
    @Path("Games")
    public Response getGames() {
        List<GamesStatistic> games = sportBean.getGames();
        return Response.ok(games).build();
    }

    @GET
    @Path("team")
    public Response getMatch(@QueryParam("id") int id) {
        SportStatistic enemy = sportBean.getTeam(id);
        return Response.ok(enemy).build();
    }

    @POST
    @Path("post")
    public Response postGame(GamesStatistic sport) {
        int result = sportBean.saveGames(sport);
        if (result == 1) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
