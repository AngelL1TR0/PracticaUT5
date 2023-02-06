package app;

import service.ClienteService;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce el DNI del cliente");
            String dni = sc.nextLine();
            System.out.println("Ahora introduce la contraseña para el usuario con DNI " + dni);
            String contraseña = sc.nextLine();
            int opcion = -1;
            while (opcion != 0){
                imprimeMenu();
                opcion = sc.nextInt();
                ClienteEntity cliente = null;
                switch (opcion){
                    case 1:
                        System.out.println("Saliendo de la aplicacion");
                        System.exit(0);
                        break;
                    case 2:
                }
            }
        }

    }
    private static void imprimeMenu(){
        System.out.println("Bienvenido al sistema" + "\n Elige una opcion"  );
        System.out.println("1. Salir\n2. Comprar\n3. Ver carrito\n 4. Ver mis pedidos");
    }
}
