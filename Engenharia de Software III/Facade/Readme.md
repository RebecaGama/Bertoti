# Facade

>Exemplo

![DiagramaFacade](https://github.com/RebecaGama/Bertoti/assets/102360635/af9fa710-010b-4aa8-922c-a5ce7670605a)

>Código

```java
class Ingresso {
    private PistaIngresso pistaIngresso;
    private FrontStageIngresso frontStageIngresso;
    private CamaroteIngresso camaroteIngresso;

    public Ingresso() {
        pistaIngresso = new PistaIngresso();
        frontStageIngresso = new FrontStageIngresso();
        camaroteIngresso = new CamaroteIngresso();
    }

    public void comprarPista(String pistaFile) {
        pistaIngresso.comprarPista(pistaFile);
    }

    public void comprarFrontStage(String frontStageFile) {
        frontStageIngresso.comprarFrontStage(frontStageFile);
    }

    public void comprarCamarote(String camaroteFile) {
        camaroteIngresso.comprarCamarote(camaroteFile);
    }
}
```

```java
class PistaIngresso {
    public void comprarPista(String pistaFile) {
        System.out.println("Comprando ingresso Pista: " + pistaFile);
    }
}
```

```java
class FrontStageIngresso {
    public void comprarFrontStage(String frontStageFile) {
        System.out.println("Comprando ingresso FrontStage: " + frontStageFile);
    }
}
```

```java
class CamaroteIngresso {
    public void comprarCamarote(String camaroteFile) {
        System.out.println("Comprando ingresso Camarote: " + camaroteFile);
    }
}
```
