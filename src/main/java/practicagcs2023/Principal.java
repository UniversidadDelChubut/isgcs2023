package practicagcs2023;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//tenemos que hacer una clase lector
//la primera linea son las cabeceras
//despues cada linea es un objeto entrada

/*	con un metodo recibe el nombre del archivo
 *
 * agarramos el csv y lo convertimos en objetos de tipo entrada
 * el campo que agrupa es el que aparece en la primera fila
 *  
 * */

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

		public Salida(String idProceso, String campo, Double total) { // Constructor
			this.idProceso = idProceso;
			this.campo = campo;
			this.total = total;
		}
		
		public String getIdProceso() {
			return idProceso;
		}
		
		public String getCampo() {
			return campo;
		}
		
		public Double getTotal() {
			return total;
		}
		
	}

	private static class Lector {

		public List<Entrada> leer(String csv, String agrupar, String sumarizar) {
			List<Entrada> entradas = new ArrayList<>();

			try (Reader in = new FileReader(csv)) {// recibe el nombre
				Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);// extrae los datos del csv
				for (CSVRecord record : records) {// recorre la lista de entradas del csv

					String campoAgrupacion = record.get(agrupar); // agarra lo que hay en una columna y guarda el valor
					String campoSumarizacion = record.get(sumarizar);

					Entrada entrada = new Entrada();
					entrada.campo = campoAgrupacion;
					entrada.valor = Double.parseDouble(campoSumarizacion);

					entradas.add(entrada);
				}
			} catch (IOException e) {
				logger.error("Error al leer el archivo CSV: {}", e.getMessage());
			}
			return entradas;

		}
	}

	public static void main(String[] args) {
        logger.info("Inicia main!");
        String csv ="/home/agus/Descargas/prueba.csv";//cambiar a donde este guardado el csv
        String agrupar = "provincia"; 
        String sumarizar="titulares";
        Lector lector =new Lector();

        List<Entrada> entradas = lector.leer(csv, agrupar, sumarizar);
        
        // Haz algo con las entradas, por ejemplo, imprimir las primeras entradas
        for (int i = 0; i < Math.min(200, entradas.size()); i++) {
            Entrada entrada = entradas.get(i);
            logger.info("Campo: {}, Valor: {}", entrada.campo, entrada.valor);
        }

        List<Salida> salidas = Procesador.procesarEntrada(entradas); // Obtenerla de la clase Procesador a partir de las entradas leídas

        // Persistir las salidas en la base de datos con la clase Escritor
			for (Salida salida : salidas) {
			String consulta = "INSERT INTO salidas (idproceso, campo, total) VALUES('"
							 +salida.getIdProceso()+"' , '"
							 +salida.getCampo()+"', "+salida.getTotal() + ");";
	        jdbc.ejecutarConsulta(consulta);
			
			}

        logger.info("Finaliza main!");
    }
}
