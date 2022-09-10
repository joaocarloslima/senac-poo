import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> lista = new ArrayList<>();
        //SOLID
        lista.add("João Carlos");
        lista.add("Maria Silva");
        lista.add("Ana Silva");
        lista.add("Douglas Silva");
        lista.add("Carlos Silva");

        //System.out.println(lista);

        //lista.remove("João Carlos");
        for(int i = 0; i < lista.size(); i++){
            //System.out.println( lista.get(i) );
        }

        for (String aluno : lista) {
            //System.out.println(aluno);
        }

        // lambda expression - arrow function - closure
        Collections.sort(lista);
        //lista.forEach(aluno -> System.out.println(aluno) );



        List<Aluno> listaDeAlunos = new ArrayList<>();
        listaDeAlunos.addAll(List.of(
            new Aluno("Joao", 123, 10), 
            new Aluno("Maria", 456, 9), 
            new Aluno("Ana", 111, 7), 
            new Aluno("Douglas", 678, 9), 
            new Aluno("Carla", 587, 8)
        ));
        Collections.sort(listaDeAlunos);
        
        var comparadorPorNome = new ComparadorPorNome();
        listaDeAlunos.sort(comparadorPorNome);
        //listaDeAlunos.forEach(aluno -> System.out.println(aluno) );
        
        listaDeAlunos.sort(( o1,  o2) -> 
                Double.compare(o1.getNota(),o2.getNota()));
        listaDeAlunos.forEach(aluno -> System.out.println(aluno) );

        listaDeAlunos.sort((a1, a2) -> 
                Integer.compare(a1.getMatricula(), a2.getMatricula()));
        
    }
}
