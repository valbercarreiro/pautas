package br.com.sicred.desafio.resource.response;

import java.util.ArrayList;
import java.util.List;

import br.com.sicred.desafio.model.Pauta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa a resposta das chamadas aos endpoints de pauta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaResponse {

     @ApiModelProperty(value = "Identificador pauta", name = "Identificador pauta")
	private Long id;
     
     @ApiModelProperty(value = "Título pauta", name = "Título pauta")
     private String titulo;

     @ApiModelProperty(value = "Descrição pauta", name = "Descrição pauta")
	private String descricao;
	
	public PautaResponse(Pauta pauta) {
		this.id = pauta.getId();
		this.titulo = pauta.getTitulo();
		this.descricao = pauta.getDescricao();
	}
	
	public static PautaResponse converter(Pauta pauta) {
	     return new PautaResponse(pauta.getId(), pauta.getTitulo(), pauta.getDescricao());
	}

	public static List<PautaResponse> converter(List<Pauta> pautas) {
	     List<PautaResponse> responses = new ArrayList<PautaResponse>();
	     pautas.forEach(p -> responses.add(new PautaResponse(p.getId(), p.getTitulo(), p.getDescricao())));	     
		return responses;
	}

}