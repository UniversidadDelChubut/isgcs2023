
package practicagcs2023;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings(value = { "" })
public class jdbc {
    private static final String URL = "jdbc:postgresql://localhost:5432/isgcs";
    private static final String USUARIO = "postgres";
    private static final String CONTRASEÑA = "udc";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void ejecutarConsulta(String salidas) {
        Connection conexion = obtenerConexion();
        if (conexion != null) {
            try {
	               	PreparedStatement statement = conexion.prepareStatement(salidas);
	               	int update = statement.executeUpdate();
	                if (update > 0) {
	                    System.out.println("Inserción exitosa.");
	                } else {
	                    System.out.println("La inserción no efectuo.");
	                }
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            } finally {
                try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        }

    }
    
    
}
