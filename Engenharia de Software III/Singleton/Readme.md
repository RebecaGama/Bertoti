# Singleton

>Exemplo

![DiagramaSingleton](https://github.com/RebecaGama/Bertoti/assets/102360635/b28565d9-1597-4a5a-9c6b-10bdb970fed3)

>Código

```java
public static class Ingresso {
  private static Ingresso ingresso;
	private Ingresso(){}
	public void Ingresso getInstance(){
    if(ingresso==null){
      ingresso = new Ingresso;
		}
		return ingresso;
	}

	public comprar(String documento) {
    System.out.println("Comprando: " + documento);
  }
}
```
