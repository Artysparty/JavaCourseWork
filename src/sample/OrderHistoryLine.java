package sample;

import sample.hotel.Order;

public class OrderHistoryLine extends Order {
    private String firstname;
    private String lastname;
    private String username;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OrderHistoryLine(int id, int idperson, String apartmentname, String firstname, String lastname, String username) {
        super(id, idperson, apartmentname);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }
}
