/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.entities;

/**
 *
 * @author T4User
 */
public class GamesStatistic {
    private int id;
    private int homePoints;
    private int awayPoints;
    private int totalPoints;

    public GamesStatistic(int id, int homePoints, int awayPoints, int totalPoints) {
        this.id = id;
        this.homePoints = homePoints;
        this.awayPoints = awayPoints;
        this.totalPoints = totalPoints;
    }

    public GamesStatistic(){
        
    }

    public int getId() {
        return id;
    }


    public int getHomePoints() {
        return homePoints;
    }

    public int getAwayPoints() {
        return awayPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
    

    public void setId(int id) {
        this.id = id;
    }


    public void setHomePoints(int homePoints) {
        this.homePoints = homePoints;
    }

    public void setAwayPoints(int awayPoints) {
        this.awayPoints = awayPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
    
}
