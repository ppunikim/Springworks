package com.callor.school.exec;

public class ExecV2 {
	
	public static void main(String[] args) {
		
		int[] intKor = new int[5];
		int[] intEng = new int[5];
		int[] intMath = new int[5];
		int[] intSum = new int[5];
		int[] intBubble = new int[5];
		
		for(int i = 0; i < intKor.length; i ++ ) {
			int iKor = (int)(Math.random() * 100) + 1;
			int iEng= (int)(Math.random() * 100) + 1;
			int iMath = (int)(Math.random() * 100) + 1;
			int iSum = iKor + iEng + iMath;
			
			intKor[i] = iKor;
			intEng[i] = iEng;
			intMath[i] = iMath;
			intSum[i] = iSum;
		}//end for
		//정렬하기 전 출력
		System.out.println("정렬 전 출력");
		printScore(intKor, intEng, intMath, intSum);
		
		//정렬하기
		for(int i = 0; i < intSum.length; i ++ ) {
			for(int j = 0; j < intSum.length; j ++ ) {
				if(intSum[i] > intSum[j]) {
					intBubble[i] = intSum[i];
					intSum[i] = intSum[j];
					intSum[j] = intBubble[i];
					
					intBubble[i] = intKor[i];
					intKor[i] = intKor[j];
					intKor[j] = intBubble[i];
					
					intBubble[i] = intEng[i];
					intEng[i] = intEng[j];
					intEng[j] = intBubble[i];
					
					intBubble[i] = intMath[i];
					intMath[i] = intMath[j];
					intMath[j] = intBubble[i];
				}//end if
			}//end j 반복 for

		}//end i 반복 for	
		
		System.out.println("정렬 후 출력");
		printScore(intKor, intEng, intMath, intSum);
		
	}//end main		
		
			

	private static void printScore(int[] intKor, int[] intEng, 
								int[] intMath,int[] intSum) {
		
		for(int i = 0; i < intKor.length; i ++ ) {
			System.out.printf("%3d\t", intKor[i]);
			System.out.printf("%3d\t", intEng[i]);
			System.out.printf("%3d\t", intMath[i]);
			System.out.printf("%3d\n", intSum[i]);
		}//end for
	}//end 임의생성자
		
}//end class
