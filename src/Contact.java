//Weston Culpepper
//02/16/2025
//003
//Contact class designed to create an object that keeps track of contact information


public class Contact {
    //assigning variables
    private String homeAddress;
    private String phone;
    private String email;


    //no-args constructor
    public Contact() {
        homeAddress = null;
        phone = null;
        email = null;
    }


    //constructor with arguments
    public Contact(String homeAddress, String phone, String email) {
        this.setHomeAddress(homeAddress);
        this.setPhone(phone);
        this.setEmail(email);
    }


    //getters and setters to encapsulate private fields
    public String getHomeAddress() {
        return this.homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString to return the object information is string format
    @Override
    public String toString() {
        return "Address: " + this.homeAddress + System.lineSeparator() + "Phone Number: " + this.phone + System.lineSeparator() + "Email: " + this.email;
    }
}
