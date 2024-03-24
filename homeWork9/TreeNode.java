package homeWork9;
import java.util.Random;

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
	
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		
		//Base case: for p and q's values, the search will terminate when either the max of values for p and q are the root
		// or if the root value is bound between p and q.
		if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val))
			return root;
		else
		{
			//If p and q values < root value, check the left subtree.
			if (p.val < root.val && q.val < root.val)
			{
				return lowestCommonAncestor(root.left, p, q);
			}
			//If p and q values > root value, check right subtree.
			else
			{
				return lowestCommonAncestor(root.right, p, q);
			}

		}
	}
	
	BinaryTree tree;
	
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
		
		randomInt = rand.nextInt(70);
		
		TreeNode p = new TreeNode(randomInt);
		
		randomInt = rand.nextInt(70);

		
		TreeNode q = new TreeNode(randomInt);
		
		tree.add(p.val);
		tree.add(q.val);
		
		System.out.println("Starting root is " + tree.root.val + " and p is " + p.val + " and q is " + q.val);
		System.out.println(lowestCommonAncestor(tree.root, p, q).val);
	}
}

