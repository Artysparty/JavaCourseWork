package sample.apartments;

public class ClassicApartment extends AbstractApartment implements Payment {

    public ClassicApartment(int payment, int barSize, int numberOfRooms, int numberOfBeds) {
        super(payment, barSize, numberOfRooms, numberOfBeds);
    }


    @Override
    public int getPayment() {
        return super.getPayment();
    }

    @Override
    public int getBarSize() {
        return super.getBarSize();
    }

    @Override
    public void setBarSize(int barSize) {
        super.setBarSize(barSize);
    }

    @Override
    public int getNumberOfRooms() {
        return super.getNumberOfRooms();
    }

    @Override
    public void setNumberOfRooms(int numberOfRooms) {
        super.setNumberOfRooms(numberOfRooms);
    }

    @Override
    public int getNumberOfBeds() {
        return super.getNumberOfBeds();
    }

    @Override
    public void setNumberOfBeds(int numberOfBeds) {
        super.setNumberOfBeds(numberOfBeds);
    }

    @Override
    public int calc() {
        return getNumberOfRooms() * getPayment();
    }
}
