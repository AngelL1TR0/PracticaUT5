package app;

import entity.ClienteEntity;
import entity.PedidoEntity;
import entity.ProductoEntity;
import service.ClienteService;
import service.PedidoService;
import service.ProductoService;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static ClienteService clienteService = new ClienteService();
    private static ProductoService productoService = new ProductoService();
    private static ClienteEntity cliente;
    private static List<ProductoEntity> carrito;
    private static PedidoService pedidoService = new PedidoService();

    private static void imprimeMenu() {
        System.out.println("Elige una opcion");
        System.out.println("1. Salir" +
                "\n2. Comprar" +
                "\n3. Ver carrito" +
                "\n4. Ver mis pedidos");
    }

    private static void registro() {
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

            carrito = new ArrayList<>();
            menuPrincipal(carrito, cliente);
        }
    }

    private static void menuPrincipal(List<ProductoEntity> carrito, ClienteEntity cliente) {
        try (Scanner sc = new Scanner(System.in)) {
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
                            menuTallas(productos, carrito);
                            break;
                        case 3:
                            BigDecimal total = new BigDecimal(0);
                            contador = 1;
                            numberFormat = NumberFormat.getCurrencyInstance(new Locale("ES", "ES"));
                            System.out.println("Lista de la compra: ");
                            for (ProductoEntity producto : carrito) {
                                System.out.println(contador + ". " + producto.getNombre() + " (" + numberFormat.format(producto.getPrecio()) + ")");
                                total = total.add(producto.getPrecio());
                                contador++;
                            }
                            System.out.println("Total................" + numberFormat.format(total));
                            menuCompra(carrito, cliente);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Valor no valido introduce uno valido");
                            opcion = sc.nextInt();
                    }
                }
            } while (Main.cliente != null);
        }
    }

    private static void menuCompra(List<ProductoEntity> carrito, ClienteEntity cliente) {
        int select = -1;
        while (select > 1 || select < 3){
            switch (select) {
                case 1:
                    System.out.println("Finalizar compra:");
                    pedidoService.guardaPedido(cliente);
                    menuPrincipal(carrito, cliente);
                    break;
                case 2:
                    System.out.println("Vaciando carrito");
                    carrito.clear();
                    menuPrincipal(carrito, cliente);
                    break;
                case 3:
                    System.out.println("Volviendo al menu");
                    menuPrincipal(carrito, cliente);
                    break;
            }
        }
    }

    private static void menuTallas(List<ProductoEntity> productos, List<ProductoEntity> carrito) {
        int indexProducto = -1;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce el numero del articulo que quieres comprar?");
            indexProducto = sc.nextInt();
            do {
                while (indexProducto != 0) {
                    switch (indexProducto) {
                        case 1:
                            menuPrincipal(carrito, cliente);
                            break;
                        case 2:
                            alCarrito(productos, indexProducto, carrito);
                            break;
                        case 3:
                            alCarrito(productos, indexProducto, carrito);
                            break;
                        case 4:
                            alCarrito(productos, indexProducto, carrito);
                            break;
                        case 5:
                            alCarrito(productos, indexProducto, carrito);
                            break;
                    }
                }
            } while (cliente != null);
        }
    }

    private static void alCarrito(List<ProductoEntity> productos, int indexProducto, List<ProductoEntity> carrito) {
        int contador = 2;
        String nombre = "";
        nombre = productos.get(indexProducto - 2).getNombre();
        productos = productoService.listTypeOfProduct(nombre);
        System.out.println(nombre + "\n 1- Volver");
        for (ProductoEntity productEntity : productos) {
            System.out.println(" " + contador + "- Talla " + productEntity.getTalla() + " " + productEntity.getColor());
            contador++;
        }
        System.out.println("Introduce el un numero de producto para añadir al carrito");

        try (Scanner sc = new Scanner(System.in)) {
            int seleccionado = -1;
            seleccionado = sc.nextInt();
            while (seleccionado > 1 || seleccionado < 4) {
                switch (seleccionado) {
                    case 1:
                        System.out.println("Volver");
                        menuPrincipal(carrito, cliente);
                        break;
                    case 2:
                        carrito.add(productos.get(indexProducto - 2));
                        System.out.println(nombre + " anyadido al carrito");
                        System.out.println(carrito);
                        menuPrincipal(carrito, cliente);
                        break;
                    case 3:
                        carrito.add(productos.get(indexProducto - 2));
                        System.out.println(nombre + " anyadido al carrito");
                        menuPrincipal(carrito, cliente);
                        break;
                    case 4:
                        carrito.add(productos.get(indexProducto - 2));
                        System.out.println(nombre + " anyadido al carrito");
                        menuPrincipal(carrito, cliente);
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        registro();
    }
}
