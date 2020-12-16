package br.com.sicred.desafio.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import br.com.sicred.desafio.util.enums.StatusSessaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author valbercarreiro
 *
 */

@Table(name="SESSOES", indexes = @Index(columnList = "PAUTAS_ID", name = "sessoes_FKIndex1"))
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false )
@ToString(of = { "id" })
public class Sessao implements Serializable {

     private static final long serialVersionUID = -5527745931349773571L;

     @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="STATUS_SESSAO")
	private StatusSessaoEnum status;
	
	@Column(name="DATA_SESSAO")
	private LocalDateTime dataSessao;
	
	@OneToOne
     @JoinColumn(name = "PAUTAS_ID", referencedColumnName = "ID")
	private Pauta pauta;
	
}