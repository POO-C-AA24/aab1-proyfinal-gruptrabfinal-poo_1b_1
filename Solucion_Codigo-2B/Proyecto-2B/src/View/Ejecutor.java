package View;

import Controller.DeclaracionImpuestos;
import Controller.Ingresos;
import Controller.Gastos;
import Controller.GenerarDatos;
import Model.EscritorDatos;
import Model.EscrituraDeclaracion;
import java.io.IOException;

public class Ejecutor {
    public static void main(String[] args) {
        double Impuesto[] = {0, 0, 163, 615, 1377, 2611, 4841, 8602, 14648, 23956};
        double FranccionBasica[] = {11902, 15159, 19682, 26031, 34255, 45407, 60450, 80605, 107199};
        double Tasa[] = {0, 0.05, 0.1, 0.12, 0.15, 0.2, 0.25, 0.3, 0.35, 0.37};
        double Maximo = 5327;

        GenerarDatos generar = new GenerarDatos(Impuesto, FranccionBasica, Tasa, Maximo);
        generar.generarIngresos();
        generar.generarFacturas();
        generar.calcularTotal();
        generar.escribirDocumento();
    }
}