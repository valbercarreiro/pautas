package br.com.sicred.desafio.resource.response;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.com.sicred.desafio.model.Sessao;
import br.com.sicred.desafio.util.enums.StatusSessaoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa a resposta das chamadas aos endpoints de sessão")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoResponse {

     @ApiModelProperty(value = "Identificador sessão", name = "Identificador sessão")
	private Long id;
     
     @ApiModelProperty(value = "Status sessão", name = "Status sessão")
     @NotNull
     private StatusSessaoEnum status;

     @ApiModelProperty(value = "Data sessão", name = "Data sessão")
     @NotNull
     private LocalDateTime dataSessao;
     
     @ApiModelProperty(value = "Id pauta sessão", name = "Id pauta sessão")
     @NotNull
     private Long idPauta;
	
	public SessaoResponse(Sessao sessao) {
		this.id = sessao.getId();
		this.status = sessao.getStatus();
		this.dataSessao = sessao.getDataSessao();
		this.idPauta = sessao.getPauta().getId();
	}

	public static SessaoResponse converter(Sessao sessao) {
		return new SessaoResponse(sessao.getId(), sessao.getStatus(), sessao.getDataSessao(), sessao.getPauta().getId());
	}

}