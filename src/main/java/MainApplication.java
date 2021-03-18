import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        StudentRecords studentRecords = new StudentRecords();
        TeacherRecords teacherRecords = new TeacherRecords();

        System.out.println("Please enter the path to save json files: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        List<Student> students =  studentRecords.getStudentDetails();
        List<Teacher> teachers =  teacherRecords.getTeacherDetails();

        if(students != null && teachers != null) {
            if (studentRecords.convertJavaObjectToJsonFile(students, path) && teacherRecords.convertJavaObjectToJsonFile(teachers, path)) {
                System.out.println("2 JSON files are successfully created");
            } else {
                System.out.println("There is an error while creating JSON files!!");
            }
        } else {
            System.out.println("Invalid data in CSV file!!");
        }
    }
}
