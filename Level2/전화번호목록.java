/*
옛날에품
*/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
      Arrays.sort(phone_book);
        
        for (int i =0; i<phone_book.length-1; i++ )
        {
            
            answer=phone_book[i+1].contains(phone_book[i]);
       
            if(answer){ break;}
        }
        
      if(answer) {answer = false;}
           else {answer = true;}
        
        return answer;
    }
}
