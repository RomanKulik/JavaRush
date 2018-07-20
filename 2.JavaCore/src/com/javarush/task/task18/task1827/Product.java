package com.javarush.task.task18.task1827;

public class Product {
    private static final int MAX_LEN_OF_ID = 8;
    private static final int MAX_LEN_OF_PN = 30;
    private static final int MAX_LEN_OF_PRICE = 8;
    private static final int MAX_LEN_OF_QUANTITY = 4;
    private String ID;
    private String productName; //PN
    private String price;
    private String quantity;

    public Product() {
        this(123456789, "Шорты пляжные черные с рисункоcc", 173.00011, 17000);
    }

    public Product(int ID, String productName, double price, int quantity) {
        try {
            setID(ID);
            setProductName(productName);
            setPrice(price);
            setQuantity(quantity);
        } catch (ProductException e) {
            System.out.println(e);
        }
    }

    public Product(String ID, String productName, String price, String quantity) {
        try {
            setID(ID);
            setProductName(productName);
            setPrice(price);
            setQuantity(quantity);
        } catch (ProductException e) {
            System.out.println(e);
        }
    }

    public void setID(Object ID) throws ProductException {
        try {
            this.ID = parseValue(String.valueOf(ID), MAX_LEN_OF_ID);
        } catch (ProductException e) {
            throw new ProductException("Wrong product ID: " + e);
        }
       // System.out.println("ID: " + this.ID + " len:" + this.ID.length() + " from " + MAX_LEN_OF_ID);
    }

    public void setProductName(String productName) throws ProductException {
        try {
            this.productName = parseValue(productName, MAX_LEN_OF_PN);
        } catch (ProductException e) {
            throw new ProductException("Wrong product productName: " + e);
        }
       // System.out.println("productName: " + this.productName + " len:" + this.productName.length() + " from " + MAX_LEN_OF_PN);
    }

    public void setPrice(Object price) throws ProductException {
        try {
            this.price = parseValue(String.valueOf(price), MAX_LEN_OF_PRICE);
        } catch (ProductException e) {
            throw new ProductException("Wrong product price: " + e);
        }
        //System.out.println("price: " + this.price + " len:" + this.price.length() + " from " + MAX_LEN_OF_PRICE);
    }

    public void setQuantity(Object quantity) throws ProductException {
        try {
            this.quantity = parseValue(String.valueOf(quantity), MAX_LEN_OF_QUANTITY);
        } catch (ProductException e) {
            throw new ProductException("Wrong product quantity: " + e);
        }
        //System.out.println("quantity: " + this.quantity + " len:" + this.quantity.length() + " from " + MAX_LEN_OF_QUANTITY);
    }

    private String parseValue(String value, int maxLenOfValue) throws ProductException {
        if (value == null)
            throw new ProductException(value);

        if (value.length() <= maxLenOfValue) { // add spaces to maxLenOfValue
            StringBuilder sb = new StringBuilder(value);
            for (int i = 0; i < maxLenOfValue - value.length(); i++)
                sb.append(' ');
            return sb.toString();
        } else if (value.length() > maxLenOfValue) { // cut the value to lenght = maxLenOfValue
            return value.substring(0, maxLenOfValue);
        } else {
            throw new ProductException(value);
        }
    }

    @Override
    public String toString() {
        return this.ID + /*" " +*/
                this.productName + /*" " +*/
                this.price + /*" " +*/
                this.quantity;
    }

    public static Product create() {
        return new Product(12345678, "1-30", 123.5678, 4);
    }

    public static Product create(int ID, String productName, double price, int quantity) {
        return new Product(ID, productName, price, quantity);
    }

    public static String generateRandomID() {
        int id = (int) (Math.random() * Math.pow(10, MAX_LEN_OF_ID));
        return String.valueOf(id);
    }

    public static String generateNextID(String previous) {
        int id = Integer.parseInt(previous);
        return String.valueOf(++id);
    }
}
