package org.example.model;

public class ComparativoLucro {
    private int id;
    private int ano;
    private double lucroTotal;
    private double variacaoPercentual;

    public ComparativoLucro() {}

    public ComparativoLucro(int id, int ano, double lucroTotal, double variacaoPercentual) {
        this.id = id;
        this.ano = ano;
        this.lucroTotal = lucroTotal;
        this.variacaoPercentual = variacaoPercentual;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getLucroTotal() { return lucroTotal; }
    public void setLucroTotal(double lucroTotal) { this.lucroTotal = lucroTotal; }

    public double getVariacaoPercentual() { return variacaoPercentual; }
    public void setVariacaoPercentual(double variacaoPercentual) { this.variacaoPercentual = variacaoPercentual; }
}

