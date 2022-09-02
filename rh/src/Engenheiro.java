public class Engenheiro extends Funcionario {

    public Engenheiro(int codigo, String nome) {
        super(codigo, nome);
        
    }
    private String departamento;
    private int crea;

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public int getCrea() {
        return crea;
    }
    public void setCrea(int crea) {
        this.crea = crea;
    }

    @Override
    public double calcularSalario() {
        return this.getSalario() * 1.5;
    }

    
    
}
