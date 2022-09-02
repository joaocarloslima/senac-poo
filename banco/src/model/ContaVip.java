package model;

public class ContaVip extends Conta {

    private double limite;

    public ContaVip(int numero) {
        super(numero);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public double getSaldo() {
       return super.getSaldo() + limite;
    }



    
}
