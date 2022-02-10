/*
https://programmers.co.kr/learn/courses/30/lessons/42889
2022.2.10
*/

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
         int[] answer = new int[N];
       HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
       HashMap<Integer, Double> hm2= new HashMap<Integer, Double>();
        for (int i = 1; i <= N; i++) {
            hm.put(i,0);
        }
        for (int i : stages) {
            if(i != N+1) {
                hm.put(i, hm.get(i) + 1);
            }
        }
        ArrayList<Double> al = new ArrayList<>();
        double user = stages.length;

        for (int i = 1; i <= N; i++) {
            if(user == 0){
                al.add((double) 0);
                hm2.put(i, (double) 0);
            }
            else {
                al.add((hm.get(i) / user));
                hm2.put(i, (hm.get(i) / user));
                user = user - hm.get(i);
            }
        }
        Collections.sort(al,Collections.reverseOrder());
        int idx= 1;
        for (double d:al) {

            for (int i:hm2.keySet()
                 ) {
                if(d==hm2.get(i)){
                    answer[idx -1] = i;
                    hm2.put(i,-1.1);
                    break;
                }
            }

                idx++;
        }
        
        return answer;
    }
}
