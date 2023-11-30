package ucsal.br.dd.project.solicitacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucsal.br.dd.project.solicitacao.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
