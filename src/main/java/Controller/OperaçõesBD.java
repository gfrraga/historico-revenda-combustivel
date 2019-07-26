package Controller;

import Model.Endereco;
import Model.Produto;
import Model.Registro;
import Model.Tabelas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperaçõesBD {

    public static void inserirRegistrosNoBD(List<Registro> registros) throws SQLException {
        //Insere os registros no banco
        for (Registro registro : registros) {
            //Criar o statement para inserir na tabela de registros
            PreparedStatement st = ConexaoBD.getConnection().prepareStatement(
                    "INSERT INTO registros(revenda_instalacao, unidade_de_medida, bandeira)\n" +
                            "VALUES (?,  ?,  ?)"
            );
            //Adiciona os parametros no insert
            st.setString(1, registro.getRevendaInstalacao());
            st.setString(2, registro.getUnidadeDeMedida());
            st.setString(3, registro.getBandeira());

            //Executa o insert
            st.executeUpdate();

            //Cria o statement para inserir os endereço
            st = ConexaoBD.getConnection().prepareStatement(
                    "INSERT INTO endereco(registro_id, regiao, sigla_estado,sigla_municipio)" +
                            "VALUES (lastval(), ?, ?, ?)"
            );

            //Adiciona os parâmetros
            st.setString(1, registro.getEndereco().getRegiao());
            st.setString(2, registro.getEndereco().getSiglaEstado());
            st.setString(3, registro.getEndereco().getSiglaMunicipio());

            //Executa o insert
            st.executeUpdate();

            //Cria o statement para inserir os produtos
            st = ConexaoBD.getConnection().prepareStatement(
                    "INSERT INTO produto(registro_id, codigo_produto, nome_produto,valor_de_compra,valor_de_venda, data_da_coleta)" +
                            "VALUES (lastval(), ?, ?, ?, ?,?)"
            );

            //Adiciona os parâmetros
            st.setString(1, registro.getProduto().getCodigoProduto());
            st.setString(2, registro.getProduto().getNomeProduto());
            st.setObject(3, registro.getProduto().getValorDeCompra());
            st.setDouble(4, registro.getProduto().getValorDeVenda());
            st.setDate(5, new java.sql.Date(registro.getProduto().getDataDaColeta().getTime()));

            //Executa o insert
            st.executeUpdate();
            st.close();



        }
    }

    public static List<Registro> carregarRegistrosDoBD() throws SQLException {
        ArrayList<Registro> registros = new ArrayList<>();
        String query = "SELECT * FROM registros";

        ConexaoBD.conectar();
        ResultSet resultSet = ConsultaBD.executarConsulta(query);
        //Itera o resultado ate não haver mais registros
        while (resultSet.next()) {
            //Monta o registro
            Registro registro;
            Endereco endereco;
            Produto produto;

            //Consulta para endereco
            String queryEndereco = "SELECT * FROM endereco WHERE registro_id=" + resultSet.getInt("id");
            ResultSet rsEndereco = ConsultaBD.executarConsulta(queryEndereco);
            rsEndereco.next();

            //Consulta para produtos
            String queryProdutos = "SELECT * FROM produto WHERE registro_id=" + resultSet.getInt("id");
            ResultSet rsProduto  = ConsultaBD.executarConsulta(queryProdutos);
            rsProduto.next();

            endereco = new Endereco(
                    rsEndereco.getString("regiao"),
                    rsEndereco.getString("sigla_estado"),
                    rsEndereco.getString("sigla_municipio")
            );

            produto = new Produto(
                    rsProduto.getDate("data_da_coleta"),
                    rsProduto.getString("codigo_produto"),
                    rsProduto.getString("nome_produto"),
                    rsProduto.getDouble("valor_de_compra"),
                    rsProduto.getDouble("valor_de_venda")
            );

            registro = new Registro(
                    endereco,
                    produto,
                    resultSet.getString("revenda_instalacao"),
                    resultSet.getString("unidade_de_medida"),
                    resultSet.getString("bandeira")
            );

            //Adiciona o registro na lista
            registros.add(registro);
        }
        ConsultaBD.desconectarStatement();
        resultSet.close();
        ConexaoBD.desconectar();
        return registros;
    }

    public static void droparTabela(String nomeDaTabela) throws SQLException {
        PreparedStatement st = ConexaoBD.getConnection().prepareStatement(
                "DELETE FROM " + nomeDaTabela
        );
        st.execute();
        st.close();
    }

    public static void droparTodasTabelas() throws SQLException {
        for (Tabelas t: Tabelas.values()) {
            droparTabela(t.getNomeDaTabela());
        }
    }
}
