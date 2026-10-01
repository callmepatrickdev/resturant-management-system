package restaurant;
public class Table {

    private int tableNumber;
    private int capacity;
    private boolean reserved;
    private String customerName;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.reserved = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void reserve(String customerName) {
        this.reserved = true;
        this.customerName = customerName;
    }

    public void cancelReservation() {
        this.reserved = false;
        this.customerName = null;
    }

    @Override
    public String toString() {

        if (reserved) {
            return "Table " + tableNumber +
                    " | Capacity: " + capacity +
                    " | Reserved by: " + customerName;
        }

        return "Table " + tableNumber +
                " | Capacity: " + capacity +
                " | Available";
    }
}