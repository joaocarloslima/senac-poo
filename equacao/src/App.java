import javax.swing.JOptionPane;

public class App {

    double a;
    double b;
    double c;

    public static void main(String[] args) throws Exception {
        new App().init();
        //x = -b +/- raiz(delta) / 2
        //delta = b2 - 4ac
    }
    
    private void init(){
        try{
            lerDados();
            double delta = calcularDelta(a, b, c);
            double raiz = calcularRaiz(delta);
            double x1 = (-b + raiz) / (2 * a);
            double x2 = (-b - raiz) / (2 * a);
            JOptionPane.showMessageDialog(null, x1 + " " +x2);

        }catch(DeltaNegativoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Delta negativo");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Número inválido");
        }finally{

        }
    }

    private double calcularRaiz(double valor){
        return Math.sqrt(valor);
    }

    private void lerDados(){
        a = Double.valueOf( JOptionPane.showInputDialog(null, "Digite a:") );
        b = Double.valueOf( JOptionPane.showInputDialog(null, "Digite b:") );
        c = Double.valueOf( JOptionPane.showInputDialog(null, "Digite c:") );
    }

    private double calcularDelta(double a, double b, double c) throws DeltaNegativoException{
        double delta =  b*b - 4*a*c;
        if (delta < 0) throw new DeltaNegativoException("Delta negativo " + delta);
        return delta;
    }
}
