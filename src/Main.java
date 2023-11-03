import model.Inventory;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String validateText(String text) {
        return !text.isEmpty() ? text : "";
    }

    private static float validatePrice(String num) {
        return !num.isEmpty() ? Float.parseFloat(num) : 0.0f;
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(";", 6);
//                System.out.println(Arrays.stream(productInfo).toList());
//                System.out.println(line);
                if (productInfo.length >= 6) {
                    System.out.println(productInfo[0]);
                    String name = validateText(productInfo[0]);
                    String description = validateText(productInfo[1]);
                    String category = validateText(productInfo[2]);
                    String tags = validateText(productInfo[3]);
                    Float price = validatePrice(productInfo[4]);
                    String imgUrl = validateText(productInfo[5]);

//                    System.out.println("Nombre: " + name + "Descripcion: " + description + "Categoria: " + category +
//                            "Tags: " + tags + "Precio: " + price + "URLFOTO: " + imgUrl);


                    inventory.addProduct(new Product(name, description, category, tags, price, imgUrl));
                    System.out.println("------------------\n" +
                            inventory.getProductList().toString());
                }else
                    System.out.println("Linea no contiene suficientes valores");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}