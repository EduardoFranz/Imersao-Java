import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //fazer uma conexão HTTP e buscar os filmes
        //fazendo o GET

        String url = "https://alura-filmes.herokuapp.com/conteudos";

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();


        /*
        Imprime o body(corpo) que vem da API url
        System.out.println(body); 
        */
        

        //pegar apenas os dados que intereção (título, poster, classificação)(parsear os dados)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

       /*
        Lista quantos filmes contém:
        System.out.println(listaDeFilmes.size());

        Lista o contéudo que contém dentro de cada filme
        System.out.println(listaDeFilmes.get(0));
        
        */ 

        //exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }


    }
}


