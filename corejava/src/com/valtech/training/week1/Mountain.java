package com.valtech.training.week1;
//
import java.util.Arrays;
import java.util.List;

public class Mountain {

   
    // A main method to test some examples
    public static void main (String [] args) {
      Mountain mn =new Mountain();
      System.out.println(mn.isMountain(4,5,3,2,1));
      System.out.println(mn.isMountain(3,4,8,9,10));
      System.out.println(mn.isMountain(4,1,6,7,10));
        
        }
    public boolean isMountain(int...i) {
    	int peak=identifyPeak(i);
    	if(peak==0||peak==i.length-1) return false;
    	boolean asc=checkAscending(peak, i);
    	boolean desc=checkDescending(i,peak);
    			return asc&&desc;
  
    }
	private boolean checkDescending(int[] i,int peak) {
		// TODO Auto-generated method stub
	boolean desc=true;
	for(int j=peak;j<i.length-1;j++) {
		if(i[j]<i[j+1]) {
			desc=false;
		}
		
	}
	return desc;
			
		
	}
	private boolean checkAscending(int peak,int [] i) {
		// TODO Auto-generated method stub
		boolean asc=true;
		for (int j=0;j<peak-1;j++) {
			if(i[j]>i[j+1]) {
				asc=false;
			}
			
		}
		return asc;
	}
	private int identifyPeak(int[] i) {
		// TODO Auto-generated method stub
		
		int index=0;
		int max=0;
		for (int j=0;j<i.length;j++) {
			if(i[j]>max) {
				max=i[j];
				index=j;
			}
		}
		return index;
	}
 
}

