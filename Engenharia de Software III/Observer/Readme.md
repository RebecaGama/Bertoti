# Observer

>Exemplo

![DiagramaObserver](https://github.com/RebecaGama/Bertoti/assets/102360635/19bacab5-2c13-4a03-8667-560db6759b48)

>Código

```java
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDados {
    private List<Observer>:observers;
    private funcionarioNome:String
    
    public FuncionarioDados(){
        this.observers = new ArrayList<>();
        this.funcionarioNome = String
    }

    public void setFuncionarioNome(String nome){
        this.empresaNome = nome
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
    
    public void postFuncionarioDados(String nome){
        setFuncionarioNome(nome)
        notify(nome)
    }

    public void notify(String nome){
        this.observers.stream().forEach(item -> {
           item.update(nome) ;
        });
    }
    
}
```

```java
public interface Observer {
    public void update(String nome);
}
```

```java
public class Produtor implements Observer {

    public void update(String nome){
        System.out.println('O nome do funcionario é: '+nome+')
    }
}
```

```java
public class Seguranca implements Observer {

    public void update(String nome){
        System.out.println('O nome do funcionario é: '+nome+')
    }
}
```
