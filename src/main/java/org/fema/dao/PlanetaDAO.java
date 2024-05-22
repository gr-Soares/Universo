package org.fema.dao;

import org.fema.beans.Estrela;
import org.fema.beans.EstrelaTipo;
import org.fema.beans.Planeta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlanetaDAO {
    private Connection cnn = null;

    public PlanetaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public void cadastrar(Planeta planeta)throws SQLException {
        String sql = "insert into planeta values (?,?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, planeta.getCod());
        ps.setString(2, planeta.getNome());
        ps.setBoolean(3, planeta.isHabitavel());
        ps.setInt(4, planeta.getEstrela().getCod());
        ps.execute();
        ps.close();
    }

    public void atualizar(Planeta planeta)throws SQLException {
        String sql = "update planeta set nome = ?, habitavel = ?, estrela = ?"
                + " where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(4, planeta.getCod());
        ps.setString(1, planeta.getNome());
        ps.setBoolean(2, planeta.isHabitavel());
        ps.setInt(3, planeta.getEstrela().getCod());
        ps.execute();
        ps.close();
    }

    public void excluir(Estrela estrela)throws SQLException {
        String sql = "delete from planeta where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, estrela.getCod());
        ps.execute();
        ps.close();
    }

    public ArrayList<Planeta> listar()throws SQLException{
        ArrayList<Planeta> resultado = new ArrayList<Planeta>();
        String sql = "select * from planeta order by cod";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            EstrelaDAO estrelaDAO = new EstrelaDAO(cnn);
            Planeta planeta = new Planeta();
            planeta.setCod(rs.getInt("cod"));
            planeta.setNome(rs.getString("nome"));
            planeta.setHabitavel(rs.getBoolean("habitavel"));
            planeta.setEstrela(estrelaDAO.recuperar(rs.getInt("estrela")));
            resultado.add(planeta);
        }
        rs.close();
        ps.close();
        return resultado;
    }

    public Planeta recuperar(int cod)throws SQLException{
        Planeta resultado = null;
        String sql = "select * from planeta where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resultado = new Planeta();
            EstrelaDAO estrelaDAO = new EstrelaDAO(cnn);
            resultado.setCod(rs.getInt("cod"));
            resultado.setNome(rs.getString("nome"));
            resultado.setHabitavel(rs.getBoolean("habitavel"));
            resultado.setEstrela(estrelaDAO.recuperar(rs.getInt("estrela")));
        }
        rs.close();
        ps.close();
        return resultado;
    }
}
