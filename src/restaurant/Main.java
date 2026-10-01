package restaurant;
public class Main {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = InputHelper.readInt(
                    "Choose an option: "
            );

            switch (choice) {

                case 1:
                    restaurant.displayTables();
                    break;

                case 2:
                    reserveTable(restaurant);
                    break;

                case 3:
                    createTicket(restaurant);
                    break;

                case 4:
                    addItemToTicket(restaurant);
                    break;

                case 5:
                    viewTicket(restaurant);
                    break;

                case 6:
                    restaurant.displayAllTickets();
                    break;

                case 7:
                    closeTicket(restaurant);
                    break;

                case 8:
                    cancelReservation(restaurant);
                    break;

                case 9:
                    running = false;
                    System.out.println(
                            "Thank you for using the system."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid option."
                    );
            }
        }
    }

    private static void displayMenu() {

        System.out.println("\n================================");
        System.out.println("     TICKET & TABLE SYSTEM");
        System.out.println("================================");

        System.out.println("1. View Tables");
        System.out.println("2. Reserve Table");
        System.out.println("3. Create Ticket");
        System.out.println("4. Add Item to Ticket");
        System.out.println("5. View Ticket");
        System.out.println("6. View All Tickets");
        System.out.println("7. Close Ticket");
        System.out.println("8. Cancel Reservation");
        System.out.println("9. Exit");

        System.out.println("================================");
    }

    private static void reserveTable(
            Restaurant restaurant) {

        restaurant.displayTables();

        int tableNumber = InputHelper.readInt(
                "Enter table number: "
        );

        String customerName = InputHelper.readString(
                "Enter customer name: "
        );

        restaurant.reserveTable(
                tableNumber,
                customerName
        );
    }

    private static void createTicket(
            Restaurant restaurant) {

        int tableNumber = InputHelper.readInt(
                "Enter table number: "
        );

        String customerName = InputHelper.readString(
                "Enter customer name: "
        );

        restaurant.createTicket(
                tableNumber,
                customerName
        );
    }

    private static void addItemToTicket(
            Restaurant restaurant) {

        int ticketNumber = InputHelper.readInt(
                "Enter ticket number: "
        );

        Ticket ticket =
                restaurant.findTicket(ticketNumber);

        if (ticket == null) {

            System.out.println(
                    "Ticket not found."
            );

            return;
        }

        if (ticket.isClosed()) {

            System.out.println(
                    "Cannot add items to a closed ticket."
            );

            return;
        }

        restaurant.displayMenu();

        int itemId = InputHelper.readInt(
                "Enter menu item ID: "
        );

        MenuItem item =
                restaurant.findMenuItem(itemId);

        if (item == null) {

            System.out.println(
                    "Menu item not found."
            );

            return;
        }

        int quantity = InputHelper.readInt(
                "Enter quantity: "
        );

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than zero."
            );

            return;
        }

        ticket.addItem(item, quantity);

        System.out.println(
                "Item added successfully."
        );
    }

    private static void viewTicket(
            Restaurant restaurant) {

        int ticketNumber = InputHelper.readInt(
                "Enter ticket number: "
        );

        Ticket ticket =
                restaurant.findTicket(ticketNumber);

        if (ticket == null) {

            System.out.println(
                    "Ticket not found."
            );

            return;
        }

        ticket.displayTicket();
    }

    private static void closeTicket(
            Restaurant restaurant) {

        int ticketNumber = InputHelper.readInt(
                "Enter ticket number: "
        );

        restaurant.closeTicket(ticketNumber);
    }

    private static void cancelReservation(
            Restaurant restaurant) {

        restaurant.displayTables();

        int tableNumber = InputHelper.readInt(
                "Enter table number: "
        );

        restaurant.cancelReservation(
                tableNumber
        );
    }
}