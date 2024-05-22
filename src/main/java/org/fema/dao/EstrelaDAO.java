package org.fema.dao;

import org.fema.beans.Estrela;
import org.fema.beans.EstrelaTipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstrelaDAO {
    private Connection cnn = null;

    public EstrelaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public void cadastrar(Estrela estrela)throws SQLException {
        String sql = "insert into estrela values (?,?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, estrela.getCod());
        ps.setString(2, estrela.getNome());
        ps.setString(3, estrela.getTipo().getValue());
        ps.setInt(4, estrela.getGalaxia().getCod());
        ps.execute();
        ps.close();
    }

    public void atualizar(Estrela estrela)throws SQLException {
        String sql = "update estrela set nome = ?, tipo = ?, galaxia = ?"
                + " where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(4, estrela.getCod());
        ps.setString(1, estrela.getNome());
        ps.setString(2, estrela.getTipo().getValue());
        ps.setInt(3, estrela.getGalaxia().getCod());
        ps.execute();
        ps.close();
    }

    public void excluir(Estrela estrela)throws SQLException {
        String sql = "delete from estrela where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, estrela.getCod());
        ps.execute();
        ps.close();
    }

    public ArrayList<Estrela> listar()throws SQLException{
        ArrayList<Estrela> resultado = new ArrayList<Estrela>();
        String sql = "select * from galaxia order by cod";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            GalaxiaDAO galaxiaDao = new GalaxiaDAO(cnn);
            Estrela estrela = new Estrela();
            estrela.setCod(rs.getInt("cod"));
            estrela.setNome(rs.getString("nome"));
            switch (rs.getString("Tipo")){
                case "Anã":
                    estrela.setTipo(EstrelaTipo.ANA);
                case "Gigante Vermelha":
                    estrela.setTipo(EstrelaTipo.GIGANTE_VERMELHA);
                case "Supergigante Vermelha":
                    estrela.setTipo(EstrelaTipo.SUPERGIGANTE_VERMELHA);
                case "Nebulosa Planetaria":
                    estrela.setTipo(EstrelaTipo.NEBULOSA_PLANETARIA);
                case "Anã Branca":
                    estrela.setTipo(EstrelaTipo.ANA_BRANCA);
            }
            estrela.setGalaxia(galaxiaDao.recuperar(rs.getInt("galaxia")));
            resultado.add(estrela);
        }
        rs.close();
        ps.close();
        return resultado;
    }

    public Estrela recuperar(int cod)throws SQLException{
        Estrela resultado = null;
        String sql = "select * from estrela where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resultado = new Estrela();
            GalaxiaDAO galaxiaDao = new GalaxiaDAO(cnn);
            resultado.setCod(rs.getInt("cod"));
            resultado.setNome(rs.getString("nome"));
            switch (rs.getString("Tipo")){
                case "Anã":
                    resultado.setTipo(EstrelaTipo.ANA);
                case "Gigante Vermelha":
                    resultado.setTipo(EstrelaTipo.GIGANTE_VERMELHA);
                case "Supergigante Vermelha":
                    resultado.setTipo(EstrelaTipo.SUPERGIGANTE_VERMELHA);
                case "Nebulosa Planetaria":
                    resultado.setTipo(EstrelaTipo.NEBULOSA_PLANETARIA);
                case "Anã Branca":
                    resultado.setTipo(EstrelaTipo.ANA_BRANCA);
            }
            resultado.setGalaxia(galaxiaDao.recuperar(rs.getInt("galaxia")));
        }
        rs.close();
        ps.close();
        return resultado;
    }
}
