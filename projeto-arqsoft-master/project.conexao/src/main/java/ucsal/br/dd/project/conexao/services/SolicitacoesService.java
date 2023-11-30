package ucsal.br.dd.project.conexao.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SolicitacoesService {

	public List<String> getSolicitacoes() throws URISyntaxException, IOException, InterruptedException{

		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/solicitacao"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            List<String> listaSolicitacoes = new ArrayList<>();
            listaSolicitacoes.add(responseBody);
            return listaSolicitacoes;
        } else {
            throw new IOException("Falha ao obter as solicitações. Código de status: " + response.statusCode());
        }
	}
	
	public List<String> getSolicitacoesByProfesorId(Long idProfessor) throws URISyntaxException, IOException, InterruptedException{

		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/solicitacao/getListProfessorId/"+idProfessor))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            List<String> listaSolicitacoes = new ArrayList<>();
            listaSolicitacoes.add(responseBody);
            return listaSolicitacoes;
        } else {
            throw new IOException("Falha ao obter as solicitações. Código de status: " + response.statusCode());
        }
	}
	public List<String> getSolicitacoesByDisciplina(String disciplina) throws URISyntaxException, IOException, InterruptedException{


		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/solicitacao/getListDisciplinaId/"+disciplina))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            List<String> listaSolicitacoes = new ArrayList<>();
            listaSolicitacoes.add(responseBody);
            return listaSolicitacoes;
        } else {
            throw new IOException("Falha ao obter as solicitações. Código de status: " + response.statusCode());
        }
	}
	
}
