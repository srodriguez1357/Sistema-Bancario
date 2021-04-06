package Classes;
import java.time.LocalDate; //Usada para detectar si es primero del mes

public class CuentaCorriente extends Cuenta{
    //Valores iniciales
    private int transacciones = 0;
    private int importePorTransaccion = 2;
    private int transExetentas = 10;

    //Constructotres
    public CuentaCorriente(){

    }

    public CuentaCorriente(int transacciones, int importePorTransaccion, int transExtentas) {
        this.transacciones = transacciones;
        this.importePorTransaccion = importePorTransaccion;
        this.transExetentas = transExtentas;
    }

    public CuentaCorriente(String nombre, String cuenta, double saldo, double tipoDeInteres, int transacciones, int importePorTransaccion, int transExtentas) {
        super(nombre, cuenta, saldo, tipoDeInteres);
        this.transacciones = transacciones;
        this.importePorTransaccion = importePorTransaccion;
        this.transExetentas = transExtentas;
    }
//Getters y setters
    public int getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(int transacciones) {
        this.transacciones = transacciones;
    }

    public int getImportePorTransaccion() {
        return importePorTransaccion;
    }

    public void setImportePorTransaccion(int importePorTransaccion) {
        this.importePorTransaccion = importePorTransaccion;
    }

    public int getTransExtentas() {
        return transExetentas;
    }

    public void setTransExtentas(int transExtentas) {
        this.transExetentas = transExtentas;
    }
//Métodos
    @Override
    public void comisiones(){
        if(this.transacciones > this.transExetentas){
            retiro((this.transacciones-this.transExetentas*this.importePorTransaccion));
            System.out.println("Transferencia realizada con Éxito");
        }
    }

    @Override
    public void intereses(){
        LocalDate currentdate = LocalDate.now();
        if(currentdate.getDayOfMonth()==1){
            this.saldo=saldo*(this.tipoDeInteres/12);
        }
    }
}

