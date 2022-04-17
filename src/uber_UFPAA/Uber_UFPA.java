package uber_UFPAA;


class Main {
 
    public static void main(String[] args) throws InterruptedException {
        Carro c = new Carro(" Preto", " 123-jgh"," 350z");
        Motorista m = new Motorista("Paulo");
        Passageiro p = new Passageiro(" Cleitinho delas", 100);
        Facade f = new Facade(c, p, m);
        Corrida e = new Corrida();
 
        e.criar();
        e.corrida(f);   
      
    
        
    }
}
