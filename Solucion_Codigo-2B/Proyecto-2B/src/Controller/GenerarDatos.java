package Controller;
import Controller.DeclaracionImpuestos;
import Controller.Gastos;
import Controller.Ingresos;
import Model.EscritorDatos;
import Model.EscrituraDeclaracion;
import java.io.IOException;

public class GenerarDatos {
    private double ingresosAnuales;
    private double deduccionesTotales;
    private double[] Impuesto;
    private double[] FranccionBasica;
    private double[] Tasa;
    private double Maximo;
    private StringBuilder hola;
    private Ingresos ingresos;
    private Gastos gastos;

    public GenerarDatos(double[] Impuesto, double[] FranccionBasica, double[] Tasa, double Maximo) {
        this.Impuesto = Impuesto;
        this.FranccionBasica = FranccionBasica;
        this.Tasa = Tasa;
        this.Maximo = Maximo;
        this.hola = new StringBuilder();
        this.ingresos = new Ingresos();
        this.gastos = new Gastos();
    }

    private double calcularImpuesto() {
        double devolverFormula = ingresosAnuales - deduccionesTotales;
        int i = 1;
        while (i < FranccionBasica.length) {
            if (devolverFormula < FranccionBasica[i]) {
                return (devolverFormula * Tasa[i]) + Impuesto[i];
            } else {
                i++;
            }
        }
        return (devolverFormula * Tasa[Tasa.length - 1]) + Impuesto[Impuesto.length - 1];
    }

    public void generarIngresos() {
        hola.append("Calculo de Impuestos\n");
        hola.append("\nSueldo Mensual:\n");
        hola.append(ingresos.ValoresMensuales());
    }

    public void generarFacturas() {
        hola.append("\nFacturas:\n");
        hola.append("\n");
        hola.append(gastos.ValoresMensuales());
    }

    public void calcularTotal() {
        deduccionesTotales = gastos.TotalAnual();
        ingresosAnuales = ingresos.TotalAnual();
        double impuestoAPagar = calcularImpuesto();
        hola.append("\n---------Calculo de Impuestos-----------\n");
        hola.append("Total Ingresos: ").append(String.format("%.2f", ingresosAnuales)).append("\n");
        hola.append("Total Deducciones: ").append(String.format("%.2f", deduccionesTotales)).append("\n");
        hola.append("Impuesto a Pagar: ").append(String.format("%.2f", impuestoAPagar)).append("\n");
    }

    public void escribirDocumento() {
        EscritorDatos escritor = new EscrituraDeclaracion();
        try {
            escritor.escribirObjetosEmp(hola, "Facturas.csv");
        } catch (IOException e) {
            System.err.println("Error al escribir los datos: " + e.getMessage());
        }
        System.out.println(hola.toString());
    }
}