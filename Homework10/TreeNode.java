package homeWork10;
import java.util.*;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode()
	{
		
	}
	
	public TreeNode(int val)
	{
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static void main(String[] args)
	{
		
		BinaryTree tree = new BinaryTree();
		
		Random rand = new Random();
		
		int randomInt = rand.nextInt(70);
		
		tree.root = new TreeNode(randomInt);
		
		for (int i = 0; i <= 5; i++)
		{
			 randomInt = rand.nextInt(70);
			 System.out.println("Adding: " + randomInt);
			 tree.add(randomInt);
		}
		
		System.out.println("Root is " + tree.root.val);
		
		tree.levelOrderTraversal();
		
		System.out.println();
		
		System.out.println(tree.levelOrder(tree.root));
		
		System.out.println();
		System.out.print("Empty tree: ");
		
		BinaryTree empty = new BinaryTree();
		empty.root = null;
		
		System.out.println("Root is " + empty.root + " and tree is " + empty.levelOrder(empty.root));
		
		
	}
}

