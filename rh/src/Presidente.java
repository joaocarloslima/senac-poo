public final class Presidente extends Funcionario implements Autenticavel{
    
    private double valorDaCotaDeAcoes;

    public Presidente(int codigo, String nome) {
        super(codigo, nome);
    }


    public double getValorDaCotaDeAcoes() {
        return valorDaCotaDeAcoes;
    }

    public void setValorDaCotaDeAcoes(double valorDaCotaDeAcoes) {
        this.valorDaCotaDeAcoes = valorDaCotaDeAcoes;
    }


    @Override
    public double calcularSalario() {
        return this.getSalario() + valorDaCotaDeAcoes;
    }


    @Override
    public void fazerLogin() {
        System.out.println("Presidente logando...");
        
    }

    

}
