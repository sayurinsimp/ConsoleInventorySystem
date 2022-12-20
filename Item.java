public class Item {
    private long id;
    private String name;
    private int quantity;
    private String type;
    private String size;

    public Item(long id, String name, int quantity, String type, String size) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.size = size;
    }

    public String toString() {
        return "Item {ID=" + this.id + ", Name='" + this.name + "', Quantity=" + this.quantity + ", Type='" + this.type + "', Size='" + this.size + "'}";
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getType() {
        return this.type;
    }

    public String getSize() {
        return this.size;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
