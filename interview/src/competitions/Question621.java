package competitions;

/**
 * @author: ryjarvis
 * Dec 9, 2017
 * 
 */

public class Question621 {
	
    public static char nextGreatestLetter(char[] letters, char target) {
   	int i=0;
   	while(i<letters.length){
           if(target<letters[i]){
               break;
           }
   		i++;
   	}
   	if(i==letters.length-1){
   		return letters[0];
   	}
   	else{
   		return letters[i];
   	}
   }
    //Alternative interesting solution
    public char nextGreatestLetterSampleSolution(char[] letters, char target) {
        int targetNum = target - 'a';
        int answer = Integer.MAX_VALUE;
        for (char letter : letters) {
            int num = letter - 'a';
            if (num > targetNum) {
                answer = Math.min(answer, num);
            } else {
                answer = Math.min(answer, num + 26);
            }
        }
        return (char) ('a' + (answer % 26));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c={'c','f','j'};
		char res=nextGreatestLetter(c, 'k');
		System.out.println(res);

	}

}


