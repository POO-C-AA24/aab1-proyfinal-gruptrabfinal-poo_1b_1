package Controller;

public abstract class GestorFinanciero {
    protected double totalCategorias;
    protected double sueldoAnual;

    public GestorFinanciero() {
        this.totalCategorias = 0;
        this.sueldoAnual = 0;
    }

    public abstract StringBuilder generarReportes(double[] dineroCategorias, String[] categorias, String[] meses, int sueldosAño);
    public abstract StringBuilder calcularImpuestos(double[] dineroCategorias, int numeroCategoria, int sueldosAño, double[] franccionBasica, double[] tasa, double[] impuesto);

    public double obtenerTotalCategorias() {
        return totalCategorias;
    }

    protected void calcularSueldoAnual(double[] sueldoMensual) {
        sueldoAnual = 0;
        for (double sueldo : sueldoMensual) {
            sueldoAnual += sueldo;
        }
    }
}