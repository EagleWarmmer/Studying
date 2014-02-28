package IntegerToRoman;

import java.security.AllPermission;

public class IntegerToRoman {
	String[] all={"I","V","X","L","C","D","M","v","x"};
	public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        String b = String.valueOf(num);
        int val=1000,temp;
        String result ="";
        
        for(int i=6;i>=0;i-=2){
        	temp=num/val;
        	result=result+addString(temp,i);
        	num = num % val;
        	val/=10;
        }
        
        return result;
	}
	
	public String addString (int num,int offset){
		String result="";
		if(num==0){
			return result;
		}
		if(num<=3){
			for(int i=num;i>0;i--){
				result=result+all[offset];
			}
		}else if(num==4){
			result=all[offset+1]+result;
			result=all[offset]+result;
		}else if(num<=8){
			result=all[offset+1]+result;
			for(int i=num-5;i>0;i--){
				result=result+all[offset];
			}
		}else{
			result=all[offset+2]+result;
			result=all[offset]+result;
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman a = new IntegerToRoman();
		System.out.println(a.intToRoman(11));
	}

}
