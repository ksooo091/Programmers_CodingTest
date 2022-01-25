
/*
2022.01.26
https://programmers.co.kr/learn/courses/30/lessons/42862
*/
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
       int answer = n-lost.length;
    
             ArrayList<Integer> res = new ArrayList<>();
  

       for (int i : reserve){
            res.add(i);
       }
int idx = 0;
        for (int i: lost) {
            if(res.contains(i)){
                res.set(res.indexOf(i), -1);
                 lost[idx]=-5;
                answer++;
                
            }
            idx++;
        }


        for (int i: lost) {
           
        
               
                    if (res.contains(i - 1)) {
                        res.set(res.indexOf(i - 1), -2);
                        answer++;
                    } else if (res.contains(i + 1)) {
                        res.set(res.indexOf(i + 1), -3);
                        answer++;
                    }

                
            
        }

      
        return answer;
    
    }
}
