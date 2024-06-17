package gestion_productos;

import java.util.*;

public class GestionProductosMain {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        final Map<String, List<Producto>> listadoTiendas = new TreeMap<>();

        boolean salir = false;
        while (!salir) {
            switch (dibujarMenuGrupos()) {
                case 1:
                    crearTienda(listadoTiendas);
                    break;
                case 2:
                    listarTienda(listadoTiendas);
                    break;
                case 3:
                    eliminarTienda(listadoTiendas);
                    break;
                case 4:
                    seleccionarTienda(listadoTiendas);
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }

        sc.close();
    }

    public static int dibujarMenuGrupos() {
        System.out.println();
        System.out.println("Elige una opción:");
        System.out.println("1. Crear una tienda");
        System.out.println("2. Listar tienda");
        System.out.println("3. Eliminar una tienda");
        System.out.println("4. Seleccionar una tienda");
        System.out.println("0. Salir");

        int opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    private static void crearTienda(Map<String, List<Producto>> listadoTiendas) {
        String tienda = leerTienda();
        if (listadoTiendas.containsKey(tienda)) {
            System.out.println("La tienda ya existe");
        } else {
            listadoTiendas.put(tienda, new ArrayList<>());
            System.out.println("Tineda creada con éxito");
        }
    }

    public static void listarTienda(Map<String, List<Producto>> listado) {
        for (String tienda : listado.keySet()) {
            System.out.println("> " + tienda);
        }
    }

    private static void eliminarTienda(Map<String, List<Producto>> listado) {
        String tienda = leerTienda();
        if (!listado.containsKey(tienda)) {
            System.out.println("El grupo no existe");
        } else {
            listado.remove(tienda);
            System.out.println("Grupo eliminado con éxito");
        }
    }

    private static void seleccionarTienda(Map<String, List<Producto>> listadoProductos) {
        String tienda = leerTienda();
        List<Producto> listadoEstudiantes = listadoProductos.get(tienda);

        if (null == listadoEstudiantes) {
            System.out.println("La tienda no existe");
        } else {
            mainEstudiantes(listadoEstudiantes);
        }
    }

    public static String leerTienda() {
        System.out.print("Tienda: ");
        return sc.nextLine();
    }

    private static void mainEstudiantes(List<Producto> listadoProductos) {
        boolean salir = false;
        while (!salir) {
            switch (MenuProductos()) {
                case 1:
                    listarProductos(listadoProductos);
                    break;
                case 2:
                    anyadirProducto(listadoProductos);
                    break;
                case 3:
                    insertarProducto(listadoProductos);
                    break;
                case 4:
                    ordenarProductoPorPrecio(listadoProductos);
                    break;
                case 5:
                    eliminarProducto(listadoProductos);
                    break;
                case 6:
                    eliminarProductos(listadoProductos);
                    break;
                case 0:
                    salir = true;
            }
        }
    }

    private static int MenuProductos() {
        System.out.println();
        System.out.println("Elige una opción:");
        System.out.println("1. Listar productos");
        System.out.println("2. Añadir un producto al final de la tienda seleccionada");
        System.out.println("3. Insertar un producto en la posición indicada");
        System.out.println("4. Ordenar los productos por el precio.");
        System.out.println("5. Eliminar un producto de la posición indicada");
        System.out.println("6. Eliminar todos los productos de una tienda");
        System.out.println("0. Salir");

        int opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    private static void listarProductos(List<Producto> listadoProductos) {
        for (int i = 0; i < listadoProductos.size(); i++) {
            System.out.printf("%02d: %s\n", i + 1, listadoProductos.get(i));
        }
    }

    private static void anyadirProducto(List<Producto> listadoProductos) {
        Producto p = leerProducto();
        listadoProductos.add(p);
        System.out.println("Producto insertado");
    }

    private static void insertarProducto(List<Producto> listadoProductos) {
        int pos = leerPosicion(listadoProductos.size() + 1); // +1 porque empieza desde la posición 0;
        Producto p = leerProducto();
        listadoProductos.add(pos, p);
        System.out.println("Producto insertado");
    }

    private static void ordenarProductoPorPrecio(List<Producto> listadoEstudiantes) {
        listadoEstudiantes.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return (int) (o1.getPrecio() - o2.getPrecio());
            }
        });
    }

    private static void eliminarProducto(List<Producto> listadoProductos) {
        int pos = leerPosicion(listadoProductos.size());
        Producto p = listadoProductos.remove(pos);
        System.out.println("Producto eliminado: " + p);
    }

    private static void eliminarProductos(List<Producto> listadoEstudiantes) {
        listadoEstudiantes.clear();
        System.out.println("Productos de la tienda eliminados.");
    }

    public static Producto leerProducto() {
        String marca;
        String descripcion;
        float precio;

        System.out.print("Marca: ");
        marca = sc.nextLine();
        System.out.print("Descripción: ");
        descripcion = sc.nextLine();
        System.out.print("Precio: ");
        precio = sc.nextFloat();
        sc.nextLine();

        return new Producto(marca, descripcion, precio);
    }

    public static int leerPosicion(int max) {
        int num;

        do {
            System.out.printf("Posición [1-%d]: ", max);
            num = sc.nextInt();
        } while (num < 1 || num > max);
        sc.nextLine();

        // devolver como un índice de [0,size()-1]
        return num - 1;
    }

}
