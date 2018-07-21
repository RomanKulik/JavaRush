package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;

public class ProductList extends LinkedHashMap<Integer, Product> {
    private ArrayList<Product> products = new ArrayList<>();
    private String fileName;

    public ProductList(String fileName) throws ProductException {
        super();
        if (fileName != null)
            this.fileName = fileName;
        else throw
                new ProductException("fileName problem: " + fileName);
        setProductsArray();
        initProductList();
    }

    private void setProductsArray() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String s;
            while ((s = reader.readLine()) != null ||
                    "\n".equals(s)) {
                if (s.contains("\uFEFF"))
                    s = s.substring(1, s.length());
                this.products.add(new Product(s));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("setFileStrings: " + e);
        }
    }

    /**
     * Init this class as a map
     * key - ID
     * value - Product
     *
     * @throws ProductException
     */
    private void initProductList() throws ProductException {
        if (products == null)
            throw new ProductException("ArrayList<Product>products is null");
        for (Product p : this.products)
            super.put(p.getID(), p);
    }

    /**
     * Rewrite file with update information in map (ProductList = this class)
     */
    public void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product p : super.values()) {
                writer.write(p.toString(true));
                writer.newLine();
            }
            writer.flush();
            writer.close();
            System.out.println("file " + fileName + " updated successfully");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ProductException e) {
            System.out.println(e);
        }
    }

    public void update(Product product) {
        int key = product.getID();

        if (super.containsKey(key))
            super.remove(key);
        this.put(key, product);
    }

    public void update(String stringForUpdate) {
        this.update(new Product(stringForUpdate));
    }

    public void put(String string) {
        Product p = new Product(string);
        this.put(p.getID(), p);
    }

    @Override
    public Product put(Integer key, Product value) {
        if (!super.containsKey(key))
            return super.put(key, value);
        System.out.println("Error: Product with ID = " + key + " exists");
        return super.get(key);
    }

    public Product remove(Object key) {
        if (key instanceof String)
            key = Integer.parseInt(String.valueOf(key));
        return super.remove(key);
    }

    public int getMaxID() {
        //return super.lastKey();// for treeMap
        return Collections.max(this.keySet());
    }

    /**
     * @return maxID + 1
     */
    public int getNextID() {
        int maxID = this.getMaxID();
        return ++maxID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Product> entry : super.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    public static void testProductList() {

        try {
            System.out.println("Test");
            ProductList pl = new ProductList(createTestFile());
            System.out.println(pl.toString());

            System.out.println(pl.getMaxID());

            System.out.println("Put the same ID");
            pl.put("198478  Шорты пляжные черные с рисунко173.00  17");
            System.out.println(pl.toString());// id exists

            System.out.println("Update prev ID");
            pl.update("198478  Шорты пляжные черные с рисунко173.00  16");
            System.out.println(pl.toString());
            pl.updateFile();

            System.out.println("Put new string");
            pl.put("19847984Куртка для сноубордистов, разм10173.991234");
            System.out.println(pl.toString());

            System.out.println("Put new Product with ID > maxID");
            pl.put(pl.getNextID(), new Product(pl.getNextID(), "Акваланг", 23, 9999));
            System.out.println(pl.toString());

            System.out.println("Remove id 19847984");
            pl.remove(19847984);
            System.out.println(pl.toString());

            System.out.println("UpdateFile");
            pl.updateFile();
            System.out.println(pl.toString());
        } catch (ProductException e) {
            System.out.println(e);
        }
    }

    public static String createTestFile() {
        String fileName = "c:/temp/testProductList.txt";
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write("19846   Шорты пляжные синие           159.00  12");
            writer.newLine();
            writer.write("198478  Шорты пляжные черные с рисунко173.00  17");
            writer.newLine();
            writer.write("19847985Акваланг                      23.0    9999");
            writer.newLine();
            writer.write("19847986Шорты                         111.22  33");
            writer.newLine();
            writer.write("19847983Куртка для сноубордистов, разм10173.991234");
            writer.newLine();
            writer.flush();
        } catch (IOException e1) {
            System.out.println(e1);
        }

        return fileName;
    }
}
