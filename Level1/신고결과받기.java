import java.util.*;

/* 2022.1.23(Sun)
  오랜만에 해서 그런지 오래도걸림;
  메일 안받는 유저가 받아야 하는 유저 사이에 있을때 빈값을 안넣어줘서 생기는 오류 해결하는데 오래걸림
  https://programmers.co.kr/learn/courses/30/lessons/92334?language=java#
*/
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

   int[] answer = new int[id_list.length];
        String inged ;
        int idx;
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        ArrayList<String> reportreal = new ArrayList<>(reportSet);
 
        HashMap<String, Integer> reported = new HashMap<>(); //신고당한유저
        HashMap<String, Integer> reportuser = new HashMap<>(); ///메일받을  유저
        ArrayList<String> baneduser = new ArrayList<>(); // 정지유저
        ArrayList<Integer> result = new ArrayList<>(); // 답

        int usercnt;
        String reportedUser;

        for (String s : reportreal) {

            inged = s;
            idx = inged.indexOf(" ");
            reportedUser = inged.substring(idx + 1);
            if (reported.get(reportedUser) == null) {
                reported.put(reportedUser, 1);

            } else if (reported.get(reportedUser) < k) {
                usercnt = reported.get(reportedUser);
                reported.put(reportedUser, usercnt + 1);

            }
            if (reported.get(reportedUser) == k) {
                usercnt = reported.get(reportedUser);
                reported.put(reportedUser, usercnt + 1);
                baneduser.add(reportedUser);
            }

        }

        for (String uname : reportreal) {

            idx = uname.indexOf(" ");
            if (baneduser.contains(uname.substring(idx + 1))) {
                if (reportuser.get(uname.substring(0, idx)) == null) {
                    reportuser.put(uname.substring(0, idx), 1);
                } else {
                    usercnt = reportuser.get(uname.substring(0, idx));
                    reportuser.put(uname.substring(0, idx), usercnt + 1);
                }
            }
        }

        for (int j = 0; j < id_list.length; j++) {
            int finalJ = j;
            result.add(0);
            reportuser.forEach((a, b) -> {

                if (id_list[finalJ].equals(a)) {

                    result.set(finalJ,b);
                }}
            );

        }


        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
