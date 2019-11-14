/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportapp.bean;

import com.mycompany.sportapp.ConnectionFactory;
import com.mycompany.sportapp.entities.GamesStatistic;
import com.mycompany.sportapp.entities.SportStatistic;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author T4User
 */
@Stateless
public class SportBean {

    public List<SportStatistic> getTeams() {
        List<SportStatistic> teams = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM superettan";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                int Points = data.getInt("points");
                SportStatistic team = new SportStatistic(id, name, Points);
                teams.add(team);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return teams;
    }
    public List<GamesStatistic> getGames() {
        List<GamesStatistic> teams = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM games";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                //String name = data.getString("a_id");
                int homePoints = data.getInt("h_p");
                int awayPoints = data.getInt("a_p");
                int totalPoints = data.getInt("h_id");
                GamesStatistic team = new GamesStatistic(id, homePoints, awayPoints, totalPoints);
                teams.add(team);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return teams;
    }

    public SportStatistic getTeam(int id) {
        SportStatistic team = new SportStatistic();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM superettan WHERE id = " + id;
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
               
                String name = data.getString("name");
                int Points = data.getInt("points");
                team = new SportStatistic(id,name, Points );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return team;
    }

    public int saveGames(GamesStatistic sportStats) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO games VALUES('%d',%d,%d,%d)",
                    sportStats.getId(), sportStats.getHomePoints(), sportStats.getAwayPoints(), sportStats.getTotalPoints());
            return stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    } 
    public int updateMatches(GamesStatistic sportSave) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("UPDATE games SET a_p = %d, h_p = %d, a_p = %d WHERE id=%d", // Detta var ej klar då 
                    //jag testade bara om det fungerade men det ska vara kopplad med min vy
                    sportSave.getAwayPoints(), sportSave.getHomePoints(), sportSave.getTotalPoints(), sportSave.getId());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
