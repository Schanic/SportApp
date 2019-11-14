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
public class SportStatistic {

    private int id;
    private String name;
    private int Points;

    public SportStatistic(int id, String name, int Points) {
        this.id = id;
        this.name = name;
        this.Points = Points;

    }

    public SportStatistic() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return Points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int Points) {
        this.Points = Points;
    }

}
