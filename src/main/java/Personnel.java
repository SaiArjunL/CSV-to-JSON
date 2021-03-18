
public class Personnel
{
    private Integer id;
    private String fullname;
    private String gender;
    private String dob;
    private String age;
    private String aadhar;
    private String city;

    public Personnel(){
    }

    public Personnel(Integer id, String fullname, String gender, String dob, String age, String aadhar, String city) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
        this.aadhar = aadhar;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}