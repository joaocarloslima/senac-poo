public class App {
    public static void main(String[] args) throws Exception {
        var fase = new Fase();
        var mago = new Mago();

        fase.carregar(mago);
        fase.carregar(new Dragao());


        System.out.println("Hello, World!");
    }
}
