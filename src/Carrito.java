import java.util.ArrayList;

public class Carrito{

    private String infoProducto;
    private int cantidad;
    private double precioProducto;
    private double montoTotal;

    public Carrito(){
    }

    public String getInfoProducto() {
        return infoProducto;
    }

    public void setInfoProducto(String infoProducto) {
        this.infoProducto = infoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

}
