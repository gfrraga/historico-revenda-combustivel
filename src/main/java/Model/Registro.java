package Model;

import java.util.Date;

public class Registro {
	//Atributos do objeto Registro
	private Endereco endereco;
	private Produto produto;
	private String revendaInstalacao;
	private String unidadeDeMedida;
	private String bandeira;

	//Método que atribui os valores as suas variaveis
	public Registro(Endereco endereco, Produto produto, String revendaInstalacao, String unidadeDeMedida, String bandeira) {
		this.endereco = endereco;
		this.produto = produto;
		this.revendaInstalacao = revendaInstalacao;
		this.unidadeDeMedida = unidadeDeMedida;
		this.bandeira = bandeira;
	}

	//Construtora
	public Registro(){}

	//Retorna isoladamente o valor dentro da variavel endereço
	public Endereco getEndereco() {
		return endereco;
	}

	//Atribui isoladamente a variavel this.endereco o valor dentro de endereco
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//Retorna isoladamente o valor dentro da variavel produto
	public Produto getProduto() {
		return produto;
	}

	//Atribui isoladamente a variavel this.produto o valor dentro de produto
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	//Retorna isoladamente o valor dentro da variavel RevendaInstalacao
	public String getRevendaInstalacao() {
		return revendaInstalacao;
	}

	//Atribui isoladamente a variavel this.revendaInstalacao o valor dentro de revendaInstalacao
	public void setRevendaInstalacao(String revendaInstalacao) {
		this.revendaInstalacao = revendaInstalacao;
	}

	//Retorna isoladamente o valor dentro da variavel unidadeDeMedida
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	//Atribui isoladamente a variavel this.unidadeDeMedida o valor dentro de unidadeDeMedida
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	//Retorna isoladamente o valor dentro da variavel bandeira
	public String getBandeira() {
		return bandeira;
	}

	//Atribui isoladamente a variavel this.bandeira o valor dentro de bandeira
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
}
