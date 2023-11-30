package ucsal.br.dd.project.solicitacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ucsal.br.dd.project.solicitacao.dtos.SolicitacaoDTO;
import ucsal.br.dd.project.solicitacao.entities.Solicitacoes;
import ucsal.br.dd.project.solicitacao.repositories.SolicitacoesRepository;

@Service
@Transactional
public class SolicitacaoService {

	@Autowired
	private SolicitacoesRepository solicitacoesRepository; 
	
	public List<Solicitacoes> getListSolicitacoes () {
		return solicitacoesRepository.findAll();
	}
	public List<Solicitacoes> getListSolicitacoesByProfessorId (Long professorId) {
		return solicitacoesRepository.findByProfessorId(professorId).get();
	}	
	public List<Solicitacoes> getListSolicitacoesByDisciplinaId (String disciplina) {
		return solicitacoesRepository.findByDisciplina(disciplina).get();
	}
	public Solicitacoes createSolicitacoes (SolicitacaoDTO request) {
		Solicitacoes obj = new Solicitacoes(request.idProfessor(),request.data(),request.hora(),request.min(),request.disciplina(),request.status(),request.laboratorio());
		return solicitacoesRepository.save(obj);
	}
	public List<Solicitacoes> update (Long id, SolicitacaoDTO request) {
		return null;
	}
	public void deleteById (Long id) {
		solicitacoesRepository.deleteById(id);
	}
}
