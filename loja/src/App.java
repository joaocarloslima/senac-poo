import model.Livro;
import model.Produto;

public class App {
    public static void main(String[] args) throws Exception {
       Produto produto1 = new Produto();
       produto1.setDescricao("notebook");
       produto1.setPreco(5000);

       Produto produto2 = new Produto("PC", 4000);

       Livro livro = new Livro();
       

    }
}
