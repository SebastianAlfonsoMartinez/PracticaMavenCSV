import model.Inventory;
import model.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;


public class MainConLibreria {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        try {
            FileReader fileReader = new FileReader("resources/inventory.csv");
            CSVParser csvParser = CSVFormat.EXCEL.withHeader("Nombre", "Descripcion", "Categoria", "Etiquetas", "Precio", "URL FOTO").withDelimiter(';').parse(fileReader);

            for (CSVRecord csvRecord : csvParser) {
                String name = validateText(csvRecord.get("Nombre"));
                String description = validateText(csvRecord.get("Descripcion"));
                String category = validateText(csvRecord.get("Categoria"));
                String tags = validateText(csvRecord.get("Etiquetas"));
                Float price = validatePrice(csvRecord.get("Precio"));
                String imgUrl = validateText(csvRecord.get("URL FOTO"));

                inventory.addProduct(new Product(name, description, category, tags, price, imgUrl));
                System.out.println(inventory.getProductList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String validateText(String text) {
        return (text != null && !text.isEmpty()) ? text : "N/A";
    }

    private static Float validatePrice(String num) {
        if (num != null && !num.isEmpty() && !num.equalsIgnoreCase("N/A")) {
            try {
                return Float.parseFloat(num);
            } catch (NumberFormatException e) {
                return 0.0f;
            }
        }
        return 0.0f;
    }
}




