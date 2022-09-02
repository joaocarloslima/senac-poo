public abstract class Funcionario {
    private int codigo;
    private String nome;
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public abstract double calcularSalario();

    int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome + " " + codigo;
    }

    

}
