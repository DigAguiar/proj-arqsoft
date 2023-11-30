package ucsal.br.dd.project.solicitacao.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucsal.br.dd.project.solicitacao.entities.Solicitacoes;

@Repository
public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Long>{
    Optional<List<Solicitacoes>> findByProfessorId(Long professorId);
    Optional<List<Solicitacoes>> findByDisciplina(String disciplina);
}
