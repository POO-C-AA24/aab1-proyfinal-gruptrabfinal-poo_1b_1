package Controller;

public abstract class DeclaracionImpuestos {
    protected double[] mensual;
    protected double anual;
    protected String[] Meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public abstract StringBuilder ValoresMensuales();

    public double TotalAnual() {
        return anual;
    }

    public StringBuilder obtenerDatosComoString() {
        return new StringBuilder("Valores no implementados");
    }
}