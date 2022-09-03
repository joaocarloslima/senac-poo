import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {

        var funcionario = new Funcionario("João", "Lima", new BigDecimal(2000));
        
        System.out.println(funcionario);
    }
}
