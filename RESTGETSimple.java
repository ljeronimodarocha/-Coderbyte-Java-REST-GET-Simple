/*
Java REST GET Simple
In the Java file, write a program to perform a GET request on the route: 
https://coderbyte.com/api/challenges/json/rest-get-simple
and then print to the console the hobbies property in the following format:
ITEM1, ITEM2, ...
Example output:
running, painting
 
*/


import java.util.*;
import java.io.*;
import java.net.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

                String result = streamReader.lines().collect(Collectors.joining("\n"));

                int lastIndex = result.lastIndexOf(String.format("\"%s\"", "hobbies"));
                result = result.substring(lastIndex);
                lastIndex = result.lastIndexOf("[");
                result = result.substring(lastIndex + 1);
                result = result
                        .replace("[\\]}\"]", "")
                        .replace("\\,", ", ")
                        .trim();
                System.out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
