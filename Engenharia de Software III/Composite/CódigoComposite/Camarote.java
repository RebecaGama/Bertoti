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