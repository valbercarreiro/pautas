package br.com.sicred.desafio.resource.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.com.sicred.desafio.model.Pauta;
import br.com.sicred.desafio.model.Sessao;
import br.com.sicred.desafio.util.enums.StatusSessaoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa a request das chamadas aos endpoints de sessão")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoRequest {
     
     @ApiModelProperty(value = "Status sessão", name = "Status sessão", position = 1)
     @NotNull
     private StatusSessaoEnum status;

     @ApiModelProperty(value = "Data sessão", name = "Data sessão", position = 2)
	@NotNull
	private LocalDateTime dataSessao;
     
     @ApiModelProperty(value = "Id pauta sessão", name = "Id pauta sessão", position = 3)
     @NotNull
     private Long idPauta;
	
	
	public SessaoRequest(Sessao sessao) {
		this.status = sessao.getStatus();
		this.dataSessao = sessao.getDataSessao();
		this.idPauta = sessao.getPauta().getId();
	}

	public Sessao converter() {
		return new Sessao(null, this.status, this.dataSessao, new Pauta(this.idPauta, null, null));
	}

	public static SessaoRequest convertToRequest(Sessao sessao) {
		return new SessaoRequest(sessao);
	}
}