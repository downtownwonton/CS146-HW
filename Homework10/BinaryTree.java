package homeWork10;

import java.util.*;

public class BinaryTree {

	BinaryTree tree;
	TreeNode root;
	List<Integer> intList;
	List<List<Integer>> list;
	
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

	
	public int getHeight(TreeNode root)
	{
		if (root == null) return 0;
		else
		{
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			
			if (leftHeight >= rightHeight) return (leftHeight + 1);
			else return (rightHeight + 1);
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> list = new ArrayList<>();
		levelOrderHelper(root, 0, list);
		
		return list;
	}
		
		public void levelOrderHelper(TreeNode root, int level, List<List<Integer>> list)
		{
			if (root == null) return;
			else
			{
				if (list.size() == level)
				{
					list.add(new ArrayList<>());
				}
				
				list.get(level).add(root.val);
				levelOrderHelper(root.left, level + 1, list);
				levelOrderHelper(root.right, level + 1, list);
			}
		}
	public void printCurrentLevel(TreeNode root, int level)
	{
		if (root == null) return;
		if (level == 1) System.out.print(root.val + " ");
		else
		{
			printCurrentLevel(root.left, level - 1);
			printCurrentLevel(root.right, level - 1);
		}
	}
	
	//This is not the homework code.
	public void levelOrderTraversal()
	{
		int h = getHeight(root);
		
		for (int i = 1; i <= h; i++)
		{
			printCurrentLevel(root, i);
		}
	}
}

