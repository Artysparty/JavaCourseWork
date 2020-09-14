package sample.apartments;

public abstract class AbstractApartment {
    private int id;
    private int payment;
    private int barSize;
    private int numberOfRooms;
    private int numberOfBeds;


    public AbstractApartment(int payment, int barSize, int numberOfRooms, int numberOfBeds) {
        this.payment = payment;
        this.barSize = barSize;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getBarSize() {
        return barSize;
    }

    public void setBarSize(int barSize) {
        this.barSize = barSize;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

}
