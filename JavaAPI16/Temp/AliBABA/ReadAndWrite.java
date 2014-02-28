package AliBABA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

import javax.xml.transform.Templates;

public class ReadAndWrite {

	public String[][] read(String fileName) {
		String[][] bag = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					fileName).getAbsoluteFile()));
			try {
				// 读取文件第一行，重量和背包个数
				String s = in.readLine();
				int count = Integer.parseInt(s);
				bag = new String[count][];

				for (int i = 0; i < count; i++) {
					s = in.readLine();
					int size = Integer.parseInt(s);
					bag[i] = new String[size];

					for (int j = 0; j < size; j++) {
						s = in.readLine();
						bag[i][j] = s;
					}
				}
			} finally {
				// 关闭文件
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// 返回Bag对象数组
		return bag;
	}

	public String[] readB(String fileName) {
		String[][] bag = null;
		int count = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					fileName).getAbsoluteFile()));
			try {
				// 读取文件第一行，重量和背包个数
				String s = in.readLine();
				count = Integer.parseInt(s);
				bag = new String[count][2];

				for (int i = 0; i < count; i++) {
					s = in.readLine();
					bag[i][0] = s.substring(0, s.indexOf(" "));
					bag[i][1] = s.substring(s.indexOf(" ") + 1, s.length());
				}

			} finally {
				// 关闭文件
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// 返回Bag对象数组
		return doit(bag, count);

	}

	/**
	 * 写文件，将结果写入文件
	 * 
	 * @param fileName
	 *            写入文件的文件名
	 * @param text
	 *            写入文件的内容 String类型
	 */
	public void write(String fileName, String[] result) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				for (int i = 0; i < result.length; i++) {

					out.print("Case #" + (i + 1) + ":" + result[i] + "\n");

				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String[] doit(String[][] bag, int count) {
		String result[] = new String[count];
		for(int i = 0;i<count;i++){
			result[i]="";
		}
		for (int i = 0; i < count; i++) {
			String s = bag[i][1];
			String[] numStrings = s.split("-");
			int[] a = new int[numStrings.length];
			for (int j = 0; j < numStrings.length; j++) {
				a[j] = Integer.parseInt(numStrings[j]);
			}

			String targetString = bag[i][0];
			String[] resultStrings = new String[a.length];
			for (int j = 0; j < a.length; j++) {
				resultStrings[j] = targetString.substring(0, a[j]);
				targetString = targetString.substring(a[j]);
			}

			for (int m = resultStrings.length-1; m >= 0; m--) {
//				long a1 = Integer.parseInt(resultStrings[m]);
				
				int countre = 0;
				int temp, tempp = -1;
				String countString = resultStrings[m];
				for (int n = 0; n <= resultStrings[m].length(); n++) {
					if(countString.length()-1>0){
						temp = Integer.parseInt(countString.substring(countString.length()-1,countString.length()));
						countString= countString.substring(0,countString.length()-1);
					}else if(countString.length()==0){
						temp=-1;
					}else {
						temp = Integer.parseInt(countString.substring(0,1));
						countString= countString.substring(0,0);
					}
					
					if (temp != tempp) {
						tempp = temp;
						if (countre == 0 || countre > 10) {
							result[i] = count(temp) + " " + result[i];
						} else {
							result[i] = countB(countre) + " " + result[i];
						}
					} else {
						countre++;
					}
				}
			}
		}
		return result;
	}

	public String countB(int a) {
		String resultString = "";
		switch (++a) {

		case 2:
			resultString = "double";
			break;
		case 3:
			resultString = "triple";
			break;
		case 4:
			resultString = "quadruple";
			break;
		case 5:
			resultString = "quintuple";
			break;

		case 6:
			resultString = "sextuple";
			break;
		case 7:
			resultString = "septuple";
			break;
		case 8:
			resultString = "octuple";
			break;
		case 9:
			resultString = "nonuple";
			break;
		case 10:
			resultString = "decuple";
			break;
		default:
			break;
		}
		return resultString;
	}

	public String count(int a) {
		String resultString = "";
		switch (a) {
		case 1:
			resultString = "one";
			break;
		case 2:
			resultString = "two";
			break;
		case 3:
			resultString = "three";
			break;
		case 4:
			resultString = "four";
			break;
		case 5:
			resultString = "five";
			break;

		case 6:
			resultString = "six";
			break;
		case 7:
			resultString = "seven";
			break;
		case 8:
			resultString = "eight";
			break;
		case 9:
			resultString = "nine";
			break;
		case 0:
			resultString = "zero";
			break;
		default:
			break;
		}
		return resultString;
	}

	public static void main(String[] args) {
		String s = "1234";
		System.out.println(s.substring(3,4));
		ReadAndWrite raw = new ReadAndWrite();
		String[] abc = raw.readB("A-small-attempt2.in");

		
		raw.write("A-small-attempt2.out", abc);

	}
}
