public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador("José");

        System.out.println(jogador1.getHp());
        jogador1.receberDano(10);
        System.out.println(jogador1.getHp());
        
        //jogador1.receberAntidoto();

        String mensagem = (jogador1.isEnvenenado())?"está envenenado":"não está envenenado";
        System.out.println(mensagem);


        
    }
}
