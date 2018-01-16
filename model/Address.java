package model;


public class Address {
    private int AddressId;
    private String Street;
    private String City;
    private String State;
    private String Zip;

    public Address(int addressId, String street, String city, String zip, String state){
        this.AddressId = addressId;
        this.Street = street;
        this.City = city;
        this.State = state;
        this.Zip = zip;
    }
    
    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    
}
