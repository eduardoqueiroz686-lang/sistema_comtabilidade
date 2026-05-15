package org.example.dao;

import org.example.model.SaidaProduto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaidaProdutoDAO {
    private Connection conn;

    public SaidaProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir nova saída
    public void inserir(SaidaProduto saida) {
        String sql = "INSERT INTO saida_produto (produto_id, quantidade, data_saida) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, saida.getProdutoId());
            stmt.setInt(2, saida.getQuantidade());
            stmt.setDate(3, Date.valueOf(saida.getDataSaida()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                saida.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as saídas
    public List<SaidaProduto> listarTodos() {
        List<SaidaProduto> saidas = new ArrayList<>();
        String sql = "SELECT * FROM saida_produto";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SaidaProduto saida = new SaidaProduto();
                saida.setId(rs.getInt("id"));
                saida.setProdutoId(rs.getInt("produto_id"));
                saida.setQuantidade(rs.getInt("quantidade"));
                saida.setDataSaida(rs.getDate("data_saida").toLocalDate());
                saidas.add(saida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saidas;
    }
}
