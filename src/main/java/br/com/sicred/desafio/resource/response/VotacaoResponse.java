package br.com.sicred.desafio.resource.response;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import br.com.sicred.desafio.model.Votacao;
import br.com.sicred.desafio.util.enums.VotoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa a resopsta das chamadas aos endpoints de votação")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoResponse {
     
     @ApiModelProperty(value = "Identificador votação", name = "Identificador votação")
     private Long id;
     
     @ApiModelProperty(value = "CPF votante", name = "CPF votante")
     @NotNull
     private String cpf;

     @ApiModelProperty(value = "Data votação", name = "Data votação")
	@NotNull
	private LocalDateTime dataVotacao;
     
     @Schema(name = "Voto")
     @NotNull
     private VotoEnum voto;
     
     @Schema(name = "Id sessão")
     @NotNull
     private Long idSessao;
	
	
	public VotacaoResponse(Votacao votacao) {
	     this.id = votacao.getId();
		this.cpf = votacao.getCpf();
		this.dataVotacao = votacao.getDataVoto();
		this.voto = votacao.getVoto();
		this.idSessao = votacao.getSessao().getId();
	}

     public static VotacaoResponse converter(Votacao votacao) {
          return new VotacaoResponse(votacao.getId(), votacao.getCpf(), votacao.getDataVoto(), votacao.getVoto(), votacao.getSessao().getId());
     }
}