package at.alperen.test.Amazon.GUIS;

import at.alperen.test.Amazon.Interfaces.GUI;
import at.alperen.test.Amazon.Interfaces.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI_1 implements GUI {

    private Scanner sc = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();


    @Override
    public void start() {
        while(true){
            System.out.print("1) Show all products: ");
            System.out.print("2) Sum of all Products in Stock: ");
            System.out.print("3) Add To Cart: ");
            System.out.print("4) ShowCart: ");

            int selection = sc.nextInt();

            if(selection == 1){
                for(Product p : products){
                    System.out.println(p.getTitle());
                }
            }
        }
    }

    @Override
    public void addProduct(Product product) {

    }
}
