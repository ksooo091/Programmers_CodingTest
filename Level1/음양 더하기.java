
/*
https://programmers.co.kr/learn/courses/30/lessons/76501
2022.1.31
*/
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
        int idx = 0;
        for (int i: absolutes) {
            if(signs[idx]){
                answer+=i;
            }
            else{
                answer-=i;
            }
            idx++;
        }
        return answer;
    }
}
