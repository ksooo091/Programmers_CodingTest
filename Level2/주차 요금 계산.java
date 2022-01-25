/*
2022-01-24
https://programmers.co.kr/learn/courses/30/lessons/92341
*/

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        	        
	     int dTime = fees[0];
	       int dFee = fees[1];
	       int pTime = fees[2];
	       int pFee = fees[3];
	       
	       ArrayList<String> riOTime = new ArrayList<>();
	       ArrayList<String> rcNum = new ArrayList<>();
	       ArrayList<String> riO = new ArrayList<>();
	       ArrayList<String> riOandTime = new ArrayList<>();
	     
	       
	      for (String str : records) {
	    	 riOTime.add(str.substring(0,5));
			rcNum.add(str.substring(6,10));
			riO.add(str.substring(11,13));
		}
	        HashSet<String> cNumHash = new HashSet<>(rcNum);
	        
	        ArrayList<String> cNumList= new ArrayList<>(cNumHash);
	    
	       int[] result = new int[cNumList.size()];
	       
	  
	 TreeMap<String, Integer> tm = new TreeMap<>();
	       
			int k=0;
	        
				for (String stri : cNumList) {
			
					int t = 0;
					int f = 0;
					int t3 = 0;
					ArrayList<String> cardata = new ArrayList<> (); 
					for (String str : records) {
						if(stri.equals(str.substring(6,10))) {
							cardata.add(str.substring(0,5));
						}
					}
					if(cardata.size() % 2 == 1 ) {
						cardata.add("23:59");
					}
		
					for(int i =0; i<cardata.size()-1;i++) {
						if(i == 0 || i % 2 == 0  ) {
						t= t+ (Integer.parseInt(cardata.get(i+1).substring(0,2))*60+Integer.parseInt(cardata.get(i+1).substring(3)))-
						(Integer.parseInt(cardata.get(i).substring(0,2))*60+Integer.parseInt(cardata.get(i).substring(3))) ;
			
					
						}
				}

					if( t - dTime <0) {
						f= dFee;
						
					}
					else if ((t - dTime)% pTime !=0) {
						f=  dFee+(((t - dTime)/ pTime+1))*pFee;
					}
					else  {
						f= dFee + ((t - dTime)/ pTime)*pFee;
						
					}
					tm.put(stri, f);
					k++;
					}		

				k=0;
			for (String key  : tm.keySet()) {
				result[k] = tm.get(key);
				k++;
			}
					

	        int[] answer = result;

	        return answer;
    }
}
