package org.example.dao;

import org.example.model.LucroMensal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LucroMensalDAO {
    private Connection conn;

    public LucroMensalDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir registro de lucro mensal
    public void inserir(LucroMensal lucroMensal) {
        String sql = "INSERT INTO lucro_mensal (mes, ano, total_entradas, total_saidas, lucro) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, lucroMensal.getMes());
            stmt.setInt(2, lucroMensal.getAno());
            stmt.setDouble(3, lucroMensal.getTotalEntradas());
            stmt.setDouble(4, lucroMensal.getTotalSaidas());
            stmt.setDouble(5, lucroMensal.getLucro());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lucroMensal.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os registros de lucro mensal
    public List<LucroMensal> listarTodos() {
        List<LucroMensal> lucros = new ArrayList<>();
        String sql = "SELECT * FROM lucro_mensal";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LucroMensal lm = new LucroMensal();
                lm.setId(rs.getInt("id"));
                lm.setMes(rs.getInt("mes"));
                lm.setAno(rs.getInt("ano"));
                lm.setTotalEntradas(rs.getDouble("total_entradas"));
                lm.setTotalSaidas(rs.getDouble("total_saidas"));
                lm.setLucro(rs.getDouble("lucro"));
                lucros.add(lm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lucros;
    }
}
