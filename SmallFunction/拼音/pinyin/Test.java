package pinyin;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String ssString="abc";
		System.out.println(ConvertPinYin.getFullSpell(ssString));
		System.out.println(ConvertPinYin.getFullSpellFirst(ssString));
		System.out.println(Coding.codingByPinYin(ssString));
		
		
		ssString="tsb";
		System.out.println(ConvertPinYin.getFullSpellFirst(ssString));
		System.out.println(Coding.codingByPinYin(ssString));
	}

}
