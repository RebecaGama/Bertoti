package view;

import java.util.List;

import model.Show;

import controler.Ingresso;

public class View implements Observer{

    private Ingresso i;
    private List listaShows;

    public void setI(Ingresso ingresso){
        i = ingresso;
    }

    public void update(List l){
        listaShows = l;
        i.emitirIngresso();

    }

    public void imprimirDadosShow(){
        if(!listaShows.isEmpty()){
            for(Object j: listaShows){
                Show s = (Show)j;
                System.out.println(s.getArtista()+" "+s.getData());
            }
        }

    }

    public void imprimirTipoPista(){
        System.out.println("\nTipo: pista");
        System.out.println("CPF do comprador: xxx.xxx.xxx-xx");
    }

}