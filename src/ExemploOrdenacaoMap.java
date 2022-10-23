/* Dadas as seguintes informações sobre meus livros favoritos e seus respectivos
autores, crie e ordene um dicionário:
exibindo (Nome Autor, Nome Livro) :

Autor: Dean Brown - Livro : O Código Da Vinci , páginas: 475
Autor: Dean Brown - Livro : O Símbolo Perdido , páginas: 496
Autor: George R. R. Martin - Livro : A Guerra dos Tronos , páginas: 592

*/

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("--\t Ordem aleatória \t--");

        Map<String, Livro> meusLivros = new HashMap<>(){{

            put(" Dean Brown ", new Livro("O Código Da Vinci ", 475));
            put(" Bron Dean ", new Livro("O Símbolo Perdido ", 496));
            put(" George R. R. Martin ", new Livro("A Guerra dos Tronos ", 592));
        }};
        for(Map.Entry<String, Livro> livro: meusLivros.entrySet())
        System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem inserção \t--");
        Map<String, Livro> meusLivros1 =  new LinkedHashMap<>(){{
            put("Dean Brown ", new Livro("O Código Da Vinci ", 475));
            put("Bron Dean ", new Livro("O Símbolo Perdido ", 496));
            put("George R. R. Martin ", new Livro("A Guerra dos Tronos ", 592));
        }};
        for (Map.Entry<String, Livro> livro: meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem alfabética autores \t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro: meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem alfabética nome dos livros \t--");
        Set<Map.Entry<String, Livro>>  meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros3)
        System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem número de páginas \t--");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet(new ComparatorPaginas());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4)
            System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());



    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l3, Map.Entry<String, Livro> l4) {
        return l3.getValue().getPaginas().compareTo(l4.getValue().getPaginas());
    }
}