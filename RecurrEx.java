
public class RecurrEx {
	
	public String printInorder(TreeUtil.Node root){
		if (root == null) {
			return "";
		}
		return printInorder(root.left)+root.data+printInorder(root.right);
	}
	
	public String printPostorder(TreeUtil.Node root){
		if (root == null) {
			return "";
		}
		return printPostorder(root.left)+printInorder(root.right)+root.data;
	}
	
	public void getInorerSucc(TreeUtil.Node root, String eleR, StringBuilder status) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (status.toString().contains("Y")) {
				status.delete(0, status.capacity());
				status.append(root.data);
			}
			if (root.data.equals(eleR)) {
				status.append("Y");
			}
			return;
		}
		getInorerSucc(root.left, eleR, status);

		if (status.toString().contains("Y")) {
			status.delete(0, status.capacity());
			status.append(root.data);
			return;
		}
		if (root.data.equals(eleR)) {
			status.append("Y");
		}

		getInorerSucc(root.right, eleR, status);
	}

	public void getPreorerSucc(TreeUtil.Node root, String eleR, StringBuilder status) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (status.toString().contains("Y")) {
				status.delete(0, status.capacity());
				status.append(root.data);
			}
			if (root.data.equals(eleR) && status.toString().length() == 0) {
				status.append("Y");
			}
			return;
		}

		if (status.toString().contains("Y")) {
			status.delete(0, status.capacity());
			status.append(root.data);
			return;
		}
		if (root.data.equals(eleR) && status.toString().length() == 0) {
			status.append("Y");
		}
		if (root.left != null) {
			getPreorerSucc(root.left, eleR, status);
		}
		if (root.right != null) {
			getPreorerSucc(root.right, eleR, status);
		}
	}

	public void getPostorerSucc(TreeUtil.Node root, String eleR, StringBuilder status) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (status.toString().contains("Y")) {
				status.delete(0, status.capacity());
				status.append(root.data);
			}
			if (root.data.equals(eleR) && status.toString().length() == 0) {
				status.append("Y");
			}
			return;
		}
		if (root.left != null) {
			getPostorerSucc(root.left, eleR, status);
		}
		if (root.right != null) {
			getPostorerSucc(root.right, eleR, status);
		}

		if (status.toString().contains("Y")) {
			status.delete(0, status.capacity());
			status.append(root.data);
			return;
		}
		if (root.data.equals(eleR) && status.toString().length() == 0) {
			status.append("Y");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUtil tu = new TreeUtil();
		RecurrEx re = new RecurrEx();
		StringBuilder sb = new StringBuilder();
		re.getPostorerSucc(tu.root, "D", sb);
		System.out.println("Postorder Succssor of D:=" + sb.toString());
		
		System.out.println("PostOrder::"+re.printPostorder(tu.root));
	}

}
