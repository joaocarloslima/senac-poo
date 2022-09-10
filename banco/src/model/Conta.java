package model;

public class Conta extends Object {
    private int numero;
    protected double saldo;
    
    public Conta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) throws ValorInvalidoException{
        if (valor <= 0) throw new ValorInvalidoException("não pode depositar valor negativo");
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException{
        if (valor > saldo) throw new SaldoInsuficienteException();
        saldo-=valor;
    }

    public void transferir(double valor, Conta contaDestino){
        if (contaDestino == null) throw new NullPointerException("conta não pode ser nula");
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        long temp;
        temp = Double.doubleToLongBits(saldo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (numero != other.numero)
            return false;
        if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
            return false;
        return true;
    }

    


}
