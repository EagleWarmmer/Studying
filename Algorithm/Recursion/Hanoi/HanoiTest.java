package Hanoi;

public class HanoiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String init ="A";
		String temp="B";
		String end="C";
		
		hanoiMove(3,init,end,temp);
	}
	
	public static void hanoiMove(int n,String initNeedle,String endNeedle,String tempNeedle){
		if(n==1){
			System.out.println("Move "+initNeedle+" TO "+endNeedle);//就剩最后一个，从最初位置移到最终位置
		}else{
			hanoiMove(n-1,initNeedle,tempNeedle,endNeedle);    		//将n-1个先移到temp上
			System.out.println("Move "+initNeedle+" TO "+endNeedle);	//将第n个移到最终位置上
			hanoiMove(n-1,tempNeedle,endNeedle,initNeedle);			//将第n-1从temp上移到最终位置上。
		}
	}
}
