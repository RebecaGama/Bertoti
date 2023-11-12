package model;
import java.util.List;
import java.util.LinkedList;
import view.Observer;

public class Catalogo implements Subject {

    private List<Show> shows;
    private List<Observer> observers;

    public Catalogo(){
        shows = new LinkedList<>();
        observers = new LinkedList<>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void notifyObservers(List encontrados){
        for(Observer o : observers){
            o.update(encontrados);
        }
    }

    public void addShow(Show s){
        shows.add(s);
    }

    public void buscarShow(Show s){
        List<Show> encontrados = new LinkedList<>();
        for(Show showCatalogo : shows){
            if(showCatalogo.matches(s)) {
                encontrados.add(showCatalogo);
            }
        }
        notifyObservers(encontrados);
    }

    public void adicionarShow(String artista, int data){
        Show show = new Show(artista, data);
        addShow(show);
    }

    public void buscarShowPorArtista(String artista){
        Show show = new Show(artista, 0);
        buscarShow(show);
    }

    public void buscarShowPorArtistaEData(String artista, int data){
        Show show = new Show(artista, data);
        buscarShow(show);
    }
}
