/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorge.pena.farmacypab;

import static com.sun.org.apache.xalan.internal.lib.NodeInfo.lineNumber;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author GAMERO
 */
public class ReadInventory {

    //SimpleProduct simpleProduct = new SimpleProduct();

    public static void readFile() throws Exception {

        InputStream inputStream = new FileInputStream("C:\\Users\\GAMERO\\Documents\\NetBeansProjects\\FarmacyPAB\\src\\main\\java\\resources\\Inventory-test-01.csv");
        Scanner scanner = new Scanner(inputStream);
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        int lineNumber = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] datos = line.split(",");

            System.out.print(lineNumber++ + "-");
            System.out.println(line);
            System.out.println("datos[0] = " + datos[0].trim());
            System.out.println("datos[1] = " + datos[1].trim());
            System.out.println("datos[2] = " + datos[2].trim());
            System.out.println("datos[3] = " + datos[3].trim());
            System.out.println("datos[4] = " + datos[4].trim());
        }
        scanner.close();
        inputStream.close();
    }

    public static SimpleProduct cargarProducto(String[] datos, Integer lineNumber) {
        SimpleProduct product = new SimpleProduct();
        product.setLineNumber(lineNumber);
        product.setName(datos[1]);
        product.setStock(Integer.parseInt(datos[4]));
        return product;
    }
    private Integer lineNumber;
    private Object name;

    public Integer getLineNumber(Integer lineNumber) {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

//    int compareTo(SimpleProduct anotherSimpleProduct){
//        if(anotherSimpleProduct == null){
//            throw new IllegalArgumentException("Argument Show");
//        }
//        if(anotherSimpleProduct.getName()==null){
//            throw new IllegalArgumentException("Argument Show");
//        }
//        return this.name.compareTo(anotherSimpleProduct.getName());
//    }

    void cargarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
