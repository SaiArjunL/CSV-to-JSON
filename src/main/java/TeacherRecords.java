import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.simple.JSONObject;

public class TeacherRecords  extends DataServices {

//      Reads the teacher records from CSV file and stores in an Arraylist
    public List<Teacher> getTeacherDetails(String filePath) {

        BufferedReader fileReader = null;
        CSVParser csvParser = null;

        List<Teacher> studentList = new ArrayList<>();

        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : csvParser) {

                if(csvRecord.get("category").equals("teacher")) {
                    if(validateDate(csvRecord.get("dob")) && validateDate(csvRecord.get("doj")) &&
                            csvRecord.size() == 22) {
                        Teacher teacher = new Teacher(
                                Integer.parseInt(csvRecord.get("id")),
                                generateFullName(csvRecord.get("firstname"), csvRecord.get("lastname")),
                                genderFunction(csvRecord.get("gender")),
                                csvRecord.get("dob"),
                                calculateAge(csvRecord.get("dob")),
                                csvRecord.get("aadhar_number"),
                                csvRecord.get("city"),
                                csvRecord.get("contact_number"),
                                csvRecord.get("emp_no"),
                                csvRecord.get("class_teacher_of"),
                                csvRecord.get("previous_school"),
                                csvRecord.get("post"),
                                csvRecord.get("doj"),
                                Integer.parseInt(csvRecord.get("salary")),
                                calculateServicePeriod(csvRecord.get("doj")),
                                parseSubjects(csvRecord.get("subject_teaches"))
                        );
                        studentList.add(teacher);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }
        return studentList;
    }

    public boolean convertJavaObjectToJsonFile(List<Teacher> teachers, String path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        Files.createDirectories(Paths.get(path));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        String fileName = "teacher_record_" + dtf.format(now) + ".json";

        JSONObject obj=new JSONObject();
        obj.put("studentRecordCount", teachers.size());
        obj.put("data", teachers);

        writer.writeValue(new File( path + "\\" + fileName), obj);
        return true;
    }
}
