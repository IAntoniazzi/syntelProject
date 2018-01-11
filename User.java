
public class User {
    private static int UserId;
    private static String FirstName;
    private static String LastName;
    private static String Email;
    private static String Password;
    private static String Phone;
    private static int AddressId;
    private static boolean IsAdmin;
    private static boolean IsBanned;

    public static int getUserId() {
        return UserId;
    }

    public static void setUserId(int UserId) {
        User.UserId = UserId;
    }

    public static String getFirstName() {
        return FirstName;
    }

    public static void setFirstName(String FirstName) {
        User.FirstName = FirstName;
    }

    public static String getLastName() {
        return LastName;
    }

    public static void setLastName(String LastName) {
        User.LastName = LastName;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        User.Email = Email;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        User.Password = Password;
    }

    public static String getPhone() {
        return Phone;
    }

    public static void setPhone(String Phone) {
        User.Phone = Phone;
    }

    public static int getAddressId() {
        return AddressId;
    }

    public static void setAddressId(int AddressId) {
        User.AddressId = AddressId;
    }
    /*
    public static void getAddress(int AddressId){
        address.getAddress(AddressId);
    }
    
    public static void setAddress(String Street1, String Street2, String City, String State, String Zip){
        address.setAddress(Street1, Street2, City, State, Zip);
    }*/

    public static boolean isIsAdmin() {
        return IsAdmin;
    }

    public static void setIsAdmin(boolean IsAdmin) {
        User.IsAdmin = IsAdmin;
    }

    public static boolean isIsBanned() {
        return IsBanned;
    }

    public static void setIsBanned(boolean IsBanned) {
        User.IsBanned = IsBanned;
    }
    
}
