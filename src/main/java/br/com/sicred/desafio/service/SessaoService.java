package br.com.sicred.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicred.desafio.model.Sessao;
import br.com.sicred.desafio.repository.SessaoRepository;

/**
 * @author valbercarreiro
 *
 */

@Service
public class SessaoService {

	@Autowired
	private SessaoRepository repositorio;
	
	public Sessao saveOrUpdate(Sessao sessao) throws Exception {
		return repositorio.save(sessao);
	}
	
	public Optional<Sessao> findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public List<Sessao> findAll() {
		return repositorio.findAll();
	}
	
}