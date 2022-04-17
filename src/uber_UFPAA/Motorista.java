package uber_UFPAA;
public class Motorista {
    private String nome_motorista;
    private double reputação;
    private int numCorridas = 0;

    public Motorista(String nome_motorista) {
        this.nome_motorista = nome_motorista;
        this.reputação = 0;
    }

    public double getReputção(){
        return reputação;
    }
    
    public void setReputção(double reputação){
        this.reputação = reputação;
    }
    
    public String getNome_motorista() {
        return nome_motorista;
    }

    public void setNome_motorista(String nome_motorista) {
        this.nome_motorista = nome_motorista;
    }

    public int getNumCorridas() {
        return numCorridas;
    }

    public void setNumCorridas(int numCorridas) {
        this.numCorridas = numCorridas;
    }
    
}