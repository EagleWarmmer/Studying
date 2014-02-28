package FileReadWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteAndRead {

	public void read(String fileName) {
		int count = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					fileName).getAbsoluteFile()));
			try {
				count = Integer.parseInt(in.readLine());
				String s;

				for (int i = 1; i <= count; i++) {
					if ((s = in.readLine()) != null) {
						String[] ss = s.split(" ");
						for (int j = 1; j <= ss.length; j++) {
							int m = Integer.parseInt(ss[j - 1]);
						}
					}
				}
			} finally {
				// 关闭文件
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 写文件，将结果写入文件
	 * 
	 * @param fileName
	 *            写入文件的文件名
	 * @param text
	 *            写入文件的内容 String类型
	 */
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				out.println("123");
				for (int i = 1; i <= 1; i++) {
					out.print(i + " ");
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
