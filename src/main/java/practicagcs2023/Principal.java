package practicagcs2023;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class Principal {
	
		private static final Logger logger = LogManager.getLogger(Principal.class);

		public static class Entrada {
			private String campo;
			private Double valor;
		}

		public static class Salida {
			private String idProceso;
			private String campo;
			private Double total;
		}

		public static void main(String[] args) {
			logger.info("Inicia main!");

			List<Entrada> entradas =  null; // Obtenerla de la clase Lector

			List<Salida> salidas =  null; // Obtenerla de la clase Procesador a partir delas entradas leidas

			// Persistir las salidas en la base de datos con la clase Escritor


			logger.info("Finaliza main!");
		}	

}
