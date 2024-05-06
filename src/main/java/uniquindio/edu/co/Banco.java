package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.Collection;

public class Banco {

    private final String nombre;
    private Collection<CuentaBancaria> cuentasBanca;
    private Collection<Titular> titulares;

    public Banco(String nombre, Collection<CuentaBancaria> cuentasBanca, Collection<Titular> titulares) {
        this.nombre = nombre;
        this.cuentasBanca = cuentasBanca;
        this.titulares = titulares;
    }

    public Banco() {
        this.nombre = "";
        this.cuentasBanca = new ArrayList<>();
        this.titulares = new ArrayList<>();
    }

    public void agregarCuentaAhorro(CuentaAhorro nuevacuenta) {
        cuentasBanca.add(nuevacuenta);
    }

    public void agregarCuentaCorriente(CuentaCorriente nuevacuenta) {
        cuentasBanca.add(nuevacuenta);
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarTitular(Titular titular) {
        titulares.add(titular);
    }

    public void eliminarTitular(Titular titular) {
        titulares.remove(titular);
    }

    public Collection<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(Collection<Titular> titulares) {
        this.titulares = titulares;
    }

    public Collection<CuentaBancaria> getCuentasBanca() {
        return cuentasBanca;
    }

    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + ", cuentasBanca=" + cuentasBanca + ", titulares=" + titulares
                + ", getNombre()=" + getNombre() + ", getTitulares()=" + getTitulares() + ", getCuentasBanca()="
                + getCuentasBanca() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

}
