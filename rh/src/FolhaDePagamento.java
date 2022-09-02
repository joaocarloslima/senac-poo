public class FolhaDePagamento {

    private double salarioTotal = 0;

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void registrar(Funcionario funcionario){
        salarioTotal += funcionario.calcularSalario();
    }

    public void logar(Autenticavel autenticavel){
        autenticavel.fazerLogin();
    }


    
}
