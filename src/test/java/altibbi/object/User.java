package altibbi.object;

public class User {
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private  String phone;

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    private  String bdate;


    // pogo class idea > any argument i want to send i have to make propriety for the class it also privet

    public User(String firstName, String lastName, String email, String password,String bdate,String phone){
        this.email=email;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.bdate=bdate;
        this.phone=phone;


    }

    private String email ;
    private String firstName ;
    private String lastName ;
    private String password ;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    // becouse they are privet i have to make getter and setter





}
