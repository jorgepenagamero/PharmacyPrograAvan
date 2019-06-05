/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorge.pena.farmacypab;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author GAMERO
 */
public class Inventory {
    //ProductTree productTree = new ProductTree();
    SimpleProduct simpleProduct = new SimpleProduct();
    
    public ProductTree readInventory(InputStream in){
        ProductTree productTree = null;
        try(Scanner scanner = new Scanner(in)){
            if(scanner.hasNextLine()){
                scanner.nextLine();
            }
            int lineNumber = 1;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String simpleProduct = getFields(line, lineNumber++);
                if(productTree == null){
                    productTree = new ProductTree(simpleProduct);
                }else{
                    productTree.add(simpleProduct);
                }
            }
        }
        return productTree;
    }
    private String getFields(String line, int lineNumber){
        String data[] = line.split(",( / [ ]");
        
        SimpleProduct simpleProduct = new SimpleProduct();
        simpleProduct.setName(removeQuotes(data[1]));
        simpleProduct.setStock(Integer.parseInt(removeQuotes(data[3])));
        simpleProduct.setLineNumber(lineNumber);
        return line;
    }

    private String removeQuotes(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
