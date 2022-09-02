public class App {
    public static void main(String[] args) throws Exception {
        var funcionario1 = new Engenheiro(22001, "João");
        funcionario1.setSalario(5000);
       
        var funcionario2 = new Gerente(22002, "Maria");
        funcionario2.setSalario(6000);
        funcionario2.setBonus(2000);

        var funcionario3 = new Presidente(22003, "Paula");
        funcionario3.setSalario(10000);
        funcionario3.setValorDaCotaDeAcoes(5000);

        var folha = new FolhaDePagamento();
        
        folha.registrar(funcionario1);
        folha.registrar(funcionario2);
        folha.registrar(funcionario3);
        System.out.println("TOTAL = " + folha.getSalarioTotal());

        ///folha.logar(funcionario1);
        folha.logar(funcionario2);
        folha.logar(funcionario3);
        folha.logar(new Auditor());
        
    }
}
