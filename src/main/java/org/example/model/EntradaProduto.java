package org.example.model;

import java.time.LocalDate;

public class EntradaProduto {
    private int id;
    private int produtoId;
    private int quantidade;
    private LocalDate dataEntrada;

    public EntradaProduto() {}

    public EntradaProduto(int id, int produtoId, int quantidade, LocalDate dataEntrada) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

}
