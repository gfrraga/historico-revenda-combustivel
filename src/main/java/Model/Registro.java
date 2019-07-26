package Model;

import java.util.Date;

public class Registro {
	private Endereco endereco;
	private Produto produto;
	private String revendaInstalacao;
	private String unidadeDeMedida;
	private String bandeira;

	public Registro(Endereco endereco, Produto produto, String revendaInstalacao, String unidadeDeMedida, String bandeira) {
		this.endereco = endereco;
		this.produto = produto;
		this.revendaInstalacao = revendaInstalacao;
		this.unidadeDeMedida = unidadeDeMedida;
		this.bandeira = bandeira;
	}

	public Registro(){}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getRevendaInstalacao() {
		return revendaInstalacao;
	}

	public void setRevendaInstalacao(String revendaInstalacao) {
		this.revendaInstalacao = revendaInstalacao;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
}
