package com.example.ws.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.example.util.DBConnection;

public class Etudiant {
    int id;
    String nom;

    public List<Etudiant> findAll(Connection connection) throws ClassNotFoundException, SQLException{
        List<Etudiant> models = new ArrayList<>();
        boolean wasConnected = true;
        if(connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }

        try {
            String sql = "SELECT * FROM etudiant";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Etudiant model = new Etudiant();
                    model.setId(rs.getInt("id"));
                    model.setNom(rs.getString("nom"));
                    models.add(model);
                }
            } 
            return models;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        }
        return models;
    }

    public void save(Connection connection) throws ClassNotFoundException, SQLException{
        boolean wasConnected = true;
        if(connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        try {
            String sql = "INSERT INTO etudiant(id, nom) VALUES (default,?) RETURNING id";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, this.getNom());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    this.setId(rs.getInt("id"));
                }
            } 
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        }
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
