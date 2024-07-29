package Controller;

public class CalcularDeduccionSegunLaCategoria implements Deduccion {
    
    @Override
    public double calculaDeduccion(double valor1, double porcentajeDeduccion) {
        return valor1 * porcentajeDeduccion;
    }
}