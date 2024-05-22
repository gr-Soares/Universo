package org.fema.dao;

import org.fema.beans.Galaxia;
import org.fema.beans.TipoGalaxia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GalaxiaDAO {

    private Connection cnn = null;

    public GalaxiaDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public void cadastrar(Galaxia galaxia)throws SQLException {
        String sql = "insert into galaxia values (?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, galaxia.getCod());
        ps.setString(2, galaxia.getNome());
        ps.setString(3, galaxia.getTipo().getValue());
        ps.execute();
        ps.close();
    }

    public void atualizar(Galaxia galaxia)throws SQLException {
        String sql = "update galaxia set nome = ?, tipo = ? "
                + " where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(3, galaxia.getCod());
        ps.setString(1, galaxia.getNome());
        ps.setString(2, galaxia.getTipo().getValue());
        ps.execute();
        ps.close();
    }

    public void excluir(Galaxia galaxia)throws SQLException {
        String sql = "delete from galaxia where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, galaxia.getCod());
        ps.execute();
        ps.close();
    }

    public ArrayList<Galaxia> listar()throws SQLException{
        ArrayList<Galaxia> resultado = new ArrayList<Galaxia>();
        String sql = "select * from galaxia order by cod";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Galaxia galaxia = new Galaxia();
            galaxia.setCod(rs.getInt("cod"));
            galaxia.setNome(rs.getString("nome"));
            switch (rs.getString("Tipo")){
                case "Espiral":
                    galaxia.setTipo(TipoGalaxia.ESPIRAL);
                case "Eliptica":
                    galaxia.setTipo(TipoGalaxia.ELIPTICA);
                case "Irregular":
                    galaxia.setTipo(TipoGalaxia.IRREGULAR);
            }
            resultado.add(galaxia);
        }
        rs.close();
        ps.close();
        return resultado;
    }

    public Galaxia recuperar(int cod)throws SQLException{
        Galaxia resultado = null;
        String sql = "select * from galaxia where cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resultado = new Galaxia();
            resultado.setCod(rs.getInt("cod"));
            resultado.setNome(rs.getString("nome"));
            switch (rs.getString("Tipo")){
                case "Espiral":
                    resultado.setTipo(TipoGalaxia.ESPIRAL);
                case "Eliptica":
                    resultado.setTipo(TipoGalaxia.ELIPTICA);
                case "Irregular":
                    resultado.setTipo(TipoGalaxia.IRREGULAR);
            }
        }
        rs.close();
        ps.close();
        return resultado;
    }

}
