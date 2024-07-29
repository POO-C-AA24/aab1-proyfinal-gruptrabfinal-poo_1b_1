package Controller;

public class Ingresos extends DeclaracionImpuestos {
    private double[] mensual;

    public Ingresos() {
        mensual = new double[Meses.length];
    }

    @Override
    public StringBuilder ValoresMensuales() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mes: Sueldo\n");
        for (int i = 0; i < Meses.length; i++) {
            mensual[i] = (Math.random() * (2000 - 900 + 1) + 900);
            sb.append(Meses[i]).append(": ").append(String.format("%.2f", mensual[i])).append("\n");
        }
        sb.append(obtenerDatosComoString());
        return sb;
    }

    @Override
    public double TotalAnual() {
        anual = 0;
        for (double sueldo : mensual) {
            anual += sueldo;
        }
        return anual;
    }

    @Override
    public StringBuilder obtenerDatosComoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total Anual: ").append(String.format("%.2f", TotalAnual())).append("\n");
        return sb;
    }
}   