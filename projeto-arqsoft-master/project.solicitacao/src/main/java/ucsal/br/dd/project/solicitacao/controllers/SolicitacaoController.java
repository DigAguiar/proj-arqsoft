package ucsal.br.dd.project.solicitacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucsal.br.dd.project.solicitacao.dtos.SolicitacaoDTO;
import ucsal.br.dd.project.solicitacao.services.SolicitacaoService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {
 
	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@GetMapping("")
	public ResponseEntity<Object> getListaSolicitacoes () {
		return ResponseEntity.ok(solicitacaoService.getListSolicitacoes());
	}
	@PostMapping("")
	public ResponseEntity<Object> createSolicitacao (@RequestBody SolicitacaoDTO request) {
		solicitacaoService.createSolicitacoes(request);
		return ResponseEntity.status(201).build();
	}
	@GetMapping("/getListProfessorId/{idProfessor}")
	public ResponseEntity<Object> getListaSolicitacoesByIdProfessor (@PathVariable Long idProfessor) {
		var response = solicitacaoService.getListSolicitacoesByProfessorId(idProfessor);
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/getListDisciplinaId/{disciplina}")
	public ResponseEntity<Object> getListaSolicitacoesByIdDisciplina (@PathVariable String disciplina) {
		var response = solicitacaoService.getListSolicitacoesByDisciplinaId(disciplina);
		return ResponseEntity.ok(response);
	}	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSolicitacao (@PathVariable Long id, @RequestBody SolicitacaoDTO request) {
		var response = solicitacaoService.update(id, request);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSolicitacao (@PathVariable Long id) {
		solicitacaoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
