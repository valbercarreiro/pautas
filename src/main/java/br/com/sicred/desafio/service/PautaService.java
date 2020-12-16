package br.com.sicred.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicred.desafio.model.Pauta;
import br.com.sicred.desafio.repository.PautaRepository;

/**
 * @author valbercarreiro
 *
 */

@Service
public class PautaService {

	@Autowired
	private PautaRepository repositorio;
	
	public Pauta saveOrUpdate(Pauta pauta) throws Exception {
		return repositorio.save(pauta);
	}
	
	public Optional<Pauta> findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public List<Pauta> findAll() {
		return repositorio.findAll();
	}
	
}