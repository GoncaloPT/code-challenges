package interviewprepkit.dictionariesandhashmaps;

/*
 * Create by: @author silvagc
 * 14/05/2020
 */

import java.io.PrintStream;

public class RansomNote {

    private final PrintStream out;
    public RansomNote(){
        out = System.out;
    }

    public RansomNote(PrintStream out) {
        this.out = out;
    }


    void checkMagazine(String[] magazine, String[] note) {
        for (String neededWord : note) {
            boolean found = false;
            for (int i = 0; i < magazine.length; i++) {
                String magazineWord = magazine[i];
                if (neededWord.equals(magazineWord)) {
                    found = true;
                    magazine[i] = "";
                    break;
                }
            }
            if(!found){
                out.println("No");
                return;
            }
        }
        out.println("Yes");


    }

}
