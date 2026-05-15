package org.example.model;

public class LucroMensal {
    private int id;
    private int mes;
    private int ano;
    private double totalEntradas;
    private double totalSaidas;
    private double lucro;

    public LucroMensal() {}

    public LucroMensal(int id, int mes, int ano, double totalEntradas, double totalSaidas, double lucro) {
        this.id = id;
        this.mes = mes;
        this.ano = ano;
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
        this.lucro = lucro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getTotalEntradas() { return totalEntradas; }
    public void setTotalEntradas(double totalEntradas) { this.totalEntradas = totalEntradas; }

    public double getTotalSaidas() { return totalSaidas; }
    public void setTotalSaidas(double totalSaidas) { this.totalSaidas = totalSaidas; }

    public double getLucro() { return lucro; }
    public void setLucro(double lucro) { this.lucro = lucro; }
}

