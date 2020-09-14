package sample.hotel;

public class Order {
    private int id;
    private int idperson;
    private String apartmentname;

    public int getId() {
        return id;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getApartmentname() {
        return apartmentname;
    }

    public void setApartmentname(String apartmentname) {
        this.apartmentname = apartmentname;
    }

    public Order(int id, int idperson, String apartmentname) {
        this.id = id;
        this.idperson = idperson;
        this.apartmentname = apartmentname;
    }
}
