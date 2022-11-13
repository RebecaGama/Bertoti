/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.ArrayList;

/**
 *
 * @author Rebeca
 */
public class Fornecedor {
    private int Cnpj;
    private String Nome;
    ArrayList<Produto> ListaProd;

    public Fornecedor() {
        ListaProd = new ArrayList();
    }

    public Fornecedor(int Cnpj, String Nome) {
        this.Cnpj = Cnpj;
        this.Nome = Nome;
        ListaProd = new ArrayList();
    }


    public int getCnpj() {
        return Cnpj;
    }

    public void setCnpj(int Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<Produto> getListaProd() {
        return ListaProd;
    }

    public void setListaProd(ArrayList<Produto> ListaProd) {
        this.ListaProd = ListaProd;
    }
    
    public void addProd(Produto P){
        P.setForn(this);
        ListaProd.add(P);
    }
}    