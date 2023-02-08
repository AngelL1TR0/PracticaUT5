package app;

import entity.ClienteEntity;
import entity.PedidoEntity;
import entity.ProductoEntity;
import service.ClienteService;
import service.PedidoService;
import service.ProductoService;

import java.text.NumberFormat;
import java.util.*;

public class Ejercicio1 {

    private static ClienteService clienteService = new ClienteService();
    private static ProductoService productoService = new ProductoService();
    private static ClienteEntity cliente;
    private static List<PedidoEntity> bolsaCompra;
    private static PedidoService pedidoService = new PedidoService();

    public static void main(String[] args) {


        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Bienvenido al sistema\nIntroduce el DNI del cliente");
            String dni = sc.nextLine();
            System.out.println("Ahora introduce la contraseña para el usuario con DNI " + dni);
            String pass = sc.nextLine();
            cliente = clienteService.findClientByDni(dni, pass);

            while (cliente == null) {
                System.out.println("Datos incorrectos\n" +
                        "Introduce de nuevo el DNI:");
                dni = sc.nextLine();
                System.out.println("Contraseña para el usuario con DNI " + dni);
                pass = sc.nextLine();
                cliente = clienteService.findClientByDni(dni, pass);

            }

            System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());

            menuPrincipal();
        }
    }

    private static void menuPrincipal() {
        try (Scanner sc = new Scanner(System.in)){
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
                            List<ProductoEntity> productos = productoService.listProducts();
                            int contador = 2;
                            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("ES", "ES"));
                            System.out.println("1- Volver");
                            for (ProductoEntity productoEntity : productos) {
                                System.out.println(contador + " " + productoEntity.getNombre() + " (" + numberFormat.format(productoEntity.getPrecio()) + ")");
                                contador++;
                            }
                            menuTallas(productos);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Valor no valido introduce uno valido");
                            opcion = sc.nextInt();
                    }
                }
            } while (cliente != null);
        }
    }

    private static void menuTallas(List<ProductoEntity> productos) {
        int indexProducto = 1;
        String nombre = "";
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce el numero del articulo que quieres comprar?");
            indexProducto = sc.nextInt();
            do {
                while (indexProducto != 0) {
                    switch (indexProducto) {
                        case 1:
                            imprimeMenu();
                            break;
                        case 2:
                            nombre = productos.get(indexProducto - 1).getNombre();
                            productoService.listTypeOfProduct(nombre);
                            bolsaCompra = pedidoService.guardaPedido(productos.get(indexProducto -1));
                            menuPrincipal();
                            System.exit(0);
                            break;
                        case 3:
                            nombre = productos.get(indexProducto - 1).getNombre();
                            productoService.listTypeOfProduct(nombre);
                            System.exit(0);
                            break;
                        case 4:
                            nombre = productos.get(indexProducto - 1).getNombre();
                            productoService.listTypeOfProduct(nombre);
                            System.exit(0);
                            break;
                        case 5:
                            nombre = productos.get(indexProducto - 1).getNombre();
                            productoService.listTypeOfProduct(nombre);
                            System.exit(0);
                            break;
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
