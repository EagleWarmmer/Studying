package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Length {

	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] record = new int[256];
		for (int i = 0; i < record.length; i++) {
			record[i] = 0;
		}
		char[] ss = s.toCharArray();
		int cout = 0, length = 0;

		for (int i = 0; i < s.length(); i++) {
			if (record[ss[i]] == 0) {
				record[ss[i]] = 1;
				cout++;
			} else {
				if (cout > length) {
					length = cout;
				}
				for (int j = i; j >= 0; j--) {
					record[ss[j]] = 0;
				}
				
				record[ss[i]] = 1;
				cout = 1;
				continue;
			}
			if (cout > length) {
				length = cout;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		Length l = new Length();
		// System.out.println(l.lengthOfLongestSubstring("wlrb" +
		// "bmq" +
		// "bhcdarzowk" +
		// "kyhid" +
		// "dqsc" +
		// "dxrjmowf" +
		// "rxsjybld" +
		// "befsarc" +
		// "bynecd" +
		// "yg" +
		// "gx" +
		// "xpklore" +
		// "l" +
		// "lnmpa" +
		// "pqfwkho" +
		// "pkmco")); //4
		System.out.println(l.lengthOfLongestSubstring("abcddcbae"));
	}
}
