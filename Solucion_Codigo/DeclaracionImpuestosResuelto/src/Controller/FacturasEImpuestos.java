package Controller;
public class FacturasEImpuestos {
    double totalCategorias;
    
    public FacturasEImpuestos (){
        this. totalCategorias=0;
    }
    
    public StringBuilder GenerarFacturas(double DineroCategorias[], String Categorias[], int SueldosAño) {
    StringBuilder total = new StringBuilder();
    double Total = 0;
    total.append("---------Total de las Categorias-----------\n");
    total.append("Categorias   |   ");
        for (int i = 0; i < DineroCategorias.length; i++) {
            total.append(Categorias[i]).append("  |  ");
        }
        total.append("\n");
        total.append("Total   |   ");
        for (int i = 0; i < DineroCategorias.length; i++) {
            total.append(DineroCategorias[i]).append("  |  ");
            Total = Total + DineroCategorias[i];
        }
        total.append("\n");
        total.append("Total: ").append(Total).append("\n\n");
        totalCategorias = Total;
        return total;
    }
    
    public StringBuilder generarSueldos(double SueldoMensual[], String Meses[]) {
        StringBuilder sueldos = new StringBuilder();
        sueldos.append("---------Sueldos-----------\n");
        sueldos.append("Mes: Sueldo\n");
        for (int i = 0; i < SueldoMensual.length; i++) {
            sueldos.append(Meses[i]).append(": ").append(Double.toString(SueldoMensual[i])).append("\n");
        }
        return sueldos;
    }
    
    
    public double Formula(double Deduccion, double SueldoAnual, double FranccionBasica[], double Tasa[], double Impuesto[]) {
    double DevolverFormula = SueldoAnual - Deduccion;
    int i = 1;
    while (i < FranccionBasica.length) {
        if (DevolverFormula < FranccionBasica[i]) {
            DevolverFormula = (DevolverFormula * Tasa[i]) + Impuesto[i];
            break;
        } else {
            i++;
        }
    }
    return DevolverFormula;
    }
    
    public double obtenerTotalCategorias(){
        return totalCategorias;
    }
}
