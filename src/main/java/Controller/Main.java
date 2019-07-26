package Controller;

import Model.Endereco;
import Model.Produto;
import Model.Registro;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void importFile(File file) {
		try {
			//Formatador de datas configurado para o padrão brasileiro de dia mes e ano separado por barra
			final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//Lista de registros a ser importado
			List<Registro> registros;

			if (file.getName().toLowerCase().endsWith(".json")) { //Se o nome do arquivo for um json
				registros = Getter.obterRegistrosJSON(file);
			} else if (file.getName().toLowerCase().endsWith(".csv")) { //Se o nome do arquivo for um csv
				registros = Getter.obterRegistrosCSV(file);
			} else {
				//Lança uma exception caso o arquivo não seja valido
				throw new RuntimeException("Arquivo invalido");
			}

			ConexaoBD.conectar();
			OperaçõesBD.inserirRegistrosNoBD(registros);
			ConexaoBD.desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Registro> listAll() {
		try {
			//Lista de registros a ser retornada
			List<Registro> registros = OperaçõesBD.carregarRegistrosDoBD();
			return registros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
