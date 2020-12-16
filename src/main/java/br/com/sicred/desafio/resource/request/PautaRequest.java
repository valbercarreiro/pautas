package br.com.sicred.desafio.resource.request;

import javax.validation.constraints.NotNull;

import br.com.sicred.desafio.model.Pauta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa a request das chamadas aos endpoints de pauta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaRequest {
     
     @ApiModelProperty(value = "Título da pauta", name = "Título pauta", position = 1)
     @NotNull
     private String titulo;

     @ApiModelProperty(value = "Descrição pauta", name = "Descrição pauta", position = 2)
	@NotNull
	private String descricao;
	
	
	public PautaRequest(Pauta pauta) {
		this.titulo = pauta.getTitulo();
		this.descricao = pauta.getDescricao();
	}

	public Pauta converter() {
		return new Pauta(null, this.titulo, this.descricao);
	}

	public static PautaRequest convertToRequest(Pauta pauta) {
		return new PautaRequest(pauta);
	}
}