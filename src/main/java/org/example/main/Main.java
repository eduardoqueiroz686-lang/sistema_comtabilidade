package org.example.main;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.ConnectionFactory;
import java.sql.Connection;
import java.time.LocalDate;



public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Testando conexão
            conn = ConnectionFactory.getConnection();
            System.out.println("Conexão estabelecida com sucesso!");

            // Criando DAO
            ProdutoDAO produtoDAO = new ProdutoDAO(conn);
            EntradaProdutoDAO entradaDAO = new EntradaProdutoDAO(conn);
            SaidaProdutoDAO saidaDAO = new SaidaProdutoDAO(conn);
            LucroMensalDAO lucroDAO = new LucroMensalDAO(conn);
            ComparativoLucroDAO comparativoDAO = new ComparativoLucroDAO(conn);

            // Criando um produto de teste
            Produto p = new Produto(0, "Caneta Azul", 1.50, 100);

            // Inserindo no banco
            produtoDAO.inserir(p);
            System.out.println("Produto inserido com ID: " + p.getId());

            // Listando todos os produtos
            for (Produto prod : produtoDAO.listarTodos()) {
                System.out.println("ID: " + prod.getId() +
                        " | Nome: " + prod.getNome() +
                        " | Preço: " + prod.getPreco() +
                        " | Estoque: " + prod.getEstoque());
            }
            // Registrar entrada
            EntradaProduto entrada = new EntradaProduto(0, p.getId(), 20, LocalDate.now());
            entradaDAO.inserir(entrada);

            System.out.println("\n--- Entradas ---");
            for (EntradaProduto e : entradaDAO.listarTodos()) {
                System.out.println("ID: " + e.getId() +
                        " | Produto ID: " + e.getProdutoId() +
                        " | Quantidade: " + e.getQuantidade() +
                        " | Data: " + e.getDataEntrada());
            }

            // Registrar saída
            SaidaProduto saida = new SaidaProduto(0, p.getId(), 5, LocalDate.now());
            saidaDAO.inserir(saida);

            System.out.println("\n--- Saídas ---");
            for (SaidaProduto s : saidaDAO.listarTodos()) {
                System.out.println("ID: " + s.getId() +
                        " | Produto ID: " + s.getProdutoId() +
                        " | Quantidade: " + s.getQuantidade() +
                        " | Data: " + s.getDataSaida());
            }

            // Gerar lucro mensal
            LucroMensal lucro = new LucroMensal(0, 5, 2026, 2000.0, 1500.0, 500.0);
            lucroDAO.inserir(lucro);

            System.out.println("\n--- Lucros Mensais ---");
            for (LucroMensal lm : lucroDAO.listarTodos()) {
                System.out.println("Mês/Ano: " + lm.getMes() + "/" + lm.getAno() +
                        " | Entradas: " + lm.getTotalEntradas() +
                        " | Saídas: " + lm.getTotalSaidas() +
                        " | Lucro: " + lm.getLucro());
            }
// Comparar lucros anuais
            ComparativoLucro comparativo = new ComparativoLucro(0, 2026, 500.0, 10.0);
            comparativoDAO.inserir(comparativo);

            System.out.println("\n--- Comparativos de Lucro ---");
            for (ComparativoLucro cl : comparativoDAO.listarTodos()) {
                System.out.println("Ano: " + cl.getAno() +
                        " | Lucro Total: " + cl.getLucroTotal() +
                        " | Variação: " + cl.getVariacaoPercentual() + "%");
            }




        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
}
