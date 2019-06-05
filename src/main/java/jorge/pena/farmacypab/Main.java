/*
 * aplicación la cual permita administrar el inventario existente y poder crear
 * los pedidos desde estaaplicación la cual permita administrar el inventario 
 * existente y poder crear los pedidos desde esta
 * La aplicación debe de permitir la carga del inventario inicial desde un
 * archivo, dado que los inventarios pueden crecer demasiado no podrá cargar
 * todo el ar-chivo a memoria, por lo que deberá de crear un indice utilizando
 * la estructura de árbol binario almacenando el numero de linea y el nombre
 * del fármaco dentro del nodo.
 */
package jorge.pena.farmacypab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author GAMERO
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    private ProductTree productTree;
    private Scanner scanner;

    public static void main(String[] args) {

        Main m = new Main();
        m.doMenu();
        File file = new File(Main.class.getResource("C:\\Users\\GAMERO\\Documents\\NetBeansProjects\\FarmacyPAB\\src\\main\\java\\resources\\Inventory-test-01.csv").getFile());
        m.loadFile(file);

       menuPrincipal();
        m.readFile();
        
          
        
    }

//    public static void menuPrincipal() {
//       // Main m = new Main(System.in);
//        //m.doMenu();
//        File file = new File(Main.class.getResource("C:\\Users\\GAMERO\\Documents\\NetBeansProjects\\FarmacyPAB\\src\\main\\java\\resources\\Inventory-test-01.csv").getFile());
//       // m.loadFile(file);
//        int opcion;
//        do {
//            mostrarMenuConRecuadro("*****Tu salud en mis manos******",
//                    "distribuidora de fármacos a nivel nacional",
//                    "",
//                    "Opciones disponibles:",
//                    "  1) Cargar y ver archivo CSV ",
//                    "  2) ***Crear pedidos  ",
//                    "  3) ***Ingresar informacion ",
//                    "  4) ***Facturacion",
//                    "  0) ***Salir de programa ", "",
//                    "Seleccione una opción:");
//            opcion = scan.nextInt();
//            while (opcion < 0 || opcion > 4) {
//                System.out.println("Opcion incorrecta, intentar nuevamente ..");
//                opcion = scan.nextInt();
//            }
//
//            switch (opcion) {
//                case 1:
//                   // m.loadFile(file);
//                    break;
//                case 2:
//                 //   m.listProducts();
//                    break;
//                case 3:
//                //subMenuFacturas();
//                case 4:
//                //subMenuGuardar();
//            }
//        } while (opcion != 0);
//
//    }

    private void findProduct() {
        System.out.print("product name: ");
        String name = scanner.nextLine();
        SimpleProduct simpleProduct = null;
        ProductTree tree = productTree.find(name);
        if (tree != null) {
            System.out.println("Product: " + tree.getSimpleproduct());
        } else {
            System.out.println("Product: " + name + " no encontrado");
        }
    }

    public void doMenu() {
        boolean stayInMenu = true;
        do {
            System.out.println(generateMenu());
            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    loadFile();
                    break;
                case "2":
                    listProducts();
                    break;
                case "3":
                    findProduct();
                    break;
                case "X":
                case "x":
                    stayInMenu = false;
                    break;

            }
        } while (stayInMenu);
    }

    public static String generateMenu() {
        String newLine = System.lineSeparator();
        return newLine
                + "1. Cargard Inventario de archivo " + newLine
                + "2. Mostrar productos " + newLine
                + "3. Encontrar Productos " + newLine
                + newLine
                + "X. Salir " + newLine
                + newLine
                + "Option: ";
    }

    public void listProducts() {
        if (productTree != null) {
            productTree.visitInOrder();
        } else {
            System.out.println("Inventorio esta vacio. ");
        }
    }

    public void loadFile() {
        System.out.println("File name to load: ");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        loadFile(file);
    }

    public void loadFile(File file) {
        try {
            if (file.exists()) {
                InputStream inputStream = new FileInputStream(file);
                Inventory inventory = new Inventory();
                productTree = inventory.readInventory(inputStream);
                inputStream.close();
                System.out.println("loading file: " + file.getName());
            } else {
                System.out.println("Error: file no encontrado " + file.getName());
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void mostrarMenuConRecuadro(String... lineas) {
        String barra = "+---------------------------------------------------+";
        System.out.println();
        System.out.println(barra);
        for (String linea : lineas) {
            linea = "| " + linea;
            for (int i = linea.length(); i < barra.length() - 1; i++) {
                linea += " ";
            }
            linea += "|";
            System.out.println(linea);
        }
        System.out.println(barra);
        System.out.println();
    }

}
