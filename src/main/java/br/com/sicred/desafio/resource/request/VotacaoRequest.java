package br.com.sicred.desafio.resource.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.com.sicred.desafio.model.Sessao;
import br.com.sicred.desafio.model.Votacao;
import br.com.sicred.desafio.util.enums.VotoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa a request das chamadas aos endpoints de votação")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoRequest {
     
     @ApiModelProperty(value = "CPF votante", name = "CPF votante", position = 1)
     @NotNull
     private String cpf;

     @ApiModelProperty(value = "Data votação", name = "Data votação", position = 2)
	@NotNull
	private LocalDateTime dataVotacao;
     
     @ApiModelProperty(value = "Voto", name = "Voto", position = 3)
     @NotNull
     private VotoEnum voto;
     
     @ApiModelProperty(value = "Id sessão", name = "Id sessão", position = 4)
     @NotNull
     private Long idSessao;
	
	
	public VotacaoRequest(Votacao votacao) {
		this.cpf = votacao.getCpf();
		this.dataVotacao = votacao.getDataVoto();
		this.voto = votacao.getVoto();
		this.idSessao = votacao.getSessao().getId();
	}

	public Votacao converter() {
		return new Votacao(null, this.cpf, this.dataVotacao,this.voto, new Sessao(this.idSessao, null, null, null));
	}

	public static VotacaoRequest convertToRequest(Votacao votacao) {
		return new VotacaoRequest(votacao);
	}
}