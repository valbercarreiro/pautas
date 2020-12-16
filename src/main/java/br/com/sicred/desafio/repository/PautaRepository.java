package br.com.sicred.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicred.desafio.model.Pauta;

/**
 * @author valbercarreiro
 *
 */
public interface PautaRepository extends JpaRepository<Pauta, Long> {
	
}