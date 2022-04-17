package uber_UFPAA;

class Passageiro {
    private String nome_passageiro;
    private double saldoPassageiro;

    public Passageiro(String nome_passageiro, double saldoPassageiro) {
        this.nome_passageiro = nome_passageiro;
        this.saldoPassageiro = saldoPassageiro;
    }

    public String getNome_passageiro() {
        return nome_passageiro;
    }

    public void setNome_passageiro(String nome_passageiro) {
        this.nome_passageiro = nome_passageiro;
    }
    
    public double getSaldoPassageiro() {
        return saldoPassageiro;
    }

    public void setSaldoPassageiro(double saldoPassageiro) {
        this.saldoPassageiro = saldoPassageiro;
    }
}
