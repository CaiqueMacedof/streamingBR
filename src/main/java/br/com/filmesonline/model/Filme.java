package br.com.filmesonline.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	private int ano;

	// O atributo mappedBy é usado apenas em entidade que não faça um insert em duas
	// tabelas ao mesmo tempo, caso contrário na entidade da chave estrangeira,
	// não será possível de ser inserida, então neste caso a solução foi retirar o
	// atributo mappedBy do @oneToMany e colocar outro @JoinColumn nessa entidade.
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "filme_id")
	private List<Classificacao> classificacao;

	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Column(length = 510)
	private String caminhoImagem;

	public Filme() {
	}

	public Filme(String nome, String descricao, int ano, List<Classificacao> classificacao, Genero genero,
			Usuario usuario, String caminhoImagem) {
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
		this.classificacao = classificacao;
		this.genero = genero;
		this.usuario = usuario;
		this.caminhoImagem = caminhoImagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Classificacao> getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(List<Classificacao> classificacao) {
		this.classificacao = classificacao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", ano=" + ano + ", classificacao="
				+ classificacao + ", genero=" + genero + "]";
	}

}
