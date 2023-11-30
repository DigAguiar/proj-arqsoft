package ucsal.br.dd.project.conexao.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucsal.br.dd.project.conexao.services.SolicitacoesService;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacoesController {
	
	@Autowired
	private SolicitacoesService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getSolicitacoes() throws URISyntaxException, IOException, InterruptedException{
		var response = service.getSolicitacoes();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/idProf/{idProfessor}")
	public ResponseEntity<Object> getSolicitacoesByProfessorId(@PathVariable Long idProfessor) throws URISyntaxException, IOException, InterruptedException{
		var response = service.getSolicitacoesByProfesorId(idProfessor);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/disciplina/{disciplina}")
	public ResponseEntity<Object> getSolicitacoesByDisciplina(@PathVariable String disciplina) throws URISyntaxException, IOException, InterruptedException{
		var response = service.getSolicitacoesByDisciplina(disciplina);
		return ResponseEntity.ok(response);
	}

}
