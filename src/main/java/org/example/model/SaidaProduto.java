package org.example.model;

import java.time.LocalDate;

public class SaidaProduto {
    private int id;
    private int produtoId;
    private int quantidade;
    private LocalDate dataSaida;

    public SaidaProduto() {}

    public SaidaProduto(int id, int produtoId, int quantidade, LocalDate dataSaida) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public LocalDate getDataSaida() { return dataSaida; }
    public void setDataSaida(LocalDate dataSaida) { this.dataSaida = dataSaida; }
}
