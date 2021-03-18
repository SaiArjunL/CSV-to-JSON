import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataServices {

//      Generates full name from first name and last name for both student and teacher
    static String generateFullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }
//      Maps 'f' to "Female" and 'm' to "Male
    static String genderFunction(String gender){
        return gender.equals("f") ? "Female" : (gender.equals("m") ? "Male" : "Others");
    }

//      Calculates age from date of birth (dob) for both student and teacher
    static String calculateAge(String dob) throws ParseException {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date d = sdf.parse(dob);
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        return diff1.getYears() + " Years " + diff1.getMonths() + " Months";
    }

//      Calculates grade from secured percentage for student
    static String calculateGrade(Integer percentage){
        if(percentage >= 90)
        {
            return "A+";
        }
        else if(percentage >= 80)
        {
            return "A";
        }
        else if(percentage >= 70)
        {
            return "B+";
        }
        else if(percentage >= 60)
        {
            return "B";
        }
        else if(percentage >= 50)
        {
            return "B";
        }
        else
        {
            return "D";
        }
    }

//      Validates date format in csv file
    public static boolean validateDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        }
        else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

//      Calculates service period for teacher
    public static String calculateServicePeriod(String doj) throws ParseException {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date d = sdf.parse(doj);
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        return diff1.getYears() + " Years " + diff1.getMonths() + " Months";
    }

//      Parses the subjects_teaches for teacher
    public static List<String> parseSubjects(String subjects){
        String[] arrOfSubjects = subjects.split("-");
        return Arrays.asList(arrOfSubjects);
    }
}
