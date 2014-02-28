package FastSort;

import java.util.Random;

public class FastSortClass {
	
	public static <T extends Comparable<? super T>> void randomFastSortX(T num[], int begin, int end) {
		if (begin < end) {
			//在开始符和结束符中间随机产生一个下标
			Random r = new Random();
			int n = r.nextInt(end - begin + 1) + begin;
			int mid;
			
			//将随机抽取的数和最后一个置换 ，作为比对标准
			T temp = num[end];
			num[end] = num[n];
			num[n] = temp;
			
			//用来标记遍历后的最后一个比标准小的数的位置
			int i = begin - 1;
			//遍历下标变量
			int j = begin;
			//比对标准的值
			T x = num[end];
			while (j < end) {
				//如果比标准小，则和i++位置的数置换，
				//这样达到小数和大树分组放
				if (num[j].compareTo(x)<0) {
					i++;
					temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
				//继续遍历
				j++;
			}
			//整个遍历完后，比对标准和i位置后的数置换
			//此时序列被分为两组，前面是小数，后面是大数
			temp = num[end];
			num[end] = num[i + 1];
			num[i + 1] = temp;
			mid = i + 1;
			
			//递归前后两组
			randomFastSortX(num, begin, mid - 1);
			randomFastSortX(num, mid + 1, end);
		}
	}
}
