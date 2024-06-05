package Controller;
public class TablaGastos {
    FacturasEImpuestos Fac = new FacturasEImpuestos();
    StringBuilder cadena;
    double totalCategorias;
    double SueldoAnual;
    
    public TablaGastos (){
        this.cadena = new StringBuilder();
        this.totalCategorias=0;
        this.SueldoAnual = 0;
    }
    
    
    public void SueldosMensuales(double SueldoMensual[], int SueldosAño) {
        for (int i = 0; i < SueldosAño; i++) {
            SueldoMensual[i] = (int) (Math.random() * (2000 - 0 + 1) + 900);
            SueldoAnual=SueldoAnual+SueldoMensual[i];
        }
    }
    
    
    public StringBuilder GenerarFacturas(double DineroCategorias[], String Categorias[], String Meses[], int SueldosAño) {
    StringBuilder facturaBuilder = new StringBuilder();
    for (int i = 0; i < SueldosAño; i++) {
        facturaBuilder.append("----------------------Facturas de ").append(Meses[i]).append("----------------------\n");
        int Facturas = (int) (Math.random() * (10 - 0 + 1) + 3);
        int Total = 0;
        for (int j = 0; j < Facturas; j++) {
            int Valor1 = (int) (Math.random() * (40 - 0 + 1) + 9);
            Total += Valor1;
            int l = (int) (Math.random() * (Categorias.length));
            facturaBuilder.append(Categorias[l]).append(": ").append(Valor1).append("\n");
            DineroCategorias[l] += Valor1;
        }
        facturaBuilder.append("Total Facturas: ").append(Total).append("\n\n");
    }
    facturaBuilder.append(Fac.GenerarFacturas(DineroCategorias, Categorias, SueldosAño));
    return facturaBuilder;
    }
    
    
    public StringBuilder CalculoImpuestos(double DineroCategorias[], int numeroCategoria,
        int SueldosAño, double FranccionBasica[], double Tasa[], double Impuesto[]) {
    double Maximo = 5327;
    totalCategorias=Fac.obtenerTotalCategorias();
    double Deduccion = totalCategorias;
    StringBuilder resultados = new StringBuilder();

    resultados.append("---------Calculo de Impuestos-----------\n");
    resultados.append("Total: ").append(SueldoAnual).append("\n");

    if (Deduccion > Maximo) {
        Deduccion = Maximo;
    }
    resultados.append("Total deducciones por facturas: ").append(Deduccion).append("\n");
    resultados.append("Formula=((SueldoAnual-Deducciones)*Tasa)+FraccionBasica\n");
    resultados.append("Impuestos totales a pagar: ").append(Fac.Formula(Deduccion, SueldoAnual, FranccionBasica, Tasa, Impuesto)).append("\n");
    
    return resultados;
}
    
}
