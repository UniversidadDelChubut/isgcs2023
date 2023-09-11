package practicagcs2023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class Principal {
	
		private static final Logger logger = LogManager.getLogger(Principal.class);

		public static class Entrada {
			private String campo;
			private Double valor;
			
			public String getCampo() {
				return campo;
			}

			public Double getValor() {
				return valor;
			}
			
			
		}

		public static class Salida {
			private String idProceso;
			private String campo;
			private Double total;
			
<<<<<<< HEAD
			public Salida(String idProceso, String campo, Double total) { //Constructor
				this.idProceso = idProceso;
				this.campo = campo;
				this.total = total;
			}
=======
>>>>>>> 03936922ff492ee3f24c0e92a277c95d49af826b
		}

		public static void main(String[] args) {
				
			for (String salida : lista) {
			String consulta = "INSERT INTO salidas (idproceso, campo, total) VALUES('"
							 +salida.getIdproceso()+"' , '"
							 +salida.getCampo()+"', "+salida.getTotal()");";
	        jdbc.ejecutarConsulta(consulta);
			
			}

		}	

}
