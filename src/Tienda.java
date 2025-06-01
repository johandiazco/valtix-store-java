import java.util.ArrayList;

public class Tienda {


    private ArrayList<Cliente> clientes;

    public Tienda(){
        clientes = new ArrayList<>();
    }

    public void agregarPedido(String clientePedido, Producto producto){
        boolean encontrado = false;
        for(Cliente clie: clientes){
            if(clie.getNombre().equalsIgnoreCase(clientePedido)){
                clie.agregarPedido(producto);
                encontrado = true;
            }
        }if(!encontrado){
            System.out.println("El cliente no Existe!");
        }
    }

    public void crearCliente(Cliente cliente){
        clientes.add(cliente);
    }

}