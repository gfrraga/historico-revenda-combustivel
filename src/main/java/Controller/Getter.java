package Controller;

import Model.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Getter {

    public static List<Registro> obterRegistrosJSON(File file) throws IOException{
        List<PlaceHolder> holders;
        //Responsavel por converter o arquivo json em lista de registros
        ObjectMapper mapper = new ObjectMapper();

        //Configura o formatador de date no conversor de json
        mapper.setDateFormat(DateFormat.PADRAO.getDateFormat());

        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));

        //Monta o tipo de retorno do conversor de json para retornar uma lista de registro
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PlaceHolder.class);
        //Converte o arquivo em uma lista de registro
        holders = mapper.readValue(file.toURI().toURL(), collectionType);

        List<Registro> registros = new ArrayList<>();
        // Cria a lista de registros baseado no retorno do JSON
        for (PlaceHolder holder: holders) {
            Endereco endereco;
            Produto produto;
            Registro registro;

            endereco = new Endereco(
                    holder.getRegiao(),
                    holder.getSiglaEstado(),
                    holder.getSiglaMunicipio()
            );

            produto = new Produto(
                    holder.getDataDaColeta(),
                    holder.getCodigoProduto(),
                    holder.getNomeProduto(),
                    holder.getValorDeCompra(),
                    holder.getValorDeVenda()
            );

            registro = new Registro(
                    endereco,
                    produto,
                    holder.getRevendaInstalacao(),
                    holder.getUnidadeDeMedida(),
                    holder.getBandeira()
            );

            registros.add(registro);
        }

        return registros;
    }

    public static ArrayList<Registro> obterRegistrosCSV(File file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
        ArrayList<Registro> registros = new ArrayList<>();
        for (String line : lines){
            if (!line.equals("regiao|siglaEstado|siglaMunicipio|revendaInstalacao|codigoProduto|nomeProduto|dataDaColeta|valorDeCompra|valorDeVenda|unidadeDeMedida|bandeira")) {
                //Quebra a linha usando pipe (|)
                String[] colunas = line.split("\\|");
                //Monta o registro
                Endereco endereco;
                Produto produto;
                Registro registro;
                java.util.Date dataDaColeta;

                try {
                    dataDaColeta = DateFormat.PADRAO.getDateFormat().parse(colunas[6]);
                } catch (java.text.ParseException e) {
                    throw new RuntimeException(e);
                }

                //Instancia o produto
                produto = new Produto(
                        dataDaColeta,
                        colunas[4],
                        colunas[5],
                        !colunas[7].equals("") ? Double.parseDouble(colunas[7]) : null,
                        Double.parseDouble(colunas[8])
                );

                //Instancia o endereço
                endereco = new Endereco(
                        colunas[0],
                        colunas[1],
                        colunas[2]
                );

                //Instancia o registro
                registro = new Registro(endereco,produto,colunas[3],colunas[9],colunas[10]);

                registros.add(registro);
            }
        }

        return registros;
    }
}
