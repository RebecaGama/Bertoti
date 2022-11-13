/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author Rebeca
 */
public class Produto {
    private int Codigo;
    private String Nome;
    private Float Preco;
    private int Quantidade;
    private Fornecedor Forn;

    public Produto() {
    }

    public Produto(int Codigo, String Nome, Float Preco, int Quantidade) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Quantidade = Quantidade;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public Float getPreco() {
    return Preco;
    }

    public void setPreco(Float Preco) {
        this.Preco = Preco;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    
    public Fornecedor getForn() {
        return Forn;
    }

    public void setForn(Fornecedor Forn) {
        this.Forn = Forn;
    }
       
}
