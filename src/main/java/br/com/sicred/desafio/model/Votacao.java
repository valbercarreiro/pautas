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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import br.com.sicred.desafio.util.enums.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author valbercarreiro
 *
 */

@Table(name="SESSOES", 
     uniqueConstraints = @UniqueConstraint(columnNames = {"SESSOES_ID","CPF"}, name = "UK_Votacoes"),
     indexes = @Index(columnList = "SESSOES_ID", name = "votacoes_FKIndex1")
)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false )
@ToString(of = { "id" })
public class Votacao implements Serializable {

     private static final long serialVersionUID = -1272272535360888621L;

     @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="DATA_VOTO")
	private LocalDateTime dataVoto;
	
	@Column(name="VOTO")
	private VotoEnum voto;
	
	@ManyToOne
     @JoinColumn(name = "SESSOES_ID", referencedColumnName = "ID")
	private Sessao sessao;
	
}