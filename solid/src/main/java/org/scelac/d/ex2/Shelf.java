package org.scelac.d.ex2;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
   List<Product> products;

    public Shelf(List<Product> products) {
        this.products = products;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void customizeShelf() {}

}
