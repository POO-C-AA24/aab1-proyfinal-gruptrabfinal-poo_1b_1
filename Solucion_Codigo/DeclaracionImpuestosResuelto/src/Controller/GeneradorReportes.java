package Controller;

public class GeneradorReportes extends GestorFinanciero {

    public GeneradorReportes() {
        super();
    }

    @Override
    public StringBuilder generarReportes(double[] dineroCategorias, String[] categorias, String[] meses, int sueldosAño) {
        StringBuilder facturaBuilder = new StringBuilder();
        for (int i = 0; i < sueldosAño; i++) {
            facturaBuilder.append("----------------------Reportes de ").append(meses[i]).append("----------------------\n");
            int facturas = (int) (Math.random() * (10 - 0 + 1) + 3);
            int total = 0;
            for (int j = 0; j < facturas; j++) {
                int valor1 = (int) (Math.random() * (40 - 0 + 1) + 9);
                total += valor1;
                int l = (int) (Math.random() * categorias.length);
                facturaBuilder.append(categorias[l]).append(": ").append(valor1).append("\n");
                dineroCategorias[l] += valor1;
            }
            facturaBuilder.append("Total Facturas: ").append(total).append("\n\n");
        }
        calcularSueldoAnual(dineroCategorias);
        facturaBuilder.append("Total Categorías: ").append(obtenerTotalCategorias()).append("\n");
        return facturaBuilder;
    }

    @Override
    public StringBuilder calcularImpuestos(double[] dineroCategorias, int numeroCategoria, int sueldosAño, double[] franccionBasica, double[] tasa, double[] impuesto) {
        double maximo = 5327;
        totalCategorias = obtenerTotalCategorias();
        double deduccion = totalCategorias;
        StringBuilder resultados = new StringBuilder();

        resultados.append("---------Calculo de Impuestos-----------\n");
        resultados.append("Total: ").append(sueldoAnual).append("\n");

        if (deduccion > maximo) {
            deduccion = maximo;
        }
        resultados.append("Total deducciones por facturas: ").append(deduccion).append("\n");
        resultados.append("Formula=((SueldoAnual-Deducciones)*Tasa)+FraccionBasica\n");
        resultados.append("Impuestos totales a pagar: ").append(calcularImpuestoFinal(deduccion, franccionBasica, tasa, impuesto)).append("\n");

        return resultados;
    }

    private double calcularImpuestoFinal(double deduccion, double[] franccionBasica, double[] tasa, double[] impuesto) {
        double devolverFormula = sueldoAnual - deduccion;
        int i = 1;
        while (i < franccionBasica.length) {
            if (devolverFormula < franccionBasica[i]) {
                devolverFormula = (devolverFormula * tasa[i]) + impuesto[i];
                break;
            } else {
                i++;
            }
        }
        return devolverFormula;
    }
}