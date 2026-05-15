package org.example.dao;

import org.example.model.ComparativoLucro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComparativoLucroDAO {
    private Connection conn;

    public ComparativoLucroDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir comparativo de lucro anual
    public void inserir(ComparativoLucro comparativo) {
        String sql = "INSERT INTO comparativo_lucro (ano, lucro_total, variacao_percentual) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, comparativo.getAno());
            stmt.setDouble(2, comparativo.getLucroTotal());
            stmt.setDouble(3, comparativo.getVariacaoPercentual());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                comparativo.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os comparativos de lucro
    public List<ComparativoLucro> listarTodos() {
        List<ComparativoLucro> comparativos = new ArrayList<>();
        String sql = "SELECT * FROM comparativo_lucro";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ComparativoLucro cl = new ComparativoLucro();
                cl.setId(rs.getInt("id"));
                cl.setAno(rs.getInt("ano"));
                cl.setLucroTotal(rs.getDouble("lucro_total"));
                cl.setVariacaoPercentual(rs.getDouble("variacao_percentual"));
                comparativos.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comparativos;
    }
}
