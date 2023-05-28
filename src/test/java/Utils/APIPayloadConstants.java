package Utils;

public class APIPayloadConstants {

    // we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload() {

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"jon\",\n" +
                "  \"emp_lastname\": \"jovi\",\n" +
                "  \"emp_middle_name\": \"bon\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2010-05-20\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Songwriter\"\n" +
                "}";
        return createEmployeePayload;
    }
}
