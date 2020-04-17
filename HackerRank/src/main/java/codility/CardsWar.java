package codility;

public class CardsWar {

    public int solution(String a, String b) {
        // they should match
        if (a.length() != b.length()) {
            return -1;
        }
        int aWinsCount = 0;
        for(int i = 0 ; i < a.length(); i++){
            Character curA = a.charAt(i);
            Character curB = a.charAt(i);

            if(CardToRank(curA) > CardToRank(curB) ){
                aWinsCount++;
            }
        }
        return aWinsCount;
    }


    /**
     * Turns characters into numerical values
     */
    public static int CardToRank(Character card){
        switch (card){
            case 'A':return 14;
            case 'K':return 13;
            case 'Q':return 12;
            case 'J':return 11;
            case 'T':return 10;
            default: return Character.getNumericValue(card);
        }
    }
}
