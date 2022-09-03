import java.time.LocalDate;
import java.time.Period;

public class FrequenciaCardiaca {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private int anoDeNascimento;

    public FrequenciaCardiaca(String nome, String sobrenome, int anoDeNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.anoDeNascimento = anoDeNascimento;
    }

    private int calcularIdade(){
        LocalDate hoje = LocalDate.now();
        Period diferenca = Period.between(dataNascimento, hoje);
        return diferenca.getYears();
        //return 2022 - anoDeNascimento;
    }

    public int calcularFrequenciaMaxima(){
        return 220 - calcularIdade();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

}
