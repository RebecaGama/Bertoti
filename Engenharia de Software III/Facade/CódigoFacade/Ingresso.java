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