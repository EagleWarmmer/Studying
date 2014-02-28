package ContainerWithMostWater;

public class ContainerWithMostWater {
	//给一个int数组代表坐标的高度，数组号为横坐标
	//计算由两个点对x轴的两条竖线组成水缸盛水面积最大是多少
	//取决于最短的那根竖线高度
	
	/**
	 * 此方法简单 n^2的复杂度
	 */
	public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int area,max=0;
		
        for(int i=0;i<height.length;i++){
        	for(int j=i+1;j<height.length;j++){
        		if(height[i]<height[j]){
        			area=height[i]*(j-i);
        		}else {
        			area=height[j]*(j-i);
				}
        		if(area>max){
        			max=area;
        		}
        	}
        }
        return max;
    }
	
	/**
	 * 此方法是n的复杂度
	 * 取两端i,j
	 * 通过画图可知，如果hi<hj 则说明hi是短板。
	 * 移动哪端j-i都变小1
	 * 所以只有将短板变长才能扩大面积
	 */
	public int maxAreaFast(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=0,temp=0,i=0,j=height.length-1;
        while(i<j){
        	if(height[i]<height[j]){
            	temp=height[i]*(j-i);
            	i++;
            }else{
        		temp=height[j]*(j-i);
            	j--;
        	}
        	if(temp>max)max=temp;
        }
        
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater cw = new ContainerWithMostWater();
		int [] a = {1,2,1};
		System.out.println(cw.maxAreaFast(a));
	}

}
