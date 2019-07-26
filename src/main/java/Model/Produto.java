package Model;

import java.util.Date;

public class Produto {
    private Date dataDaColeta;
    private String codigoProduto;
    private String nomeProduto;
    private Double valorDeCompra;
    private Double valorDeVenda;

    public Produto(Date dataDaColeta, String codigoProduto, String nomeProduto, Double valorDeCompra, Double valorDeVenda) {
        this.dataDaColeta = dataDaColeta;
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.valorDeCompra = valorDeCompra;
        this.valorDeVenda = valorDeVenda;
    }

    public Produto(){}

    public Date getDataDaColeta() {
        return dataDaColeta;
    }

    public void setDataDaColeta(Date dataDaColeta) {
        this.dataDaColeta = dataDaColeta;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(Double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public Double getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(Double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }
}
