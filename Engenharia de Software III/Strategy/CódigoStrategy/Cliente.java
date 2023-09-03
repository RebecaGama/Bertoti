public class Cliente {
   
    private String entradaDescricao;
    private Show show;
    
    public Cliente(String descricao,Show show){
        this.entradaDescricao = descricao;
        this.show = show;
    }

    public String getEntradaDescricao() {
        return entradaDescricao;
    }
    
    public void participar(){
        show.participar();
    }
    
    public void setShow(Show show){
        this.show = show;
    }
}