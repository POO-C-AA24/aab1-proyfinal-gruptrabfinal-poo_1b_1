package View;

import Controller.GestorFinanciero;
import Controller.GeneradorReportes;
import Controller.CalculadorImpuestos;
import Model.EscrituraDeclaracionImpuestos;
import java.io.IOException;

public class Ejecutor {
    public static void main(String[] args) {
        int sueldosAño = 12;
        int numeroCategoria = 6;
        double[] porcentajeDeduccion = {0.2, 0.35, 0.4, 0.1, 0.4, 0.1};
        double[] impuesto = {0, 0, 163, 615, 1377, 2611, 4841, 8602, 14648, 23956};
        double[] franccionBasica = {11902, 15159, 19682, 26031, 34255, 45407, 60450, 80605, 107199};
        double[] tasa = {0, 0.05, 0.1, 0.12, 0.15, 0.2, 0.25, 0.3, 0.35, 0.37};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String[] categorias = {"Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud", "Turismo"};
        double[] sueldoMensual = new double[sueldosAño];
        double[] dineroCategorias = new double[numeroCategoria];

        GestorFinanciero gestor = new GeneradorReportes();
        EscrituraDeclaracionImpuestos write = new EscrituraDeclaracionImpuestos();
        StringBuilder hola = new StringBuilder();

        gestor.calcularSueldoAnual(sueldoMensual);
        hola.append("Calculo de Impuestos\n\nFacturas: \n");
        hola.append(gestor.generarReportes(dineroCategorias, categorias, meses, sueldosAño));
        hola.append(((CalculadorImpuestos)gestor).generarSueldos(sueldoMensual, meses)).append("\n\n");
        hola.append(gestor.calcularImpuestos(dineroCategorias, numeroCategoria, sueldosAño, franccionBasica, tasa, impuesto));

        System.out.println(hola);

        try {
            write.escribirObjetosEmp(hola, "Facturas.csv");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}