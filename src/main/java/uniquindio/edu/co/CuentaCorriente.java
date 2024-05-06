package uniquindio.edu.co;

public class CuentaCorriente extends CuentaBancaria {

    private double sobreGiro;

    public CuentaCorriente(String nombre, String apellido, int numeroCuenta, double saldo, boolean estado,
            double sobreGiro) {
        super(nombre, apellido, numeroCuenta, saldo, estado);
        this.sobreGiro = sobreGiro;
    }

    public double getSobreGiro() {
        return sobreGiro;
    }

    public void setSobreGiro(double sobreGiro) {
        this.sobreGiro = sobreGiro;
    }

    @Override
    public double consultarSaldo() {
        return getSaldo();
    }

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "cuentaCorriente [sobreGiro=" + sobreGiro + ", consultarSaldo()=" + consultarSaldo() + ", getNombre()="
                + getNombre() + ", getApellido()=" + getApellido() + ", getNumeroCuenta()=" + getNumeroCuenta()
                + ", getSaldo()=" + getSaldo() + ", getEstado()=" + getEstado() + "]";
    }

}
