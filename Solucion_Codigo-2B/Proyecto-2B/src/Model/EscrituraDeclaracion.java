package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraDeclaracion implements EscritorDatos {

    @Override
    public void escribirObjetosEmp(StringBuilder datos, String nombreArchivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.write(datos.toString());
        } catch (IOException e) {
            System.err.println("Error escribiendo el archivo: " + e.getMessage());
            throw e;
        }
    }
}