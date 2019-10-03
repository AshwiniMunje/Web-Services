public class Item {

    int id;
    String description;
    int quantity;
    float rate;
    float amount;

    public Item(int id, String description, int quantity, float rate) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = quantity * rate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getRate() {
        return rate;
    }
}
