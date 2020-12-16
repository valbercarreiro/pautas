package br.com.sicred.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicred.desafio.model.Sessao;

/**
 * @author valbercarreiro
 *
 */
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
	
}