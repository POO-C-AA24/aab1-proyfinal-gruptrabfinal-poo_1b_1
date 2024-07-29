package Controller;

public class Gastos extends DeclaracionImpuestos implements Deduccion {
    private String[] categorias = {"Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud", "Turismo"};
    private double[] porcentajeDeduccion = {0.2, 0.35, 0.4, 0.1, 0.4, 0.1};
    private double[] FranccionBasica = {11902, 15159, 19682, 26031, 34255, 45407, 60450, 80605, 107199};
    private double[] Tasa = {0, 0.05, 0.1, 0.12, 0.15, 0.2, 0.25, 0.3, 0.35, 0.37};

    public Gastos() {
        mensual = new double[categorias.length];
    }

    @Override
    public StringBuilder ValoresMensuales() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Meses.length; i++) {
            sb.append("----------------------Facturas de ").append(Meses[i]).append("----------------------\n");
            int facturas = (int) (Math.random() * (10 - 3 + 1) + 3);
            double total = 0;
            for (int j = 0; j < facturas; j++) {
                double gastoMes = (Math.random() * (40 - 9 + 1) + 9);
                total += gastoMes;
                int l = (int) (Math.random() * categorias.length);
                mensual[l] += gastoMes;
                double deduccion = calculaDeduccion(gastoMes, porcentajeDeduccion[l]);
                sb.append(categorias[l]).append(": ").append(gastoMes).append(", Deduccion: ").append(deduccion).append("\n");
            }
            sb.append("Total Facturas: ").append(total).append("\n\n");
        }
        sb.append(obtenerDatosComoString());
        return sb;
    }

    @Override
    public double TotalAnual() {
        anual = 0;
        for (int i = 0; i < mensual.length; i++) {
            anual += calculaDeduccion(mensual[i], porcentajeDeduccion[i]);
        }
        return anual;
    }

    @Override
    public double calculaDeduccion(double gastoMes,double porcentajeDeduccion) {
        return gastoMes * porcentajeDeduccion;
    }

    @Override
    public StringBuilder obtenerDatosComoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gastos por Categoria:\n");
        for (int i = 0; i < mensual.length; i++) {
            sb.append(categorias[i]).append(": ").append(String.format("%.2f", mensual[i])).append("\n");
        }
        sb.append("Total Anual: ").append(String.format("%.2f", TotalAnual())).append("\n");
        return sb;
    }
}
