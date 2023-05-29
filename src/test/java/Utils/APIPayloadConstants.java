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

    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson() {

        JSONObject obj = new JSONObject();
        obj.put("employee_id", "57730A");
        obj.put("emp_firstname", "mack");
        obj.put("emp_lastname", "ball");
        obj.put("emp_middle_name", "the");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2002-05-20");
        obj.put("emp_status", "Probation");
        obj.put("emp_job_title", "Superstar");
        return obj.toString();
    }
}
