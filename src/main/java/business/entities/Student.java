package business.entities;

public class Student
{

    public Student(int id, String email, String password, String role, int phone, int point) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.point = point;
    }

    public Student(String email, String password, String role)
    {

        this.email = email;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int point;
    private int phone;


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public String setRole(String role)
    {
        this.role = role;
        return role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
