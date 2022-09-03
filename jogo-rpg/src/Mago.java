public class Mago extends Jogador {
    
    private int mp;

    public void mover(int x, int y){
        System.out.println("Movendo mago para " + x + y);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    

}
