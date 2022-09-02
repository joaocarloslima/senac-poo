import model.Conta;
import model.ContaPoupanca;
import model.ContaVip;

public class App {
    public static void main(String[] args) throws Exception {
        
        var contaCorrente = new Conta(1234);
        var contaPoupanca = new ContaPoupanca(78940);
        var contaVip = new ContaVip(654987);
        contaVip.setLimite(1000);

        System.out.println(contaCorrente.getSaldo());
        System.out.println(contaPoupanca.getSaldo());
        System.out.println("Saldo Vip:" + contaVip.getSaldo());

    }
}
