    package Model;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.ObjectOutputStream;

    public class EscrituraDeclaracionImpuestos {
        public ObjectOutputStream flujoSalidaEmp;

        public void escribirObjetosEmp(StringBuilder hola, String nombreArchivo) {
            try (ObjectOutputStream flujoSalidaEmp = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
                flujoSalidaEmp.writeObject(hola.toString());
            } catch (IOException e) {
                System.err.println("Error escribiendo el archivo: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }