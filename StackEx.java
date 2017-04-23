import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import trees.TreeUtil;

public class StackEx {
	public String findkthMaxElement(TreeUtil.Node root, int k) {
		int loc = 0;
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;

		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if (aux.left == null && aux.right == null) {
				if (!"NULL".equals(aux.data)) {
					loc++;
					if (loc == k) {
						return aux.data;
					}
				}
				if (!callSt.isEmpty()) {
					aux = (TreeUtil.Node) callSt.pop();
					if (!"NULL".equals(aux.data)) {
						loc++;
						if (loc == k) {
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
			/**
			 * reading LEFT /RIGHT
			 */
			aux = (TreeUtil.Node) callSt.pop();
			if (aux.right == null && aux.left == null) {
				if (!"NULL".equals(aux.data)) {
					System.out.print(aux.data);
				}
				/**
				 * TOS may be right child of the root of the previous popped
				 * one,if that is true then remove(process) root too otherwise
				 * the current popped one is the left child of another root why
				 * this while loop,if the tree is right skew tree then it is
				 * needed
				 * 
				 * IF reading RIGHT then TOS is root,if the root.right and
				 * popped element are same ONLY then root will print This
				 * condition is not for the left node
				 */
				while (!callSt.isEmpty() && (((TreeUtil.Node) callSt.peek()).right != null)
						&& ((TreeUtil.Node) callSt.peek()).right.data.equals(aux.data)) {
					aux = (TreeUtil.Node) callSt.pop();
					if (!"NULL".equals(aux.data)) {
						System.out.print(aux.data);
					}
				}
				
				while (!callSt.isEmpty() && (((TreeUtil.Node) callSt.peek()).right== null)	) {
					aux = (TreeUtil.Node) callSt.pop();
					if (!"NULL".equals(aux.data)) {
						System.out.print(aux.data);
					}
				}
				
				while (!callSt.isEmpty() && (((TreeUtil.Node) callSt.peek()).right != null)
						&& ((TreeUtil.Node) callSt.peek()).right.data.equals(aux.data)) {
					aux = (TreeUtil.Node) callSt.pop();
					if (!"NULL".equals(aux.data)) {
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

	class DSFframe {
		TreeUtil.Node node;
		ArrayList<String> visited = new ArrayList<String>();
	}

	public String getCommonAnsister(TreeUtil.Node root, String n1, String n2) {
		String result = "";
		Stack<DSFframe> callStack = new Stack<DSFframe>();
		DSFframe aux = null, aux2 = null;
		DSFframe rootf = new DSFframe();
		rootf.node = root;

		callStack.push(rootf);
		int cnt = 0;
		String currentRoot = "";
		while (!callStack.isEmpty()) {
			aux = callStack.peek();

			if (aux.node.left == null && aux.node.right == null) {
				aux = callStack.pop();
				if (aux.node.data.equalsIgnoreCase(n1) || aux.node.data.equalsIgnoreCase(n2)) {
					if (cnt == 0) {
						currentRoot = callStack.peek().node.data;
						cnt++;
					} else {
						return currentRoot;
					}
				}
				continue;
			}
			if (aux.node.left != null && !aux.visited.contains(aux.node.left.data)) {
				aux.visited.add(aux.node.left.data);
				aux2 = new DSFframe();
				aux2.node = aux.node.left;
				callStack.push(aux2);
				continue;
			}
			if (aux.node.right != null && !aux.visited.contains(aux.node.right.data)) {
				aux.visited.add(aux.node.right.data);
				aux2 = new DSFframe();
				aux2.node = aux.node.right;
				callStack.push(aux2);
				continue;
			}
			// both visited
			if (((aux.node.left != null && aux.visited.contains(aux.node.left.data))
					&& (aux.node.right != null && aux.visited.contains(aux.node.right.data)))
					|| (aux.node.left == null || aux.node.right == null)) {

				aux = callStack.pop();
				if (currentRoot.equals(aux.node.data)) {
					currentRoot = callStack.peek().node.data;
				}
				if (aux.node.data.equalsIgnoreCase(n1) || aux.node.data.equalsIgnoreCase(n2)) {
					if (cnt == 0) {
						currentRoot = callStack.peek().node.data;
						cnt++;
					} else {
						return currentRoot;
					}
				}

			}

		}

		return result;
	}

	public void printinPreOrder(TreeUtil.Node root) {
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;

		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if (!"NULL".equals(aux.data)) {
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

	public void printinInrder(TreeUtil.Node root) {
		Stack callSt = new Stack();
		callSt.push(root);
		TreeUtil.Node aux = null;

		while (!callSt.isEmpty()) {
			aux = (TreeUtil.Node) callSt.pop();
			if (aux.left == null && aux.right == null) {
				if (!"NULL".equals(aux.data)) {
					System.out.print(aux.data);
					if(!callSt.isEmpty()){
						aux = (TreeUtil.Node) callSt.pop();
						if(!"NULL".equals(aux.data)){
							System.out.print(aux.data);
						}
					}
				}
				while (!callSt.isEmpty()&&((TreeUtil.Node) callSt.peek()).right==null) {
					aux = (TreeUtil.Node) callSt.pop();
					if (!"NULL".equals(aux.data)) {
						System.out.print(aux.data);
						if(!callSt.isEmpty()){
							aux = (TreeUtil.Node) callSt.pop();
							if(!"NULL".equals(aux.data)){
								System.out.print(aux.data);
							}
						}
					}
				}
				continue;
			}
			if (aux.left == null) {
				if (!"NULL".equals(aux.data)) {
					System.out.print(aux.data);
				}
				if (aux.right != null) {
					callSt.push(aux.right);
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

	public static void testCase1() {

		// TODO Auto-generated method stub
		TreeUtil tu = new TreeUtil();
		StackEx se = new StackEx();
		System.out.print("The post order:");
		se.printinPostorder(tu.root);

		System.out.print("\nThe pre order:");
		se.printinPreOrder(tu.root);

		System.out.print("\nThe In order:");
		se.printinInrder(tu.root);

//		System.out.println("\nThe kth Max values ..." + se.findkthMaxElement(tu.root, 3));

	}

	public static void testCase2() {
		TreeUtil tu = new TreeUtil();
		StackEx se = new StackEx();
		Scanner sc = new Scanner(System.in);
		String n1 = "", n2 = "";
		System.out.println("Enter node 1");
		n1 = sc.nextLine();
		System.out.println("Enter node 2");
		n2 = sc.nextLine();

		System.out.println("The Nearsert common root of " + se.getCommonAnsister(tu.root, n1, n2));
	}

	public static void main(String[] args) {
		testCase1();
		System.out.println("\nDone..");
	}

}
