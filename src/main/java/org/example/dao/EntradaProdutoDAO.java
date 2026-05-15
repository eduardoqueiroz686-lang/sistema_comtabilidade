package org.example.dao;

import org.example.model.EntradaProduto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntradaProdutoDAO {
    private Connection conn;

    public EntradaProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir nova entrada
    public void inserir(EntradaProduto entrada) {
        String sql = "INSERT INTO entrada_produto (produto_id, quantidade, data_entrada) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, entrada.getProdutoId());
            stmt.setInt(2, entrada.getQuantidade());
            stmt.setDate(3, Date.valueOf(entrada.getDataEntrada()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                entrada.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as entradas
    public List<EntradaProduto> listarTodos() {
        List<EntradaProduto> entradas = new ArrayList<>();
        String sql = "SELECT * FROM entrada_produto";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EntradaProduto entrada = new EntradaProduto();
                entrada.setId(rs.getInt("id"));
                entrada.setProdutoId(rs.getInt("produto_id"));
                entrada.setQuantidade(rs.getInt("quantidade"));
                entrada.setDataEntrada(rs.getDate("data_entrada").toLocalDate());
                entradas.add(entrada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entradas;
    }
}
