package uniquindio.edu.co;

import java.util.Collection;

public abstract class CuentaBancaria {

    private String nombre;
    private String apellido;
    private int numeroCuenta;
    private double saldo;
    private boolean estado;

    private Collection<Transaccion> transacciones;

    private Tipo tipo;

    public abstract double consultarSaldo();

    public abstract void realizarTransaccion(Transaccion transaccion);

    public CuentaBancaria(String nombre, String apellido, int numeroCuenta, double saldo, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    // constructor para inicializar la coleccion
    public CuentaBancaria(Collection<Transaccion> transacciones) {
        this.transacciones = transacciones;

    }

    public boolean esCuentaAhorro() {
        return tipo == Tipo.DEPOSITO;
    }

    public boolean esCuentaCorriente() {
        return tipo == Tipo.RETIRO;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public void eliminarTransaccion(Transaccion transaccion) {
        transacciones.remove(transaccion);
    }

    public Collection<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Collection<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void transferir(CuentaBancaria destino, double monto) {
        // Verificar si hay suficiente saldo en la cuenta de origen
        if (this.saldo >= monto) {
            // Restar el monto de la cuenta de origen
            this.saldo -= monto;
            // Sumar el monto a la cuenta de destino
            destino.saldo += monto;
            System.out.println("Transferencia exitosa de $" + monto + " desde la cuenta " + this.numeroCuenta
                    + " a la cuenta " + destino.numeroCuenta);
        } else {
            System.out.println(
                    "Error: Saldo insuficiente para realizar la transferencia desde la cuenta " + this.numeroCuenta);
        }
    }

}
