import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Producto> productosDisponibles = new ArrayList<>();

        Producto p1 = new Producto();
        p1.setIdProducto(1);
        p1.setNombreProducto("Camiseta Dry Fit");
        p1.setDescripcionProducto("Ideal para entrenar");
        p1.setPrecioProducto(19.99);
        p1.setStockProducto(10);

        Producto p2 = new Producto();
        p2.setIdProducto(2);
        p2.setNombreProducto("Leggings Flex");
        p2.setDescripcionProducto("Comodísimos y resistentes");
        p2.setPrecioProducto(29.99);
        p2.setStockProducto(5);

        productosDisponibles.add(p1);
        productosDisponibles.add(p2);


        Cliente cliente = new Cliente("Johan", "Diaz", "johan@gmail.com", "calle lillo 32");
        Producto producto = new Producto();
        Tienda tienda = new Tienda();
        tienda.crearCliente(cliente);

        Carrito nuevoItem = new Carrito();
        nuevoItem.setInfoProducto(producto.getNombreProducto());
        nuevoItem.setPrecioProducto(producto.getPrecioProducto());
        nuevoItem.setCantidad(1); // puedes pedirlo por Scanner también
        nuevoItem.setMontoTotal(producto.getPrecioProducto() * 1);


        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do{
            System.out.println("----- BIENVENIDOS A VALTIX FITNESS -----");
            System.out.println(" --- --- --- --- --- --- --- --- --- --- ");
            System.out.println("1. Mi informacion");
            System.out.println("2. Nuestros productos");
            System.out.println("3. Carrito de compras");
            System.out.println("4. Historial de Pedidos");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    cliente.informacionCliente();
                    break;
                case 2:
                    System.out.println("----- PRODUCTOS DISPONIBLES -----");
                    for (Producto prod : productosDisponibles) {
                        System.out.println("ID: " + prod.getIdProducto());
                        System.out.println("Nombre: " + prod.getNombreProducto());
                        System.out.println("Descripción: " + prod.getDescripcionProducto());
                        System.out.println("Precio: " + prod.getPrecioProducto());
                        System.out.println("Stock: " + prod.getStockProducto());
                        System.out.println("-----------------------------");
                    }

                    System.out.println("¿Qué producto quieres agregar al carrito? Ingresa el ID:");
                    int idElegido = sc.nextInt();

                    System.out.println("¿Cuántas unidades quieres?");
                    int cantidad = sc.nextInt();

                    // Buscar producto por ID
                    for (Producto prod : productosDisponibles) {
                        if (prod.getIdProducto() == idElegido) {
                            if (cantidad <= prod.getStockProducto()) {
                                Carrito item = new Carrito();
                                item.setInfoProducto(prod.getNombreProducto());
                                item.setCantidad(cantidad);
                                item.setPrecioProducto(prod.getPrecioProducto());
                                item.setMontoTotal(prod.getPrecioProducto() * cantidad);

                                cliente.agregarPedido(item); // esto lo llamamos de cliente
                                prod.setStockProducto(prod.getStockProducto() - cantidad);

                                System.out.println("Producto agregado al carrito con éxito!");
                            } else {
                                System.out.println("No hay suficiente stock.");
                            }
                            break; // salimos del for
                        }
                    }
                    break;

                case 3:
                    System.out.println("TU CARRITO:");
                    for (Carrito c : cliente.getPedido()) {
                        System.out.println("- Producto: " + c.getInfoProducto());
                        System.out.println("  Cantidad: " + c.getCantidad());
                        System.out.println("  Precio Unitario: " + c.getPrecioProducto());
                        System.out.println("  Total: " + c.getMontoTotal());
                        System.out.println("-------------------------");
                    }
                    break;

                case 4:
                    System.out.println("HISTORIAL DE PEDIDOS:");
                    ArrayList<Carrito> pedidos = cliente.getPedido();

                    if (pedidos.isEmpty()) {
                        System.out.println("No tienes pedidos aún.");
                    } else {
                        double totalGeneral = 0;
                        for (Carrito pedido : pedidos) {
                            System.out.println("- Producto: " + pedido.getInfoProducto());
                            System.out.println("  Cantidad: " + pedido.getCantidad());
                            System.out.println("  Precio: " + pedido.getPrecioProducto());
                            System.out.println("  Total: " + pedido.getMontoTotal());
                            System.out.println("----------------------");

                            totalGeneral += pedido.getMontoTotal();
                        }
                        System.out.println("TOTAL GENERAL: " + totalGeneral);
                    }
                    break;
                case 5:
                    break;
            }

        } while (opcion !=5);

    }

}
