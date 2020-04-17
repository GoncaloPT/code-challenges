package codility.first;

class Solution {
    public int solution(int n) {

        String inBinary = Integer.toBinaryString(n);
        System.out.println("n: "+ n);
        System.out.println("inBinary: "+ inBinary);
        int maxCounter = 0;

        int leftPointer = 0;
        int rightPointer = 1;

        while(rightPointer < inBinary.length()){

            while(leftPointer < inBinary.length() && inBinary.charAt(leftPointer) != '1'){
                leftPointer++;
                rightPointer++;
            }
            while(rightPointer < inBinary.length() && inBinary.charAt(rightPointer) != '1'){
                rightPointer++;
            }
            if(maxCounter < rightPointer-leftPointer && rightPointer < inBinary.length()){
                maxCounter = rightPointer-leftPointer-1;
            }
            leftPointer = rightPointer++;
        }
        return maxCounter;


    }
    public static void main(String [] args){
        System.out.println("result: " + new Solution().solution(6));
        System.out.println("result: " + new Solution().solution(328));
        System.out.println("result: " + new Solution().solution(1162));
        System.out.println("result: " + new Solution().solution(51712));
        System.out.println("result: " + new Solution().solution(66561));
    }


    /*
        int cur = Character.getNumericValue(c);
            if(cur == 1){
                // trailing 1 or end 1 ?
                if(!leadingOneFound) {
                    zeroCounter = 0;
                    leadingOneFound = true;
                }
                else{
                    //it's trailing
                    leadingOneFound = false;
                    if(maxCounter < zeroCounter){
                        maxCounter = zeroCounter;
                    }
                }
            }
            else{
                zeroCounter++;
            }
     */
}