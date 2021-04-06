package Classes;

public class Banco {
    private Cuenta[] clientes; //Arreglo
    int nElementos = 10;

    //Constructores
    public Banco(){

    }

    public Banco(Cuenta[] clientes, int nElementos) {
        this.clientes = clientes;
        this.nElementos = nElementos;
    }
    //Getters y setters
    public Cuenta[] getClientes() {
        return clientes;
    }

    public void setClientes(Cuenta[] clientes) {
        this.clientes = clientes;
    }

    public int getnElementos() {
        return nElementos;
    }

    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }

//Métodos
    public void unElementoMas(){
        Cuenta[] newclientes = new Cuenta[nElementos+1];
        System.arraycopy(clientes, 0, newclientes, 0, clientes.length);

        clientes = newclientes;
        nElementos++;
    }

    public void unElementoMenos(){
        Cuenta[] newclientes = new Cuenta[nElementos-1];
        System.arraycopy(clientes, 0, newclientes, 0, clientes.length);

        clientes = newclientes;
        nElementos--;
    }

    public void insertarCliente(Cuenta cuentanueva){
        clientes[nElementos-1] = cuentanueva;
    }

    public void clienteEn(int indice){
        System.out.println(clientes[indice]);

    }

    public int longitud(){
        return clientes.length;
    }

    public boolean eliminar(String llave){
        for(int i = 0;i< clientes.length;i++){
            if (clientes[i].getNombre().equals(llave) || clientes[i].getCuenta().equals(llave)){

                return true;
            }
        }
        return false;
    }

    public int buscar(String llave){
        for(int i = 0;i< clientes.length;i++){
            if (clientes[i].getNombre().equals(llave) || clientes[i].getCuenta().equals(llave)){
                return i;
            }
        }
        return -1;
    }
}
