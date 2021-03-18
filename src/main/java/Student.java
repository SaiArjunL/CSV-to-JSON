
public class Student extends Personnel {

    private String contact;
    private Integer rollNumber;
    private String className;
    private Integer totalMarks;
    private String grade;
    private Integer secPercentage;
    private String hsStream;

    public Student(Integer id, String fullname, String gender, String dob, String age, String aadhar, String city, String contact, Integer rollNumber, String className, Integer totalMarks, String grade, Integer secPercentage, String hsStream) {
        super(id, fullname, gender, dob, age, aadhar, city);
        this.contact = contact;
        this.rollNumber = rollNumber;
        this.className = className;
        this.totalMarks = totalMarks;
        this.grade = grade;
        this.secPercentage = secPercentage;
        this.hsStream = hsStream;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getSecPercentage() {
        return secPercentage;
    }

    public void setSecPercentage(Integer secPercentage) {
        this.secPercentage = secPercentage;
    }

    public String getHsStream() {
        return hsStream;
    }

    public void setHsStream(String hsStream) {
        this.hsStream = hsStream;
    }
}