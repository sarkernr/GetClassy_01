public class Product {
    private String ID;
    private String name;
    private String description;
    private double cost;

    // Constructor
    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    // Getters
    public String getID() { return ID; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCost() { return cost; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCost(double cost) { this.cost = cost; }

    // Methods
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f", ID, name, description, cost);
    }

    public String toJSON() {
        return String.format("{\"ID\":\"%s\", \"name\":\"%s\", \"description\":\"%s\", \"cost\":%.2f}",
                ID, name, description, cost);
    }

    public String toXML() {
        return String.format("<Product><ID>%s</ID><Name>%s</Name><Description>%s</Description><Cost>%.2f</Cost></Product>",
                ID, name, description, cost);
    }

    @Override
    public String toString() {
        return String.format("Product[ID=%s, name=%s, description=%s, cost=%.2f]", ID, name, description, cost);
    }
}