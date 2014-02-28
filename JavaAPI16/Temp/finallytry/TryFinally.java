package finallytry;

public class TryFinally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ;i<10;i++){
			try{
				if( i == 3){
					throw new Exception();
				}
				System.out.println(i);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
