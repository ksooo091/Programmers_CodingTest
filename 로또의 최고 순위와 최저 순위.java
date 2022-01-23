/*
https://programmers.co.kr/learn/courses/30/lessons/77484#fn1
2022.01.23
쉽게품
*/

import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
       int[] answer = {0, 0};
        Arrays.stream(lottos).sorted();
        ArrayList<Integer> aLottos = new ArrayList<>();

        for (int wn: win_nums) {
            //해당값이 들어 있는가?
           if(Arrays.stream(lottos).anyMatch(x -> x == wn )){
               aLottos.add(wn);
           }
        }
        Set<Integer> hashset= new HashSet<>();
        for (int num: lottos) {
            hashset.add(num);
        }
        int lowWin = aLottos.size();


        switch (lowWin){

            case 6 :
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3 :
                answer[1] = 4;
                break;
            case 2 :
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
                break;

        }
        int zeroNum = 0;
        if(Arrays.stream(lottos).anyMatch(x -> x == 0 )){
            int x=  hashset.size() ;

            switch (x){
                case 6 :
                    zeroNum = 1;
                    break;
                    case 5 :
                    zeroNum = 2;
                    break;
                    case 4 :
                    zeroNum = 3;
                    break;
                    case 3 :
                    zeroNum = 4;
                    break;
                    case 2 :
                    zeroNum = 5;
                    break;
                    case 1 :
                    zeroNum = 6;
                    break;

            }



        }

        else{
            answer[0] = answer[1] ;
            return answer;
        }


        switch (zeroNum){

            case 6 :
                answer[0] = 1;
                break;
            case 5:
                if (lowWin == 1){
                    answer[0] = 1;
                }
                else {
                    answer[0] =2;
                }
                break;
            case 4:
                if (lowWin == 2){
                    answer[0] = 1;
                }
                else if (lowWin == 1){
                    answer[0] = 2;
                }
                else {
                    answer[0] = 3;
                }
                break;
            case 3 :
                if (lowWin == 3){
                    answer[0] = 1;
                }
                else if(lowWin == 2){
                    answer[0] = 2;
                }
                else if(lowWin == 1){
                    answer[0] = 3;
                }
                else {
                    answer[0] = 4;
                }
                break;
            case 2 :
                if (lowWin == 4){
                    answer[0] = 1;
                }
                else if (lowWin == 3){
                    answer[0] = 2;
                }
                else if(lowWin == 2){
                    answer[0] = 3;
                }
                else if(lowWin == 1){
                    answer[0] = 4;
                }
                else{
                    answer[0] = 5;
                }
                break;
            case 1:
                if (lowWin == 5){
                    answer[0] = 1;
                }
                else if (lowWin == 4){
                    answer[0] = 2;
                }
                else if(lowWin == 3){
                    answer[0] = 3;
                }
                else if(lowWin == 2){
                    answer[0] = 4;
                }
                else if(lowWin == 1){
                    answer[0] = 5;
                }
                else {
                    answer[0] = 6;
                }
                break;
            default:
                answer[0] = 6;
                break;

        }
        return answer;
    }
}
