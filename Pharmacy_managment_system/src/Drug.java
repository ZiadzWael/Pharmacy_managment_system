
public class Drug {
    private String name;
    private String id;
    private double price;
    private  int quantity;


    public Drug() {
    }

    public Drug(String name, String id, double price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    public void displayAll() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Price: " + price + ", Quantity: " + quantity;
    }


}

