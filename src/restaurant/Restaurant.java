package restaurant;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private List<Table> tables;
    private List<MenuItem> menu;
    private List<Ticket> tickets;

    private int nextTicketNumber = 1001;

    public Restaurant() {

        tables = new ArrayList<>();
        menu = new ArrayList<>();
        tickets = new ArrayList<>();

        createTables();
        createMenu();
    }

    private void createTables() {

        tables.add(new Table(1, 2));
        tables.add(new Table(2, 4));
        tables.add(new Table(3, 4));
        tables.add(new Table(4, 6));
        tables.add(new Table(5, 8));
    }

    private void createMenu() {

        menu.add(new MenuItem(1, "Jollof Rice", 45.00));
        menu.add(new MenuItem(2, "Fried Chicken", 35.00));
        menu.add(new MenuItem(3, "Fried Rice", 40.00));
        menu.add(new MenuItem(4, "Banku & Tilapia", 60.00));
        menu.add(new MenuItem(5, "Coke", 15.00));
        menu.add(new MenuItem(6, "Water", 8.00));
    }

    public void displayTables() {

        System.out.println("\n========== TABLES ==========");

        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public Table findTable(int tableNumber) {

        for (Table table : tables) {

            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }

        return null;
    }

    public boolean reserveTable(
            int tableNumber,
            String customerName) {

        Table table = findTable(tableNumber);

        if (table == null) {
            System.out.println("Table does not exist.");
            return false;
        }

        if (table.isReserved()) {
            System.out.println("Table is already reserved.");
            return false;
        }

        table.reserve(customerName);

        System.out.println(
                "Table " + tableNumber +
                " successfully reserved."
        );

        return true;
    }

    public boolean cancelReservation(int tableNumber) {

        Table table = findTable(tableNumber);

        if (table == null) {
            System.out.println("Table does not exist.");
            return false;
        }

        if (!table.isReserved()) {
            System.out.println("Table is not reserved.");
            return false;
        }

        table.cancelReservation();

        System.out.println(
                "Reservation cancelled successfully."
        );

        return true;
    }

    public void displayMenu() {

        System.out.println("\n========== MENU ==========");

        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }

    public MenuItem findMenuItem(int id) {

        for (MenuItem item : menu) {

            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public Ticket createTicket(
            int tableNumber,
            String customerName) {

        Table table = findTable(tableNumber);

        if (table == null) {
            System.out.println("Table does not exist.");
            return null;
        }

        Ticket ticket = new Ticket(
                nextTicketNumber++,
                tableNumber,
                customerName
        );

        tickets.add(ticket);

        System.out.println(
                "Ticket #" +
                ticket.getTicketNumber() +
                " created successfully."
        );

        return ticket;
    }

    public Ticket findTicket(int ticketNumber) {

        for (Ticket ticket : tickets) {

            if (ticket.getTicketNumber() == ticketNumber) {
                return ticket;
            }
        }

        return null;
    }

    public void displayAllTickets() {

        if (tickets.isEmpty()) {

            System.out.println("No tickets available.");

            return;
        }

        for (Ticket ticket : tickets) {
            ticket.displayTicket();
        }
    }

    public void closeTicket(int ticketNumber) {

        Ticket ticket = findTicket(ticketNumber);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        if (ticket.isClosed()) {
            System.out.println("Ticket is already closed.");
            return;
        }

        ticket.closeTicket();

        Table table = findTable(ticket.getTableNumber());

        if (table != null) {
            table.cancelReservation();
        }

        System.out.println(
                "Ticket #" +
                ticketNumber +
                " closed successfully."
        );
    }
}