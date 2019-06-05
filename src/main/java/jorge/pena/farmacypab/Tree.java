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
public class Tree {
      private String value;
    private Tree left;
    private Tree right;

    public Tree(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
     public void add(String value) {
        if (value.compareTo(this.value) < 0) {
            if (left != null) {
                left.add(value);
            } else {
                left = new Tree(value);
            }
        } else {
            if (right != null) {
                right.add(value);
            } else {
                right = new Tree(value);
            }
        }
    }

    public Tree find(String value) {
        if (value.equals(this.value)) {
            return this;
        } else if (value.compareTo(this.value) < 0) {
            if (this.left != null) {
                return this.left.find(value);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.find(value);
            } else {
                return null;
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(value);
        if (right != null) {
            right.printInOrder();
        }
    }
}
