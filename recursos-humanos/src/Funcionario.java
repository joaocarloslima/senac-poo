import java.math.BigDecimal;

public class Funcionario {

    private String nome;
    private String sobrenome;
    private BigDecimal salario;

    //construtor padrão
    public Funcionario(){

    }

    public Funcionario(String nome, String sobrenome, BigDecimal salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        setSalario(salario);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("Salário inválido");
            return;
        }
            
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome= " + nome + " " + sobrenome + " " + salario;
    }

    public BigDecimal calcularAumento(double percentual){
        return this.salario.multiply(new BigDecimal(percentual));
    }

}
