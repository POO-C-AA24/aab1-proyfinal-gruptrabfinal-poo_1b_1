package Model;

import java.io.IOException;

public interface EscritorDatos {
    void escribirObjetosEmp(StringBuilder datos, String nombreArchivo) throws IOException;
}