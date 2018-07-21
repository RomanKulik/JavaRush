package com.javarush.task.task18.task1828;

public class Product {
    private static final int MAX_LEN_OF_ID = 8;
    private static final int MAX_LEN_OF_PN = 30;
    private static final int MAX_LEN_OF_PRICE = 8;
    private static final int MAX_LEN_OF_QUANTITY = 4;
    private int ID;
    private String productName; //PN
    private double price;
    private int quantity;

    public Product() {
        this(123456789, "Шорты пляжные черные с рисункоcc", 173.00011, 17000);
    }

    public Product(String stringFromFile) {
        try {
            parseStringAndInitInstance(stringFromFile);
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
        } catch (Exception e){
            System.out.println(e);
        }
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

    public void setID(Object stringOrIntegerID) throws ProductException {
        this.ID = (int) this.setFieldsFactory(stringOrIntegerID, ProductFields.ID);
    }

    public int getID() {
        return ID;
    }

    public String getID(boolean asStringWithMaxLen) throws ProductException {
        try {
            return addSpacesToValue(String.valueOf(this.getID()), MAX_LEN_OF_ID);
        } catch (ProductException e) {
            throw new ProductException("Wrong product ID: " + e);
        }
        // System.out.println("ID: " + this.ID + " len:" + this.ID.length() + " from " + MAX_LEN_OF_ID);
    }

    public void setProductName(String productName) throws ProductException {
        this.productName = (String) this.setFieldsFactory(productName,
                ProductFields.PRODUCT_NAME);
    }

    public String getProductName() {
        return productName;
    }

    public String getProductName(boolean asStringWithMaxLen) throws ProductException {
        try {
            return addSpacesToValue(this.productName, MAX_LEN_OF_PN);
        } catch (ProductException e) {
            throw new ProductException("Wrong product name: " + e);
        }
        // System.out.println("productName: " + this.productName + " len:" + this.productName.length() + " from " + MAX_LEN_OF_PN);
    }

    public void setPrice(Object stringOrIntegerOrDoublePrice) throws ProductException {
        this.price = (double) setFieldsFactory(stringOrIntegerOrDoublePrice,
                ProductFields.PRICE);
    }

    public double getPrice() {
        return price;
    }

    public String getPrice(boolean asStringWithMaxLen) throws ProductException {
        try {
            return addSpacesToValue(String.valueOf(getPrice()), MAX_LEN_OF_PRICE);
        } catch (ProductException e) {
            throw new ProductException("Wrong product price: " + e);
        }
        //System.out.println("price: " + this.price + " len:" + this.price.length() + " from " + MAX_LEN_OF_PRICE);
    }

    public void setQuantity(Object stringOrIntegerQuantity) throws ProductException {
        this.quantity = (int) setFieldsFactory(stringOrIntegerQuantity,
                ProductFields.QUANTITY);
    }

    public int getQuantity() {
        return quantity;
    }

    public String getQuantity(boolean asStringWithMaxLen) throws ProductException {
        try {
            return addSpacesToValue(String.valueOf(this.getQuantity()), MAX_LEN_OF_QUANTITY);
        } catch (ProductException e) {
            throw new ProductException("Wrong product quantity: " + e);
        }
        //System.out.println("quantity: " + this.quantity + " len:" + this.quantity.length() + " from " + MAX_LEN_OF_QUANTITY);
    }

    private void parseStringAndInitInstance(String stringFromFile) throws ProductException {
        StringBuilder sb = new StringBuilder(stringFromFile);

        setID(sb.substring(0, MAX_LEN_OF_ID).trim());
        sb.delete(0, MAX_LEN_OF_ID);

        setProductName(sb.substring(0, MAX_LEN_OF_PN));
        sb.delete(0, MAX_LEN_OF_PN);

        setPrice(sb.substring(0, MAX_LEN_OF_PRICE).trim());
        sb.delete(0, MAX_LEN_OF_PRICE);

        setQuantity(sb.toString().trim());
    }

    /**
     * @param value         - a parsed string
     * @param maxLenOfValue - maximum size for field
     * @return parsed string whith fix lenght = maxLenOfValue
     * if lenght of value > maxLenOfValue,
     * return string with cutted value
     * if lenght of value < maxLenOfValue,
     * return string with value with append spaces to maxLenOfValue lenght of returned string
     * @throws ProductException
     */
    private String addSpacesToValue(String value, int maxLenOfValue) throws ProductException {
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

    private Object setFieldsFactory(Object value, ProductFields fieldName) throws ProductException {
        if (value == null) throw new ProductException("Wrong " + fieldName + ": " + value);

        try {
            if (value instanceof String &&
                    (fieldName.equals(ProductFields.ID) || fieldName.equals(ProductFields.QUANTITY)))
                return Integer.parseInt((String) String.valueOf(value));
            else if (value instanceof Integer &&
                    (fieldName.equals(ProductFields.ID) || fieldName.equals(ProductFields.QUANTITY)))
                return value;
            else if (value instanceof String && fieldName.equals(ProductFields.PRICE))
                return Double.parseDouble((String) String.valueOf(value));
            else if (value instanceof Double)
                return value;
            else if (value instanceof String && fieldName.equals(ProductFields.PRODUCT_NAME))
                return value;
            else
                throw new ProductException("Wrong " + fieldName + ": " + value);
        } catch (Exception e){
            System.out.println("Wrong format in command line.\n" + e);
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.ID + " " +
                this.productName + " " +
                this.price + " " +
                this.quantity;
    }

    public String toString(boolean withoutSpaces) throws ProductException {
        return this.getID(true) +
                this.getProductName(true) +
                this.getPrice(true) +
                this.getQuantity(true);
    }

    public static Product createDefaultProduct() {
        return new Product(12345678, "1-30", 123.5678, 4);
    }

    public static int generateRandomID() {
        return (int) (Math.random() * Math.pow(10, MAX_LEN_OF_ID));
    }

    public static String generateRandomID(boolean asString) {
        int id = (int) (Math.random() * Math.pow(10, MAX_LEN_OF_ID));
        return String.valueOf(id);
    }

    public static void testProduct() throws ProductException {
        Product p = new Product("123456  Шорты пляжные черные с рисунко222.33  44");

        System.out.println("Original string:\n123456  Шорты пляжные черные с рисунко222.33  44");
        System.out.println("test");
        System.out.println(p);
        System.out.println(p.toString(true));

        int id = p.getID();
        System.out.println(id);
        String ids = p.getID(true);
        System.out.println(ids + " " + ids.length());

        String name = p.getProductName();
        System.out.println(name);
        String names = p.getProductName(true);
        System.out.println(names + " " + names.length());

        double price = p.getPrice();
        System.out.println(price);
        String prices = p.getPrice(true);
        System.out.println(prices + " " + prices.length());

        int q = p.getQuantity();
        System.out.println(q);
        String qs = p.getQuantity(true);
        System.out.println(qs + " " + qs.length());
    }
}
