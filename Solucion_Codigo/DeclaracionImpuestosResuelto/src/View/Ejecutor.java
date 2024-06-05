package View;
import Controller.FacturasEImpuestos;
import Controller.TablaGastos;
import Model.EscrituraDeclaracionImpuestos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ejecutor {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder Hola = new StringBuilder();
        int SueldosAño = 12, numeroCategoria = 6;
        double PorcentajeDeduccion[] = {0.2, 0.35, 0.4, 0.1, 0.4, 0.1};
        double Impuesto[] = {0, 0, 163, 615, 1377, 2611, 4841, 8602, 14648, 23956};
        double FranccionBasica[] = {11902, 15159, 19682, 26031, 34255, 45407, 60450, 80605, 107199};
        double Tasa[] = {0, 0.05, 0.1, 0.12, 0.15, 0.2, 0.25, 0.3, 0.35, 0.37};
        String Meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",  "Octubre", "Noviembre", "Diciembre"};
        String Categorias[] = {"Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud", "Turismo"};
        double SueldoMensual[] = new double[SueldosAño];
        double DineroCategorias[] = new double[numeroCategoria];
        
        
        
        TablaGastos Imp = new TablaGastos ();
        FacturasEImpuestos Emp = new FacturasEImpuestos();
        Hola.append("Calculo de Impuestos\n\nFacturas: \n");
        Imp.SueldosMensuales(SueldoMensual, SueldosAño);
        Hola.append(Imp.GenerarFacturas(DineroCategorias, Categorias, Meses, SueldosAño)+"\n");
        Hola.append(Emp.generarSueldos(SueldoMensual, Meses)+"\n\n");
        Hola.append(Imp.CalculoImpuestos(DineroCategorias, numeroCategoria, SueldosAño, FranccionBasica, Tasa, Impuesto));
        System.out.println(Hola);
        EscrituraDeclaracionImpuestos write = new EscrituraDeclaracionImpuestos();
        write.escribirObjetosEmp(Hola, "Facturas.dat");
    }
}
