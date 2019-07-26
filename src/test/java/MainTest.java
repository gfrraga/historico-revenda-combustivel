import Controller.*;
import Model.Registro;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

	@Before
	public void init() throws SQLException {
		ConexaoBD.conectar();
		OperaçõesBD.droparTodasTabelas();
		ConexaoBD.desconectar();
	}

	@Test
	public void importCsvFile() throws SQLException {
		File file = new File("./src/test/resources/dados_combustiveis.csv");
		Main.importFile(file);
		String query = "SELECT count(*) AS quantidade FROM registros";

		ConexaoBD.conectar();
		ResultSet resultSet = ConsultaBD.executarConsulta(query);
		Assert.assertTrue(resultSet.next());
		int quantidade = resultSet.getInt("quantidade");
		Assert.assertEquals(111, quantidade);
		resultSet.close();
		ConsultaBD.desconectarStatement();
		ConexaoBD.desconectar();
	}

	@Test
	public void importJsonFile() throws SQLException {
		File file = new File("./src/test/resources/dados_combustiveis.json");
		Main.importFile(file);
		String query = "SELECT count(*) AS quantidade FROM registros";

		ConexaoBD.conectar();
		ResultSet resultSet = ConsultaBD.executarConsulta(query);
		Assert.assertTrue(resultSet.next());
		int quantidade = resultSet.getInt("quantidade");
		Assert.assertEquals(111, quantidade);
		resultSet.close();
		ConsultaBD.desconectarStatement();
		ConexaoBD.desconectar();
	}

	@Test
	public void importXmlFile() throws SQLException {
		File file = new File("./src/test/resources/dados_combustiveis.xml");
		Main.importFile(file);
		String query = "SELECT count(*) AS quantidade FROM registros";

		ConexaoBD.conectar();
		ResultSet resultSet = ConsultaBD.executarConsulta(query);
		Assert.assertTrue(resultSet.next());
		int quantidade = resultSet.getInt("quantidade");
		Assert.assertEquals(0, quantidade);
		resultSet.close();
		ConsultaBD.desconectarStatement();
		ConexaoBD.desconectar();
	}

	@Test
	public void listAll() {
		File file = new File("./src/test/resources/dados_combustiveis.json");
		Main.importFile(file);
		List<Registro> registros = Main.listAll();
		Assert.assertFalse(registros.isEmpty());
		Assert.assertEquals(111, registros.size());
	}


}
