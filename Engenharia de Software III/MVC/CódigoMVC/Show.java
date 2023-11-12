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