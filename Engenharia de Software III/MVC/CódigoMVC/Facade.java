import java.util.List;

public class Facade {
    private Controller controller;
    private View view;

    public Facade() {
        this.controller = new Controller();
        this.view = new View(controller);
    }

    public List<Show> emitirIngresso() {
        return controller.lista();
       
    }

    public List<Show> imprimir() {
        return controller.lista();
       
    }
}