package uber_UFPAA;

public class Facade {
    protected Carro c;
    protected Passageiro p;
    protected Motorista m;

    public Facade(Carro c, Passageiro p, Motorista m) {
        this.c = c;
        this.p = p;
        this.m = m;
    }
    
    public Carro getC() {
        return c;
    }
    public void setC(Carro c) {
        this.c = c;
    }
    public Passageiro getP() {
        return p;
    }
    public void setP(Passageiro p) {
        this.p = p;
    }
    public Motorista getM() {
        return m;
    }
    public void setM(Motorista m) {
        this.m = m;
    }
 }
