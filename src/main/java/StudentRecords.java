import java.io.*;
import java.nio.charset.StandardCharsets;
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

public class StudentRecords extends DataServices {

//      Reads the student records from CSV file and stores in an Arraylist
    public List<Student> getStudentDetails() {

        CSVParser csvParser = null;

        List<Student> studentList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("master-data.csv");

            try (InputStreamReader streamReader =
                         new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader fileReader = new BufferedReader(streamReader)) {

            csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : csvParser) {

                if(csvRecord.get("category").equals("student")) {
                    if((Integer.parseInt(csvRecord.get("total_marks")) > 0 && Integer.parseInt(csvRecord.get("total_marks")) <= 1000) &&
                            validateDate(csvRecord.get("dob")) && csvRecord.size() == 22) {
                        Student student = new Student(
                                Integer.parseInt(csvRecord.get("id")),
                                generateFullName(csvRecord.get("firstname"), csvRecord.get("lastname")),
                                genderFunction(csvRecord.get("gender")),
                                csvRecord.get("dob"),
                                calculateAge(csvRecord.get("dob")),
                                csvRecord.get("aadhar_number"),
                                csvRecord.get("city"),
                                csvRecord.get("contact_number"),
                                Integer.parseInt(csvRecord.get("roll_no")),
                                csvRecord.get("class"),
                                Integer.parseInt(csvRecord.get("total_marks")),
                                calculateGrade(Integer.parseInt(csvRecord.get("sec_percent"))),
                                Integer.parseInt(csvRecord.get("sec_percent")),
                                csvRecord.get("hs_stream")
                        );
                        studentList.add(student);
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                assert csvParser != null;
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }
        return studentList;
    }

//      Writes the Arraylist of student records to a JSON file
    public boolean convertJavaObjectToJsonFile(List<Student> students, String path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        Files.createDirectories(Paths.get(path));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        String fileName = "student_record_" + dtf.format(now) + ".json";

        JSONObject obj=new JSONObject();
        obj.put("studentRecordCount", students.size());
        obj.put("data", students);

        writer.writeValue(new File( path + "\\" + fileName), obj);
        return true;
    }
}