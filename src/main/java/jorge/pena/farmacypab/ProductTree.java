/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorge.pena.farmacypab;
 
/**
 *
 * @author GAMERO
 */
public class ProductTree {
    private SimpleProduct simpleproduct;
    private ProductTree left;
    private ProductTree right;

    SimpleProduct simpleProduct = new SimpleProduct();
    
    public ProductTree(SimpleProduct simpleproduct) {
        this.simpleproduct = simpleproduct;
    }

    ProductTree(String simpleProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SimpleProduct getSimpleproduct() {
        return simpleproduct;
    }

    public void setSimpleproduct(SimpleProduct simpleproduct) {
        this.simpleproduct = simpleproduct;
    }

  

    public ProductTree getLeft() {
        return left;
    }

    public void setLeft(ProductTree left) {
        this.left = left;
    }

    public ProductTree getRight() {
        return right;
    }

    public void setRight(ProductTree right) {
        this.right = right;
    }
    
    public void add(SimpleProduct simpleproduct){
        if(simpleProduct.compareTo(this.simpleproduct)<0){
            if(left != null){
                left.add(simpleProduct);
            }else{
                left = new ProductTree(simpleProduct);
            }
        }else{
            if(right!=null){
                right.add(simpleProduct);
            }else{
                right = new ProductTree(simpleProduct);
            }
        }
    }
    public ProductTree find(String name) {
        if (name.equals(this.simpleProduct)) {
            return this;
        } else if (name.compareTo(simpleProduct.getName()) < 0) {
            if (this.left != null) {
                return this.left.find(name);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.find(name);
            } else {
                return null;
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(getSimpleProduct());
        if (right != null) {
            right.printInOrder();
        }
    }

    private Object getSimpleProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void add(String simpleProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void visitInOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
