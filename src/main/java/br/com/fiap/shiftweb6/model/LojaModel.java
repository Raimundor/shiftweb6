package br.com.fiap.shiftweb6.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SHIFT6_LOJA")
public class LojaModel {
	@Id
	@Column(name = "ID_LOJA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	@SequenceGenerator(name = "LOJA_SEQ", initialValue = 1, allocationSize = 1)
	private Long idLoja;
	@Column(name = "NOME_LOJA", length = 50, nullable = false)
	private String nomeLoja;
	
	@ManyToMany(mappedBy = "lojas", fetch = FetchType.LAZY)
	private List<ProdutoModel> produtos;
	
	
	
	public List<ProdutoModel> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}


	public LojaModel() {
		super();
	}


	public LojaModel(Long idLoja, String nomeLoja) {
		super();
		this.idLoja = idLoja;
		this.nomeLoja = nomeLoja;
	}


	public Long getIdLoja() {
		return idLoja;
	}


	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}


	public String getNomeLoja() {
		return nomeLoja;
	}


	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}


	@Override
	public String toString() {
		return "LojaModel [idLoja=" + idLoja + ", nomeLoja=" + nomeLoja + "]";
	}
	
	
	

}
