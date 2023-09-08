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