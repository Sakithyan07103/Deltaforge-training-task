import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String strJson = getJSONFromFile("day9.json");
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJson);
            JSONObject mainJsonObject = null;
            if (object instanceof JSONObject) {
                mainJsonObject = (JSONObject) object;
                // proceed with parsing
            } else {
                System.out.println("Parsed object is not a JSONObject. It's: " + object.getClass().getName());
            }


            System.out.println("JSON content from file:\n" + strJson);


            /*************** First Name ****************/
            String firstName = (String) mainJsonObject.get("firstName");
            System.out.println("First Name : " + firstName);

            /*************** Last Name ****************/
            String lastName = (String) mainJsonObject.get("lastName");
            System.out.println("Last Name : " + lastName);

            /*************** Age ****************/
            long age = (long) mainJsonObject.get("age");
            System.out.println("Age : " + age);

            /*************** Address ****************/
            JSONObject jsonObjectAddress = (JSONObject) mainJsonObject.get("address");
            System.out.println("Address : ");

            String streetAddress = (String) jsonObjectAddress.get("streetAddress");
            System.out.println("      Street Address : " + streetAddress);

            String city = (String) jsonObjectAddress.get("city");
            System.out.println("      City : " + city);

            String state = (String) jsonObjectAddress.get("state");
            System.out.println("      State : " + state);

            long postalCode = (long) jsonObjectAddress.get("postalCode");
            System.out.println("      Postal Code : " + postalCode);

            /*************** Phone Numbers ****************/
            JSONArray jsonArrayPhoneNumbers = (JSONArray) mainJsonObject.get("phoneNumbers");
            System.out.println("Phone Numbers : ");

            for (int i = 0; i < jsonArrayPhoneNumbers.size(); i++) {
                JSONObject jsonPhoneNumber = (JSONObject) jsonArrayPhoneNumbers.get(i);
                System.out.println("      Phone Number " + (i + 1));

                String type = (String) jsonPhoneNumber.get("type");
                System.out.println("      Type : " + type);

                String number = (String) jsonPhoneNumber.get("number");
                System.out.println("      Number : " + number);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getJSONFromFile(String filename) {
        String jsonText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonText;
    }
}