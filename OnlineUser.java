
public class OnlineUser {
    private int UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Phone;
    private int AddressId;
    private boolean IsAdmin;
    private boolean IsBanned;

    public OnlineUser(int id, String fname, String lname, String isAdmin, String pword, String email, int addressId, String status){
        this.UserId = id;
        this.FirstName = fname;
        this.LastNAme = lname;
        if(isAdmin.compareToIgnoreCase("yes")==0){
            this.IsAdmin = true;
        }
        else{
            this.IsAdmin = false;
        }
        this.Password = pword;
        this.Email = email;
        this.AddressId = addressId;
        if(status.compareToIgnoreCase("Enabled") ==0){
            this.IsBanned = false;
        }
        else{
            this.IsBanned = true;
        }
    }
        
    
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }
    
    public boolean getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public boolean getIsBanned() {
        return IsBanned;
    }

    public void setIsBanned(boolean IsBanned) {
        this.IsBanned = IsBanned;
    }
    
}
