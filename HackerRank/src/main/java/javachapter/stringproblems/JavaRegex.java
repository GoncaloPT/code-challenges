package javachapter.stringproblems;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-regex/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * Use Regex to validate IPv4 ip address
 */
public class JavaRegex {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }


}

class MyRegex{
    //public String pattern = "[0-9]{1,3}[\\.]{1}[0-9]{1,3}[\\.]{1}[0-9]{1,3}[\\.]{1}[0-9]{1,3}$";
    public String pattern = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
}



