package strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

    Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");

    public void parseLine(String line) {

        Matcher m = p.matcher(line);
        System.out.println("line is " + line);
        while (m.find()) {
            String startTag = m.group(1);
            System.out.println("startTag : " + startTag + "content " + m.group(2));
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TagContentExtractor tEx = new TagContentExtractor();
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            tEx.parseLine(line);

            testCases--;
        }
    }
}
