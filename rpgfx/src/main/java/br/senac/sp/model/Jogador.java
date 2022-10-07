package br.senac.sp.model;

public class Jogador {

    private String nome;
    private int xp;
    private int hp;
    private boolean envenenado;

    public Jogador(String nome, int xp, int hp, boolean envenenado) {
        this.nome = nome;
        this.xp = xp;
        this.hp = hp;
        this.envenenado = envenenado;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Jogador [nome=" + nome + ", xp=" + xp + ", hp=" + hp + ", envenenado=" + envenenado + "]";
    }

    

}
