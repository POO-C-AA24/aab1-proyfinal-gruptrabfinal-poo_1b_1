package Controller;

public class CalculadorImpuestos extends GestorFinanciero {

    public CalculadorImpuestos() {
        super();
    }

    @Override
    public StringBuilder generarReportes(double[] dineroCategorias, String[] categorias, String[] meses, int sueldosAño) {
        StringBuilder total = new StringBuilder();
        double totalCategorias = 0;
        total.append("---------Total de las Categorias-----------\n");
        total.append("Categorias   |   ");
        for (int i = 0; i < dineroCategorias.length; i++) {
            total.append(categorias[i]).append("  |  ");
        }
        total.append("\n");
        total.append("Total   |   ");
        for (int i = 0; i < dineroCategorias.length; i++) {
            total.append(dineroCategorias[i]).append("  |  ");
            totalCategorias += dineroCategorias[i];
        }
        total.append("\n");
        total.append("Total: ").append(totalCategorias).append("\n\n");
        this.totalCategorias = totalCategorias;
        return total;
    }

    @Override
    public StringBuilder calcularImpuestos(double[] dineroCategorias, int numeroCategoria, int sueldosAño, double[] franccionBasica, double[] tasa, double[] impuesto) {
        throw new UnsupportedOperationException("Método no implementado en CalculadorImpuestos.");
    }

    public StringBuilder generarSueldos(double[] sueldoMensual, String[] meses) {
        StringBuilder sueldos = new StringBuilder();
        sueldos.append("---------Sueldos-----------\n");
        sueldos.append("Mes: Sueldo\n");
        for (int i = 0; i < sueldoMensual.length; i++) {
            sueldos.append(meses[i]).append(": ").append(sueldoMensual[i]).append("\n");
        }
        return sueldos;
    }
}