package TreetoLinkList;

class TreeNode{
	int value;
	TreeNode leftNode;
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value = value;
	}
}

public class TreeToLinkList {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(10);
		t.leftNode = new TreeNode(6);
		t.leftNode.leftNode = new TreeNode(4);
		t.leftNode.rightNode = new TreeNode(8);
		t.rightNode = new TreeNode(14);
		t.rightNode.leftNode = new TreeNode(12);
		t.rightNode.rightNode = new TreeNode(16);
		
		
		TreeNode resultNode = convert(t);
		while (resultNode.rightNode!=null) {
			System.out.println(resultNode.value);
			resultNode=resultNode.rightNode;
		}
	}
	
	static TreeNode convert(TreeNode tn){
		TreeNode t = null;
		convertNode(tn, t);
		
//		TreeNode resultNode = t;
//		while (resultNode!=null & resultNode.leftNode!=null) {
//			resultNode = resultNode.leftNode;
//		}
		return tn;
	}
	
	static void convertNode(TreeNode tn, TreeNode last){
		
		if (tn ==null) {
			return;
		}
		
		TreeNode tcurr = tn;
		
		if (tn.leftNode!=null) {
			convertNode(tn.leftNode, last);
		}
		
		tcurr.leftNode = last;
		if (last!=null) {
			last.rightNode=tcurr;
		}
		last=tcurr;
		
		if (tn.rightNode!=null) {
			convertNode(tn.rightNode, last);
		}
	}
}
