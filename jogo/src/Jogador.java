public class Jogador {

    private String nome;
    private int hp = 100;
    private int xp;
    private boolean envenenado;

    public Jogador(){
    }

    public Jogador(String nome){
        this.nome = nome;
    }

    public int getHp(){
        return this.hp;
    }

    public int getXp() {
        return xp;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void receberDano(int pontos){
        hp -= pontos;
    }

    public void receberCura(int pontos){
        hp += pontos;
    }

    public void ganharExperiencia(int pontos){
        xp += pontos;
    }

    public void receberAntidoto(){
        envenenado = !envenenado;
    }
    
    
}
