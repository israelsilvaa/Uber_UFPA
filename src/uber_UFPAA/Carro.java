package uber_UFPAA;

public class Carro{
    private String cor_do_carro, placa, modelo;
    private double taximetro = 0;

    public Carro(String cor_do_carro, String placa, String modelo) {
        this.cor_do_carro = cor_do_carro;
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getCor_do_carro() {
        return cor_do_carro;
    }

    public void setCor_do_carro(String cor_do_carro) {
        this.cor_do_carro = cor_do_carro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getTaximetro() {
        return taximetro;
    }

    public void setTaximetro(double taximetro) {
        this.taximetro = taximetro;
    }
    
}

