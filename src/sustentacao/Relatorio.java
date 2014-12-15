package sustentacao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_relatorio")
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	private Date data;

	@Column(name = "concluido")
	private int chamadosConcluidos;

	@Column(name = "homologacao")
	private int chamadosEmHomologacao;

	@Column(name = "aguardando")
	private int chamadosEmAguardo;

	@Column(name = "aguardando_rdm")
	private int chamadosAguardandoRdm;

	@Column(name = "desenvolvimento")
	private int chamadosEmDesenvolvimento;

	@Column(name = "aberto")
	private int chamadosEmAberto;

	@ManyToOne
	private Equipe equipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getChamadosConcluidos() {
		return chamadosConcluidos;
	}

	public void setChamadosConcluidos(int chamadosConcluidos) {
		this.chamadosConcluidos = chamadosConcluidos;
	}

	public int getChamadosEmHomologacao() {
		return chamadosEmHomologacao;
	}

	public void setChamadosEmHomologacao(int chamadosEmHomologacao) {
		this.chamadosEmHomologacao = chamadosEmHomologacao;
	}

	public int getChamadosEmAguardo() {
		return chamadosEmAguardo;
	}

	public void setChamadosEmAguardo(int chamadosEmAguardo) {
		this.chamadosEmAguardo = chamadosEmAguardo;
	}

	public int getChamadosAguardandoRdm() {
		return chamadosAguardandoRdm;
	}

	public void setChamadosAguardandoRdm(int chamadosAguardandoRdm) {
		this.chamadosAguardandoRdm = chamadosAguardandoRdm;
	}

	public int getChamadosEmDesenvolvimento() {
		return chamadosEmDesenvolvimento;
	}

	public void setChamadosEmDesenvolvimento(int chamadosEmDesenvolvimento) {
		this.chamadosEmDesenvolvimento = chamadosEmDesenvolvimento;
	}

	public int getChamadosEmAberto() {
		return chamadosEmAberto;
	}

	public void setChamadosEmAberto(int chamadosEmAberto) {
		this.chamadosEmAberto = chamadosEmAberto;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
}