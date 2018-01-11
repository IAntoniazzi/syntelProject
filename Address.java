
public class Address {
    private static int AddressId;
    private static String Street1;
    private static String Street2;
    private static String City;
    private static String State;
    private static String Zip;
    private static boolean IsDeliverable;

    public static int getAddressId() {
        return AddressId;
    }

    public static void setAddressId(int AddressId) {
        Address.AddressId = AddressId;
    }

    public static String getStreet1() {
        return Street1;
    }

    public static void setStreet1(String Street1) {
        Address.Street1 = Street1;
    }

    public static String getStreet2() {
        return Street2;
    }

    public static void setStreet2(String Street2) {
        Address.Street2 = Street2;
    }

    public static String getCity() {
        return City;
    }

    public static void setCity(String City) {
        Address.City = City;
    }

    public static String getState() {
        return State;
    }

    public static void setState(String State) {
        Address.State = State;
    }

    public static String getZip() {
        return Zip;
    }

    public static void setZip(String Zip) {
        Address.Zip = Zip;
    }

    public static boolean isIsDeliverable() {
        return IsDeliverable;
    }

    public static void setIsDeliverable(boolean IsDeliverable) {
        Address.IsDeliverable = IsDeliverable;
    }
    
}
