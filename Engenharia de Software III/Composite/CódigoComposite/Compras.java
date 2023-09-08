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