package Utils;

import netscape.javascript.JSObject;
import org.json.JSONObject;

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

    public static String createEmployeePayloadJson() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "jon");
        obj.put("emp_lastname", "jovi");
        obj.put("emp_middle_name", "bon");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2010-05-20");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Songwriter");
        return obj.toString();

    }
}
