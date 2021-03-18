import java.util.List;

public class Teacher extends Personnel {

    private String contact;
    private String empNo;
    private String classTeacher;
    private String doj;
    private String servicePeriod;
    private String previousSchool;
    private String post;
    private List<String> subjectTeaches;
    private Integer salary;

    public Teacher(){
    }

    public Teacher(Integer id, String fullname, String gender, String dob, String age, String aadhar, String city, String contact, String empNo, String classTeacher, String previousSchool, String post, String doj, Integer salary, String servicePeriod, List<String> subjectTeaches) {
        super(id, fullname, gender, dob, age, aadhar, city);
        this.contact = contact;
        this.empNo = empNo;
        this.classTeacher = classTeacher;
        this.previousSchool = previousSchool;
        this.post = post;
        this.doj = doj;
        this.salary = salary;
        this.servicePeriod = servicePeriod;
        this.subjectTeaches = subjectTeaches;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmpNo() {
        return empNo;
    }

    public List<String> getSubjectTeaches() {
        return subjectTeaches;
    }

    public void setSubjectTeaches(List<String> subjectTeaches) {
        this.subjectTeaches = subjectTeaches;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) {
        this.servicePeriod = servicePeriod;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }
}