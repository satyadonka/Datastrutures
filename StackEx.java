
import java.util.Stack;

public class StackEx {
	public String findkthMaxElement(TreeUtil.Node root, int k) {
		int loc=0;
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;

		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if (aux.left == null && aux.right == null) {
				if(!"NULL".equals(aux.data)){
					loc++;
					if(loc==k){
						return aux.data;
					}
				}
				if (!callSt.isEmpty()) {
					aux = (TreeUtil.Node) callSt.pop();
					if(!"NULL".equals(aux.data)){
						loc++;
						if(loc==k){
							return aux.data;
						}
					}
				}
				continue;
			}
			if (aux.right != null) {
				callSt.push(aux.right);
			}
			if (aux != null) {
				callSt.push(aux);
			}
			if (aux.left != null) {
				callSt.push(aux.left);
			}

		}

	return "";
	}

	public static void postorderSuccOf(TreeUtil.Node root, String ele) {
		// Navigate to left,Navigate to Right,Process
		Stack callSt = new Stack();
		callSt.push(root);

		while (!callSt.isEmpty()) {

		}

	}

	public void printinPostorder(TreeUtil.Node root) {
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;
		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if (aux.right == null && aux.left == null) {
				if(!"NULL".equals(aux.data)){
					System.out.print(aux.data);
				}
/**
 * TOS may be right child of the root of the previous popped one,if that is true then remove(process) root too
 * otherwise the current popped one is the left child of another root
 * why this while loop,if the tree is right skew tree then it is needed
 */
				while (!callSt.isEmpty() && (((TreeUtil.Node) callSt.peek()).right != null)
						&& ((TreeUtil.Node) callSt.peek()).right.data.equals(aux.data)) {
					aux = (TreeUtil.Node) callSt.pop();
					if(!"NULL".equals(aux.data)){
						System.out.print(aux.data);
					}
				}
				continue;
			}
			if (aux != null) {
				callSt.push(aux);
			}
			if (aux.right != null) {
				callSt.push(aux.right);
			}
			if (aux.left != null) {
				callSt.push(aux.left);
			}

		}
	}

	public void printinPreOrder(TreeUtil.Node root) {
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;

		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if(!"NULL".equals(aux.data)){
				System.out.print(aux.data);
			}
			if (aux.left == null && aux.right == null) {
				continue;
			}
			if (aux.right != null) {
				callSt.push(aux.right);
			}
			if (aux.left != null) {
				callSt.push(aux.left);
			}

		}

	}

	public void printinPInrder(TreeUtil.Node root) {
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;

		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if (aux.left == null && aux.right == null) {
				if(!"NULL".equals(aux.data)){
					System.out.print(aux.data);
				}
				if (!callSt.isEmpty()) {
					aux = (TreeUtil.Node) callSt.pop();
					if(!"NULL".equals(aux.data)){
						System.out.print(aux.data);
					}
				}
				continue;
			}
			if (aux.right != null) {
				callSt.push(aux.right);
			}
			if (aux != null) {
				callSt.push(aux);
			}
			if (aux.left != null) {
				callSt.push(aux.left);
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUtil tu = new TreeUtil();
		StackEx se = new StackEx();
		System.out.print("The post order:");
		se.printinPostorder(tu.root);

		System.out.print("\nThe pre order:");
		se.printinPreOrder(tu.root);

		System.out.print("\nThe In order:");
		se.printinPInrder(tu.root);

		System.out.println("\nThe kth Max values ..." + se.findkthMaxElement(tu.root, 3));
	}

}
