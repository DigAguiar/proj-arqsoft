package ucsal.br.dd.project.solicitacao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitacoes")
public class Solicitacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long professorId;
	private String data;
	private String hora;
	private String min;
	private String disciplina;
	private String status;
	private Long idLaboratorio;

	public Solicitacoes(Long professorId, String data, String hora, String min, String disciplina, String status, Long idLaboratorio) {
		this.professorId = professorId;
		this.data = data;
		this.hora = hora;
		this.min = min;
		this.disciplina = disciplina;
		this.status = status;
		this.idLaboratorio = idLaboratorio;
	}
}
