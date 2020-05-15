package interviewprepkit;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        //how many times can be repeat the full string?
        long stringRepetitions = n / s.length();
        int rest = Math.toIntExact((n % s.length()));
        long numberOfAs = s.chars().filter(c -> c == 'a' || c == 'A').count();
        return numberOfAs * stringRepetitions + s.subSequence(0, rest).chars().filter(c -> c == 'a' || c == 'A').count();
    }


    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        //Writer out = new FileWriter(System.getenv("OUTPUT_PATH"));
        Writer out = new OutputStreamWriter(System.out);
        BufferedWriter bufferedWriter = new BufferedWriter(out);

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}