import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private ArrayList<Carrito> pedido;

    public Cliente(String nombre, String apellido, String email, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        pedido = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carrito> getPedido() {
        return pedido;
    }

    public void informacionCliente(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: "+ apellido);
        System.out.println("Email: " + email);
        System.out.println("Direccion: "+ direccion);
    }

    public void agregarPedido(Carrito item){
        pedido.add(item);
    }

}
