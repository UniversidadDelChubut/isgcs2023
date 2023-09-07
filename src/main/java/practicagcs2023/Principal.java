package practicagcs2023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class Principal {
	
		private static final Logger logger = LogManager.getLogger(Principal.class);

		private static class Entrada {
			private String campo;
			private Double valor;
		}

		private static class Salida {
			private String idProceso;
			private String campo;
			private Double total;
		}

		public static void main(String[] args) {

	            String consulta = "insert into salidas (idproceso, campo, total) values ('a6' , 'testasn', 50)";;
	            jdbc.ejecutarConsulta(consulta);


		}	

}
