package LongestPalindromicSubstring; 
  
public class Manacher { 
    public String longestPalindrome(String s) { 
        char[] T = per(s); 
        int P[] = new int[T.length]; 
        int C = 0, R = 0; 
        for (int i = 1; i < T.length - 1; i++) { 
            //算出i' 
            int i_mirror = 2 * C - i; 
              
            //根据i'的位置 算出P[i]  
            //if R-i<P[i'] then P[i]=R-i;  
            //if P[i']<R-i then p[i]=p[i'] 
            if (R > i) { 
                P[i] = min(P[i_mirror], R - i); 
            } 
  
            //算i附近对等数 
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) { 
                P[i]++; 
            } 
  
            //调整C的位置 
            if (i + P[i] > R) { 
                C = i; 
                R = i + P[i]; 
            } 
        } 
  
        int max = 0, set = 0; 
        for (int i = 0; i < P.length; i++) { 
            if (P[i] > max) { 
                max = P[i]; 
                set = i; 
            } 
        } 
        return s.substring((set - 1 - max) / 2, (set - 1 - max) / 2 + max); 
    } 
  
    public int min(int a, int b) { 
        if (a < b) 
            return a; 
        else
            return b; 
    } 
  
    public char[] per(String s) { 
        s = "^" + s; 
        String result = ""; 
        for (int i = 0; i < s.length(); i++) { 
            result += s.substring(i, i + 1) + "#"; 
        } 
        result = result + "$"; 
        return result.toCharArray(); 
    } 
  
    /** 
     * @param args 
     */
    public static void main(String[] args) { 
        // TODO Auto-generated method stub 
        Manacher m = new Manacher(); 
        System.out.println(m.per("abc")); 
        System.out.println(m.longestPalindrome("abb")); 
        
        System.out.println(m.longestPalindrome("lucdpkahsyjyfgvrirgjpqirhtdfbjlqkhqjdccebrveapzkccvotc"));
    } 
  
} 