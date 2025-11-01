public class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Customer: " + name + " | Contact: " + contact;
    }
}
