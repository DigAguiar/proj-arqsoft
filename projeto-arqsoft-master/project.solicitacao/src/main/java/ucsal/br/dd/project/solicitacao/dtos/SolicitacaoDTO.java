package ucsal.br.dd.project.solicitacao.dtos;

import ucsal.br.dd.project.solicitacao.entities.Laboratorio;

public record SolicitacaoDTO(
		Long idProfessor,
		 String data,
		 String hora,
		 String min,
		 String disciplina,
		 String status,
		 Long laboratorio) {

}
