package uniquindio.edu.co;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    CuentaBancaria c1;
    boolean estado;

    @FXML
    private Button id_boton_saldo;

    @FXML
    private Button id_boton_transferir;

    @FXML
    private Button id_botonagregar;

    @FXML
    private TextField txt_apellido;

    @FXML
    private TextField txt_estado;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_numCuenta;

    @FXML
    private TextField txt_saldo;

    @FXML
    private TextField txt_tipoCuenta;

    @FXML
    void accion_agregarcuenta(ActionEvent event) {

        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        int numCuenta = Integer.parseInt(txt_numCuenta.getText());
        double saldo = Double.parseDouble(txt_saldo.getText());

        String estadoauxi = txt_estado.getText();

        if (estadoauxi.equalsIgnoreCase("activo")) {
            this.estado = true;
        } else {
            this.estado = false;
        }

        String tipo = txt_tipoCuenta.getText();

        Banco banco = new Banco();
        if (tipo.equalsIgnoreCase("ahorro")) {
            CuentaAhorro cuenta = new CuentaAhorro(nombre, apellido, numCuenta, saldo, this.estado, 0.05);
            banco.agregarCuentaAhorro(cuenta);
        } else if (tipo.equalsIgnoreCase("corriente")) {
            CuentaCorriente cuenta = new CuentaCorriente(nombre, apellido, numCuenta, saldo, this.estado, 500.0);
            banco.agregarCuentaCorriente(cuenta);
        } else {
            System.out.println("ERROR , NO EXISTE ESE TIPO DE CUENTA");
        }

        // Imprimir la lista de cuentas creadas
        System.out.println("Lista de cuentas en el banco:");
        for (CuentaBancaria cuenta : banco.getCuentasBanca()) {
            System.out.println(cuenta.toString());
        }
    }

    @FXML
    void accion_consultar_saldo(ActionEvent event) {

        CuentaAhorro cuentaSeleccionada = new CuentaAhorro("Juan", "Perez", 12345, 1000.0, true, 0.05);

        // Consultar saldo
        double saldo = cuentaSeleccionada.consultarSaldo();
        System.out.println("El saldo de la cuenta es: " + saldo);

    }

    @FXML
    void accion_transferir(ActionEvent event) {

        CuentaBancaria cuentaOrigen = new CuentaAhorro("NombreOrigen", "ApellidoOrigen", 1234, 1000, true, 0.05);
        CuentaBancaria cuentaDestino = new CuentaCorriente("NombreDestino", "ApellidoDestino", 5678, 500, true, 200);

        // Verificar que ambas cuentas existan
        if (cuentaOrigen != null && cuentaDestino != null) {
            double monto = 100;

            // Realizar la transferencia
            cuentaOrigen.transferir(cuentaDestino, monto);
        } else {
            System.out.println("Error: No se pudo realizar la transferencia porque una o ambas cuentas no existen.");
        }

    }

}
