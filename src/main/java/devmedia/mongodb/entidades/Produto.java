package devmedia.mongodb.entidades;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Produto {
	@Field("nome")
	private String nome;
	@Field("preco")
	private double preco;
	@Field("descricao")
	private String descricao;


	
	public Produto() {}
	
	public Produto(String nome, String descricao, double preco) {
		setNome(nome);
		setDescricao(descricao);
		setPreco(preco);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 
	
	public boolean equals(Object obj) {
		return obj instanceof Produto &&
			   getNome() != null &&
			   getNome().equals(((Produto) obj).getNome()) &&
			   getPreco() == (((Produto) obj).getPreco());
	}
	
	public int hashCode() {
		return (getNome() + "-" + getPreco()).hashCode();
	}
}
