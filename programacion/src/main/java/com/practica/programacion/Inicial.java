package com.practica.programacion;

import com.practica.programacion.gui.Principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Santiago Hernández
 */
public class Inicial {

    /**
     * Inicializamos la tienda
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(args.length);
        if (args.length > 0) {
            if (args[0].equals("Inicializar")) {
                System.out.println("");
                inicializarTienda();
                System.exit(0);
            }
        }
        try {//Archivo donde se guarda la tienda para la próxima vez
            FileInputStream fi = new FileInputStream(new File("Javapop.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Tienda.tienda = (Tienda) oi.readObject();

        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
        Tienda t = Tienda.tienda;
        Principal principal = new Principal();
        principal.setVisible(true);
        //Este código era la parte que emulaba la interfaz de usuario
        /*System.out.println(Tienda.tienda.toString());
        ArrayList<String> palabrasClave = new ArrayList<>();
        palabrasClave.add("Consola");
        //palabrasClave.add("portátil");
        System.out.println("Realizando búsqueda...");
        Cliente clienteConectado = Tienda.tienda.getClientes().get(0);
        ArrayList<Producto> busqueda_1 = Tienda.tienda.buscarProductos(Producto.TipoProducto.CONSOLAS_VIDEOJUEGOS, palabrasClave,clienteConectado.getUbicacion());
        Producto p1 = busqueda_1.get(0);
        p1.reservar(clienteConectado);
        Cliente vendedor = p1.getVendedor();
        ArrayList<Notificacion> notif=vendedor.getNotificaciones();
        System.out.println("Notificaciones de solicitudes de compra recibidas \n"+notif);
        Iterator<Notificacion> iNotif =notif.iterator();
        while (iNotif.hasNext()){
            Notificacion n=iNotif.next();
            System.out.println(n);
        }
        Notificacion solicitud=notif.get(0);
        Venta venta_1 = solicitud.getProdComprado().getVendedor().generarVenta(solicitud);
        System.out.println(venta_1.generarFichero());
        System.out.println("Realizando búsqueda con los mismos datos por segunda vez...");
        Cliente clienteConectado2 = Tienda.tienda.getClientes().get(1);
     ArrayList<Producto> busqueda_2 = Tienda.tienda.buscarProductos(Producto.TipoProducto.CONSOLAS_VIDEOJUEGOS, palabrasClave,clienteConectado2.getUbicacion());        
        Producto p2 = busqueda_2.get(0);
        
        p2.reservar(clienteConectado2);
                Cliente vendedor2 = p2.getVendedor();
        ArrayList<Notificacion> notif2=vendedor2.getNotificaciones();
        System.out.println("Notificaciones de solicitudes de compra recibidas \n"+notif2);
        Iterator<Notificacion> iNotif2 =notif2.iterator();
        while (iNotif2.hasNext()){
            Notificacion n2=iNotif2.next();
            System.out.println(n2);
        }
        Notificacion solicitud2=notif2.get(0);
        Venta venta_2 = solicitud2.getProdComprado().getVendedor().generarVenta(solicitud2);
        System.out.println(venta_2.generarFichero());*/
    }
    /**
     * Método auxiliar para inicializar la tienda con cinco usuarios y 10 productos
     */
    private static void inicializarTienda() {
        Producto producto_1 = new Producto("Iphone", "Teléfono de gama alta caro y malo", Producto.TipoProducto.MOVILES, Producto.EstadoProducto.REGULAR, 500.0, "movil_iphone_1.jpg", "28538");
        Producto producto_2 = new Producto("Televisión ", "Televisión alta definición 44 pulgadas", Producto.TipoProducto.TV_AUDIO_FOTO, Producto.EstadoProducto.COMO_NUEVO, 450.0, "television_1.jpg", "28123");
        Producto producto_3 = new Producto("Balón de fútbol ", "Rojo y blanco", Producto.TipoProducto.DEPORTE_OCIO, Producto.EstadoProducto.ACEPTABLE, 10.0, "deporte_balon_1.jpg", "28028");
        Producto producto_4 = new Producto("Stick de hockey ", "De madera", Producto.TipoProducto.DEPORTE_OCIO, Producto.EstadoProducto.COMO_NUEVO, 15.0, "deporte_stick_1.jpg", "28028");
        Producto producto_5 = new Producto("Pendientes ", "Dorados", Producto.TipoProducto.MODA_ACCESORIOS, Producto.EstadoProducto.ACEPTABLE, 3.0, "moda_pendientes_1.jpg", "28404");
        Producto producto_6 = new Producto("Ps4 ", "Consola de videojuegos de sobremesa", Producto.TipoProducto.CONSOLAS_VIDEOJUEGOS, Producto.EstadoProducto.NUEVO, 400.0, "consola_playstation_1.jpg", "28404");
        Producto producto_7 = new Producto("Samsung", "Teléfono de gama alta", Producto.TipoProducto.MOVILES, Producto.EstadoProducto.COMO_NUEVO, 750.0, "movil_samsung_1.jpg", "28023");
        Producto producto_8 = new Producto("Nintendo Switch", "Consola portátil", Producto.TipoProducto.CONSOLAS_VIDEOJUEGOS, Producto.EstadoProducto.REGULAR, 200.0, "consola_nintendo_1.jpg", "28123");
        Producto producto_9 = new Producto("Auriculares ", "Para consolas", Producto.TipoProducto.INFORMATICA_ELECTRONICA, Producto.EstadoProducto.ACEPTABLE, 13.0, "electronica_auriculares_1.jpg", "28538");
        Producto producto_10 = new Producto("Pantalones ", "Chándal gris", Producto.TipoProducto.MODA_ACCESORIOS, Producto.EstadoProducto.NUEVO, 20.0, "moda_chandal_pantalon_1.jpg", "28023");
        Cliente cliente_1 = new Cliente("juanvalero@gmail.com", "1234", "Juan Valero", "02713729L", "2738 2474 3484 4985", "28538");
        cliente_1.añadirProducto(producto_1);
        cliente_1.añadirProducto(producto_9);
        Cliente cliente_2 = new Cliente("mariadelgado@gmail.com", "2298", "Maria Delgado", "94820192T", "3848 4844 0192 8493", "28028");
        cliente_2.añadirProducto(producto_3);
        cliente_2.añadirProducto(producto_4);
        Cliente cliente_3 = new Cliente("antoniosuarez@gmail.com", "0000", "Antonio Suarez", "48493932U", "2839 0393 0132 9238", "28023");
        cliente_3.añadirProducto(producto_7);
        cliente_3.añadirProducto(producto_10);
        ClienteProfesional cliprof_1 = new ClienteProfesional("alejandroblanco@gmail.com", "2345", "Alejandro Blanco", "93892810S", "2829 0393 4849 2020", "28123", "Venta de dispositivos informáticos y de audio y video", "611402962", "abre a las 9:30", "www.alejandroblanco.com");
        cliprof_1.añadirProducto(producto_2);
        cliprof_1.añadirProducto(producto_8);
        ClienteProfesional cliprof_2 = new ClienteProfesional("miguelnuñez@gmail.com", "0987", "Miguel Núñez", "39393930G", "4844 9282 4949 0393", "28404", "Venta de ropa y accesorios", "633333654", "abre a las 11:30", "www.miguelnuñez.com");
        cliprof_2.añadirProducto(producto_5);
        cliprof_2.añadirProducto(producto_6);
        Tienda.tienda.getClientes().add(cliente_1);
        Tienda.tienda.getClientes().add(cliente_2);
        Tienda.tienda.getClientes().add(cliente_3);
        Tienda.tienda.getClientes().add(cliprof_1);
        Tienda.tienda.getClientes().add(cliprof_2);
        try {
            File fichero = new File("miTienda.dat");
            System.out.println(fichero.getAbsolutePath());
            FileOutputStream f = new FileOutputStream(fichero);
            ObjectOutputStream os = new ObjectOutputStream(f);
            os.writeObject(Tienda.tienda);
            os.close();
            f.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
    }

}
