package br.com.sicred.desafio.resource;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicred.desafio.model.Pauta;
import br.com.sicred.desafio.resource.request.PautaRequest;
import br.com.sicred.desafio.resource.response.PautaResponse;
import br.com.sicred.desafio.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "PAUTAS", produces = MediaType.APPLICATION_JSON_VALUE, tags = { "PAUTAS" })
@RestController
@RequestMapping("/pautas")
public class PautaResource {
	
	@Autowired
	private PautaService service;
	
	@ApiOperation(value = "Listagem de Pautas", notes = "Recurso para listagem de todas as pautas cadastradas", response = PautaResponse.class)
	@GetMapping
	public List<PautaResponse> lista() {
		List<Pauta> pautas = service.findAll();
		return PautaResponse.converter(pautas);
	}
	
	@ApiOperation(value = "Salvar Pautas", notes = "Recurso para criação de novas pautas", response = PautaResponse.class, nickname = "salvarPautas")
	@PostMapping
	@Transactional
	public ResponseEntity<PautaResponse> cadastrar(@RequestBody @Valid PautaRequest req) {
		Pauta pauta = req.converter();
		try {
			pauta = service.saveOrUpdate(pauta);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(PautaResponse.converter(pauta));
	}
	
	@ApiOperation(value = "Consultar Pautas", notes = "Recurso para consulta de pautas", response = PautaResponse.class, nickname = "consultarPautas")
	@GetMapping("/{id}")
	public ResponseEntity<PautaResponse> consultar(@PathVariable Long id) {
		Optional<Pauta> pauta = service.findById(id);
		if (pauta.isPresent()) {
			return ResponseEntity.ok(PautaResponse.converter(pauta.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Alterar Pautas", notes = "Recurso para alteração de pautas existentes", response = PautaResponse.class, nickname = "alterarPautas")
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PautaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid PautaRequest req) {
		Optional<Pauta> pauta = service.findById(id);
		if (pauta.isPresent()) {
			Pauta alterar = req.converter();
			alterar.setId(id);
			try {
				alterar = service.saveOrUpdate(alterar);
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(PautaResponse.converter(alterar));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Remover Pautas", notes = "Recurso para remoção de pautas existentes")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Pauta> pauta = service.findById(id);
		if (pauta.isPresent()) {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}