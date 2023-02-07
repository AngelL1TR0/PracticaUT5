package app;

import entity.ClienteEntity;
import entity.ProductoEntity;
import service.ClienteService;
import service.ProductoService;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();
        ProductoService productoService = new ProductoService();
        ClienteEntity cliente;
        ProductoEntity producto;

        try (Scanner sc = new Scanner(System.in)) {

            do {
                System.out.println("Bienvenido al sistema\nIntroduce el DNI del cliente");
                String dni = sc.nextLine();
                System.out.println("Ahora introduce la contraseña para el usuario con DNI " + dni);
                String pass = sc.nextLine();
                cliente = clienteService.findClientByDni(dni, pass);

                while (cliente == null){
                    System.out.println("Datos incorrectos\n" +
                            "Introduce de nuevo el DNI:");
                    dni = sc.nextLine();
                    System.out.println("Contraseña para el usuario con DNI " + dni);
                    pass = sc.nextLine();
                    cliente = clienteService.findClientByDni(dni, pass);

                }
            } while (cliente == null);

            System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());

            int opcion = -1;
            do {
                while (opcion != 0) {
                    imprimeMenu();
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Saliendo de la aplicacion");
                            System.exit(0);
                            break;
                        case 2:
                            productoService.listProducts();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Valor no valido introduce uno valido");
                    }
                }
            } while (cliente != null);
        }
    }

    private static void imprimeMenu() {
        System.out.println("Elige una opcion");
        System.out.println("1. Salir" +
                "\n2. Comprar" +
                "\n3. Ver carrito" +
                "\n4. Ver mis pedidos");
    }
}
