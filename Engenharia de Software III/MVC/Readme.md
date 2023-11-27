# MVC (Strategy + Composite + Observer + Facade + Singleton)

>Exemplo

![DiagramaMVC](https://github.com/RebecaGama/Bertoti/assets/102360635/0817cded-eeaf-4d04-ac20-6e6f061c6ed6)


>Código

```java
package view;
import java.util.List;

public interface Observer {

    public void update(List l);

}
```

```java
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
```

```java
package controler;

public interface Ingresso {
    public void emitirIngresso();

}
```

```java
package controler;

import model.Catalogo;
import view.View;

public class TipoPista implements Ingresso{

    private View v;
    private Catalogo c;

    public void setV(View view){
        v = view;
    }

    public void emitirIngresso(){
        v.imprimirDadosFilme();
        v.imprimirTipoPista();
    }

}
```

```java
package controler;

import model.Catalogo;
import view.View;

public class TipoCamarote implements Ingresso{

    private View v;
    private Catalogo c;

    public void setV(View view){
        v = view;
    }

    public void emitirIngresso(){
        v.imprimirDadosFilme();
    }

}
```

```java
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

```

```java
package model;

import java.util.List;

import view.Observer;

public interface Subject {

    public void registerObserver(Observer o);
    public void notifyObservers(List encontrados);

}
```

```java
package model;

public class Show {

    private String artista;
    private int data;

    public Show(String a, int d){
        artista = a;
        data = d;
    }

    public String getArtista(){
        return artista;
    }

    public int getData(){
        return data;
    }

    public boolean matches(Show s){
        if(!artista.equals(s.artista)) return false;
        if(data!=s.data) return false;
        return true;
    }

}
```

```java
import java.util.List;

public class Facade {
    private Controller controller;
    private View view;

    public Facade() {
        this.controller = new Controller();
        this.view = new View(controller);
    }

    public List<Show> emitirIngresso() {
        return controller.lista();
       
    }

    public List<Show> imprimir() {
        return controller.lista();
       
    }
}
```

```java
import java.util.List;

class Observador implements Observer {
    private String email;

    public Observador(String email) {
        this.artista = artista;
    }

    public void update(List l) {
        System.out.println("A lista foi atualizada");
      
    }

}
```
