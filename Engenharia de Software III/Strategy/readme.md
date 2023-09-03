# Strategy

>Exemplo

![DiagramaDeClasse](https://github.com/RebecaGama/Bertoti/assets/102360635/5093920a-15fe-4ceb-bb5b-102e406f6afe)

>Código

```java
public class Cliente {
   
    private String entradaDescricao;
    private Show show;
    
    public Cliente(String descricao,Show show){
        this.entradaDescricao = descricao;
        this.show = show;
    }

    public String getEntradaDescricao() {
        return entradaDescricao;
    }
    
    public void participar(){
        show.participar();
    }
    
    public void setShow(Show show){
        this.show = show;
    }
}
```

```java
public interface Show {
    
    void participar();
}
```

```java
public class EntradaPista implements Show {
    
    public void participar(){
        System.out.println("Ingresso de entrada pista.");
    }
}
```

```java
public class EntradaCamarote implements Show {
    
    public void participar(){
        System.out.println("Ingresso de entrada Camarote.");
    }
}
```
