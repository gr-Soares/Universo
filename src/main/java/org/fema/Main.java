package org.fema;

import org.fema.beans.*;
import org.fema.dao.EstrelaDAO;
import org.fema.dao.GalaxiaDAO;
import org.fema.dao.PlanetaDAO;
import org.fema.utils.Conn;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá Universo!");

        // Inserindo Dados

        try {
            Connection cnn = Conn.getConnection();

            Galaxia viaLactea = new Galaxia(1, "Via Lactea", TipoGalaxia.ESPIRAL);

            GalaxiaDAO galaxiaDAO = new GalaxiaDAO(cnn);
            galaxiaDAO.cadastrar(viaLactea);

            Estrela sol = new Estrela(1, "Sol", EstrelaTipo.ANA, viaLactea);

            EstrelaDAO estrelaDAO = new EstrelaDAO(cnn);
            estrelaDAO.cadastrar(sol);

            Planeta mercurio = new Planeta(1, "Mercurio", false, sol);
            Planeta venus = new Planeta(2, "Venus", false, sol);
            Planeta terra = new Planeta(3, "Terra", true, sol);
            Planeta marte = new Planeta(4, "Marte", false, sol);

            PlanetaDAO planetaDAO = new PlanetaDAO(cnn);
            planetaDAO.cadastrar(mercurio);
            planetaDAO.cadastrar(venus);
            planetaDAO.cadastrar(terra);
            planetaDAO.cadastrar(marte);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}