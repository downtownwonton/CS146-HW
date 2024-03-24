package homeWork9;

import java.util.Random;

public class BinaryTree {

	BinaryTree tree;
	TreeNode root;
	
	private TreeNode addRecursive(TreeNode current, int val)
	{
		if (current == null)
		{
			return new TreeNode(val);
		}
		if (val < current.val)
		{
			current.left = addRecursive(current.left, val);
		}
		else if (val > current.val)
		{
			current.right = addRecursive(current.right, val);
		}
		else
		{
			return current;
		}
		
		return current;
	}
	
	public BinaryTree()
	{
		
	}
	
	public BinaryTree(int val)
	{
		root = new TreeNode(val);
	}
	
	public void add(int val)
	{
		root = addRecursive(root, val);
	}
}
