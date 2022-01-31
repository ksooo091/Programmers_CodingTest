/*
https://programmers.co.kr/learn/courses/30/lessons/86051
2022.1.31
*/

class Solution {
    public int solution(int[] numbers) {
            int answer = -1;
        int a = 0;

        for (int i: numbers) {
            a += i;
        }
        answer = 45-a;


        return answer;
    }
}
