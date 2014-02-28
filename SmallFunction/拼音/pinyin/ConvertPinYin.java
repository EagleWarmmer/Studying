package pinyin;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ConvertPinYin {
	
	/**
	* 获得单个汉字的Ascii.
	* @param cn char
	* 汉字字符
	* @return int
	* 错误返回 0,否则返回ascii
	*/
	public static int getCnAscii(char cn) {
		byte[] bytes = (String.valueOf(cn)).getBytes();
		if (bytes == null || bytes.length > 2 || bytes.length <= 0) { // 错误
			return 0;
		}
		if (bytes.length == 1) { // 英文字符
			return bytes[0];
		}
		if (bytes.length == 2) { // 中文字符
			int hightByte = 256 + bytes[0];
			int lowByte = 256 + bytes[1];
			int ascii = (256 * hightByte + lowByte) - 256 * 256;

//			System.out.println("ASCII=" + ascii);

			return ascii;
		}

		return 0; // 错误
	}
	
	/**
	* 返回字符串的全拼,是汉字转化为全拼,其它字符不进行转换
	* @param cnStr String
	* 字符串
	* @return String
	* 转换成全拼后的字符串
	*/
	public static String getFullSpell(String cnStr) {
		StringBuffer retuBuf = new StringBuffer();
		char[] chars = cnStr.toCharArray();
		for (int i = 0, Len = chars.length; i < Len; i++) {
			int ascii = getCnAscii(chars[i]);
			if (ascii == 0) { // 取ascii时出错
				retuBuf.append(chars[i]);
			} else {
				retuBuf.append(getSpellByAscii(ascii));
			}
		}
//		System.out.println(retuBuf.toString());
		return retuBuf.toString();
	}
	
	/**
	* 返回字符串的全拼,是汉字转化为全拼,其它字符不进行转换
	* @param cnStr String
	* 字符串
	* @return String
	* 转换成全拼后取每个拼音的首字母的字符串
	*/
	public static String getFullSpellFirst(String cnStr) {
		StringBuffer retuBuf = new StringBuffer();
		String temp = null;
		char[] chars = cnStr.toCharArray();
		for (int i = 0, Len = chars.length; i < Len; i++) {
			int ascii = getCnAscii(chars[i]);
			if (ascii == 0) { // 取ascii时出错
				retuBuf.append(chars[i]);
			} else {
				temp = getSpellByAscii(ascii);
				retuBuf.append(temp.charAt(0));
			}
		}
//		System.out.println(retuBuf.toString());
		return retuBuf.toString();
	}
	
	/**
	* 根据ASCII码到SpellMap中查找对应的拼音
	* @param ascii int
	* 字符对应的ASCII
	* @return String
	* 拼音,首先判定ASCII是否>0&<160,假如是返回对应的字符,
	* 
	否则到SpellMap中查找,假如没有找到拼音,则返回null,假如找到则返回拼音.
	*/
	public static String getSpellByAscii(int ascii) {
		if (ascii > 0 && ascii < 160) { // 单字符
			return String.valueOf((char) ascii);
		}

		if (ascii < -20319 || ascii > -10247) { // 不知道的字符
			return null;
		}
		Map spellMap = PinYinStructure.getSpellMap();
		Set keySet = spellMap.keySet();
		Iterator it = keySet.iterator();

		String spell0 = null;
		;
		String spell = null;

		int asciiRang0 = -20319;
		int asciiRang;
		while (it.hasNext()) {

			spell = (String) it.next();
			Object valObj = spellMap.get(spell);
			if (valObj instanceof Integer) {
				asciiRang = ((Integer) valObj).intValue();

				if (ascii >= asciiRang0 && ascii < asciiRang) { // 区间找到
					return (spell0 == null) ? spell : spell0;
				} else {
					spell0 = spell;
					asciiRang0 = asciiRang;
				}
			}
		}
		return null;

	}
}
