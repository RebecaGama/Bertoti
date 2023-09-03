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