package Tests;
import Classes.*; //Importar las clases
import java.util.Scanner; //usado para leer inputs

public class TestBancos {
  public static int menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número de la opción que desea:");
        System.out.println("1. Saldo");
        System.out.println("2. Buscar siguiente");
        System.out.println("3. Depósito");
        System.out.println("4. Retiro");
        System.out.println("5. Añadir nuevo cliente");
        System.out.println("6. Eliminar cliente");
        System.out.println("7. Mantenimiento");
        System.out.println("8. Salir");
        int respuesta = scan.nextInt();
        if(respuesta>0 && respuesta<9) {
            scan.close();
            return respuesta;
        }
        else{
            System.out.println("Opción inválida");
        }
        return -1;
    }

    public static void main(String[] args) {
      Banco cochinito = new Banco();
      Cuenta micuenta = new CuentaAhorro();

      int respuesta = 0;
        while (respuesta != 8) {
            respuesta = menu();

            switch (respuesta) { //escoger opciones de menu
                case 1:
                    System.out.println("El saldo de la cuenta es: " + micuenta.getSaldo());
                    break;
                case 2:
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Ingrese la información que desea buscar: ");
                    String busqueda = scan.nextLine();
                    scan.close();

                    int i = cochinito.buscar(busqueda);
                    if (i > 0) {
                        System.out.println("La cuenta que busca se encuentra en la posición" + i);
                    } else {
                        System.out.println("No se pudo encontrar la cuenta que desea");
                    }
                    break;
                case 3:
                    scan = new Scanner(System.in);
                    System.out.println("Ingrese la cantidad que desea depositar: ");
                    double cantidad = scan.nextDouble();
                    scan.close();
                    micuenta.deposito(cantidad);
                    break;
                case 4:
                    scan = new Scanner(System.in);
                    System.out.println("Ingrese la cantidad que desea retirar: ");
                    cantidad = scan.nextDouble();
                    scan.close();
                    micuenta.retiro(cantidad);
                    break;
                case 5:
                    cochinito.unElementoMas();
                    cochinito.insertarCliente(new CuentaAhorro());
                    scan = new Scanner(System.in);
                    System.out.println("Ingrese el nombre del beneficiario de la cuenta: ");
                    String name = scan.nextLine();
                    scan.close();
                    scan = new Scanner(System.in);
                    System.out.println("Ingrese su número de cuenta: ");
                    String cuenta = scan.nextLine();
                    scan.close();

                    micuenta.setCuenta(cuenta);
                    micuenta.setNombre(name);
                    break;
                case 6:
                    scan = new Scanner(System.in);
                    System.out.println("Ingrese la cuenta a eliminar: ");
                    String borrar = scan.nextLine();
                    scan.close();
                    cochinito.eliminar(borrar);
                    cochinito.unElementoMenos();
                    break;
                case 7:
                    System.out.println("Ingrese la cuenta a dar mantenimiento: ");
                    break;
                case 8:

                    break;
            }
        }

        }
    }

