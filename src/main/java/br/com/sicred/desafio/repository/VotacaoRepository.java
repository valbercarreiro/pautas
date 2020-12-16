package br.com.sicred.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sicred.desafio.model.Votacao;

/**
 * @author valbercarreiro
 *
 */
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
     
//     @Query("select count(v)>0 from Votacao v where v.cpf = :cpf AND v.sessao.id = :idSessao")
//     public boolean existsVotacao(@Param("cpf") String cpf, @Param("idSessao") Long idSessao);
	
}