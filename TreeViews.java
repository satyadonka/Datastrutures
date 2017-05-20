import java.io.IOException;
import java.util.Stack;

public class TreeViews {
	Node root = null;

	public TreeViews() {
		try {
			TreeBuilder t = new TreeBuilder();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		root = TreeBuilder.getRoot();
	}

	public static void printLeftView(Node r) {
		LevelNode aux = null, prevRoot = null,lchild=null,rchild=null;
		Stack<LevelNode> callStack = new Stack<LevelNode>();
		LevelNode root=new LevelNode();
		root.cnode=r;
		root.level=0;
		callStack.push(root);
		System.out.print(root.cnode.data);
		prevRoot = root;
		int level = 1, prevLevel = -1;
		while (!callStack.isEmpty()) {
			aux = callStack.pop();
			level=aux.level;
			/**
			 * Pushing
			 */
			if (((prevRoot.cnode.left != null) && prevRoot.cnode.left.data.equals(aux.cnode.data))
					|| (((prevRoot.cnode.right != null) && prevRoot.cnode.right.data.equals(aux.cnode.data)))) {
				if(aux.level>prevLevel){
					prevLevel=aux.level;
					System.out.print(" "+aux.cnode.data);
				}
			 
			}
			level++;
			if (aux.cnode.right != null) {
				lchild=new LevelNode();
				lchild.cnode=aux.cnode.right;
				lchild.level=level;
				callStack.push(lchild);
			}
			if (aux.cnode.left != null) {
				rchild=new LevelNode();
				rchild.cnode=aux.cnode.left;
				rchild.level=level;
				callStack.push(rchild);
			}
		 
			
			prevRoot = aux;

		}
	}

	static class LevelNode {
		public Node getCnode() {
			return cnode;
		}

		public void setCnode(Node cnode) {
			this.cnode = cnode;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		Node cnode = null;
		int level = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeViews tv = new TreeViews();
		TreeViews.printLeftView(tv.root);
	}

}
