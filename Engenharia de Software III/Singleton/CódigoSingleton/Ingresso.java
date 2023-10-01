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