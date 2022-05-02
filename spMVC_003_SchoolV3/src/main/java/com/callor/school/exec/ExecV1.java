package com.callor.school.exec;

public class ExecV1 {
	
	public static void main(String[] args) {
		
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++ ) {
			nums[i] = (int)(Math.random() * 100 ) + 1;
		}// end 랜덤수 배열에 담기
		
		for(int num : nums) {
		System.out.printf("%d\t",num);
		}// end 담긴 배열 출력
		System.out.println(); // 한칸 띄우기
		
		for( int i = 0; i < nums.length ; i ++ ) {
			for(int j = i + 1; j < nums.length; j ++ ) { //  순서대로 비교하기 위해 사용
				if(nums[i] > nums[j]) {
					// nums[i] 값과 num[j] 를 서로 교환
					int _t = nums[i];
					nums[i] = nums[j];
					nums[j] = _t;
					
				}
			}
		}
		
		for(int num : nums) {
			System.out.printf("%d\t",num);
		}
		System.out.println(); 
		
		
		
		
	}//end main
}//end class
