
/*
2022.1.31
https://programmers.co.kr/learn/courses/30/lessons/42888
*/
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
       
        HashMap<String, String> rec = new HashMap<>();

        for (String r:record) {
            String sp = "";
            if(r.substring(0,5).equals("Enter") || r.substring(0,5).equals("Chang")) {
                sp = r.substring(r.indexOf(" ")+1);

                rec.put(sp.substring(0,sp.indexOf(" ")),sp.substring(sp.indexOf(" ")+1));
            }

        }
        ArrayList<String> al = new ArrayList<>();
        for (String s: record) {
            if(!s.substring(0,5).equals("Chang")){
                al.add(s);
            }
        }

        String[] answer = new String[al.size()];
        int idx= 0;
        for (String s :al) {
            String sp = "";
            sp = s.substring(s.substring(0,6).indexOf(" ")+1);
            if(s.substring(0,5).equals("Enter")){
                answer[idx] = rec.get(sp.substring(0,sp.indexOf(" "))) + "님이 들어왔습니다.";
            }
            else {
                answer[idx] = rec.get(sp) + "님이 나갔습니다.";
            }


            idx++;
        }

        return answer;
    }
}
