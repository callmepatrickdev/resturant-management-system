package restaurant;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private int ticketNumber;
    private int tableNumber;
    private String customerName;

    private List<MenuItem> items;
    private List<Integer> quantities;

    private boolean closed;

    public Ticket(int ticketNumber, int tableNumber, String customerName) {

        this.ticketNumber = ticketNumber;
        this.tableNumber = tableNumber;
        this.customerName = customerName;

        items = new ArrayList<>();
        quantities = new ArrayList<>();

        closed = false;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isClosed() {
        return closed;
    }

    public void addItem(MenuItem item, int quantity) {

        items.add(item);
        quantities.add(quantity);
    }

    public double calculateTotal() {

        double total = 0;

        for (int i = 0; i < items.size(); i++) {

            total += items.get(i).getPrice() * quantities.get(i);
        }

        return total;
    }

    public void closeTicket() {
        closed = true;
    }

    public void displayTicket() {

        System.out.println("\n================================");
        System.out.println("          TICKET #" + ticketNumber);
        System.out.println("================================");

        System.out.println("Table: " + tableNumber);
        System.out.println("Customer: " + customerName);

        System.out.println("--------------------------------");

        if (items.isEmpty()) {
            System.out.println("No items added.");
        } else {

            for (int i = 0; i < items.size(); i++) {

                MenuItem item = items.get(i);
                int quantity = quantities.get(i);

                double subtotal = item.getPrice() * quantity;

                System.out.printf(
                        "%-20s x%d   ₵%.2f%n",
                        item.getName(),
                        quantity,
                        subtotal
                );
            }
        }

        System.out.println("--------------------------------");

        System.out.printf(
                "Total:                 ₵%.2f%n",
                calculateTotal()
        );

        System.out.println("Status: " +
                (closed ? "Closed" : "Open"));

        System.out.println("================================");
    }
}