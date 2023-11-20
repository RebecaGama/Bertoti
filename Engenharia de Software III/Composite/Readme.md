# Composite

>Exemplo

![DiagramaComposite](https://github.com/RebecaGama/Bertoti/assets/102360635/84bb5e74-295c-4bb1-9337-e36730f0c2eb)

>Código

```java
import java.util.ArrayList;
import java.util.List;

public class Compras implements Ingresso {
  private List<Ingresso> ingressos;
  private double valor;

  public Compras() {
    this.ingressos = new ArrayList<>();
    this.valor = 0.00;
  }

  @Override
  public void comprar() {
    System.out.println("Valor da sua compra R$"+this.valor);
  }

  @Override
  public double getValor(){
    return this.valor;
  }

  public void addIngresso(Ingresso ingresso) {
    ingressos.add(ingresso);
    this.valor += ingresso.getValor();
  }

  public void delIngresso(Ingresso ingresso) {
    ingressos.remove(ingresso);
    this.valor -= ingresso.getValor();
  }

  public List<Ingresso> getIngressos() {
    return ingressos;
  }
}
```

```java
public interface Ingresso {
    void comprar();
    double getValor();
}
```

```java
public class Pista implements Produto {
  private String nome;
  private double valor;

  public Pista(String nome, double valor) {
    this.nome = nome;
    this.valor = valor;
  }

public void setPista(Double valor, String nome){
    this.nome = nome
    this.valor = valor
}

  public double getValor() {
    return this.valor;
  }

  @Override
  public void comprar() {
      System.out.println("Comprando ingresso pista " + this.nome + "valor:  " + this.valor);
  }
}
```

```java
public class Camarote implements Produto {
  private String nome;
  private double valor;

  public Camarote(String nome, double valor) {
    this.nome = nome;
    this.valor = valor;
  }

public void setCamarote(Double valor, String nome){
    this.nome = nome
    this.valor = valor
}

  public double getValor() {
    return this.valor;
  }

  @Override
  public void comprar() {
      System.out.println("Comprando ingresso camarote " + this.nome + "valor:  " + this.valor);
  }
}
```
