package Model;

public enum Tabelas {
    REGISTROS("registros"),
    ENDERECO("endereco"),
    PRODUTO("produto");

    private final String nomeDaTabela;

    Tabelas(String nome){
        nomeDaTabela = nome;
    }

    public String getNomeDaTabela(){
        return nomeDaTabela;
    }
}
