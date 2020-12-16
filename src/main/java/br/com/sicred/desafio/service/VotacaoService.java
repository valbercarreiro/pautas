package br.com.sicred.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.sicred.desafio.model.Sessao;
import br.com.sicred.desafio.model.Votacao;
import br.com.sicred.desafio.repository.SessaoRepository;
import br.com.sicred.desafio.repository.VotacaoRepository;

/**
 * @author valbercarreiro
 *
 */

@Service
public class VotacaoService {

     @Autowired
     private VotacaoRepository repositorio;

     @Autowired
	private SessaoRepository sessaoRepositorio;
	
	public Votacao saveOrUpdate(Votacao votacao) throws Exception {
	     
	     Optional<Sessao> sessao = sessaoRepositorio.findById(votacao.getSessao().getId());
	     if(!sessao.isPresent()) {
	          throw new Exception("Sessão não encontrada.");
	     }
	     votacao.setSessao(sessao.get());
	     
	     ExampleMatcher matcher = ExampleMatcher.matching()
	               .withMatcher("cpf", match -> ExampleMatcher.matching())
	               .withMatcher("sessao.id", match -> ExampleMatcher.matching());
	     Example<Votacao> example = Example.of(votacao, matcher);
	     
	     boolean jaVotou = repositorio.exists(example);
	     if (jaVotou) {
	          throw new Exception("Usuário já efetuou o voto para a sessão indicada.");
	     }
	     
		return repositorio.save(votacao);
	}
	
	public Optional<Votacao> findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public List<Votacao> findAll() {
		return repositorio.findAll();
	}
	
}