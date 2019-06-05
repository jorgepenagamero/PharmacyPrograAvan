/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorge.pena.farmacypab;

import java.util.Objects;

/**
 *
 * @author GAMERO
 */
public class SimpleProduct {

    private String name;
    private Integer stock;
    private Integer lineNumber;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public SimpleProduct(String name, Integer stock, Integer lineNumber) {
        this.name = name;
        this.stock = stock;
        this.lineNumber = lineNumber;
    }

    SimpleProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "lineNumber: " + lineNumber
                + ", name: " + name
                + ", stock: " + stock;
    }
//    @Override
//    public boolean equals(Object o){
//        if(this== o)return true;
//        if(o==null)|| getClass() != o.getClass()) return false;
//        SimpleProduct that = (SimpleProduct) o;
//        return Objects.equals(name, that.name)&&
//                Objects.equals(stock, that.stock) &&
//                Objects.equals(lineNumber, that.lineNumber);
//    }
    @Override
    public int hashCode(){
        return Objects.hash(name, stock, lineNumber);
    }

    int compareTo(SimpleProduct simpleproduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
