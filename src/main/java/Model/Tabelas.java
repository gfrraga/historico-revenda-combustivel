package Model;

public enum Tabelas {
    REGISTROS("registros"),
    ENDERECO("endereco"),
    PRODUTO("produto");
    
    //criação de objeto
    private final String nomeDaTabela;

    /*
    armazena o 'nome' na memoria da variavel 'nomeDaTabela'
    Sugestão mudar o nome da função para setNomeDaTabela 
    */
    Tabelas(String nome){
        nomeDaTabela = nome;
    }

    
    //A função devolve o conteúdo presente na variavel 'nomeDaTabela'
    public String getNomeDaTabela(){
        return nomeDaTabela;
    }
}
