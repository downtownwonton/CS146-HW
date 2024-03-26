'''
Created on Mar 24, 2024

@author: downtownwonton
'''
import random

class TreeNode:
    
    def __init__(self, val, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

        
class BinarySearchTree:
    
    def __init__(self):
        self.root = None 
        
    def add(self, val):
        if self.root is None:
            self.root = TreeNode(val)
            
        else:
            self.addRecursive(self.root, val)
            
    def addRecursive(self, current: 'TreeNode', val):
        if val < current.val:
            if current.left is None:
                current.left = TreeNode(val)
            else:
                self.addRecursive(current.left, val)
                
        elif val > current.val:
            if current.right is None:
                current.right = TreeNode(val)
            else:
                self.addRecursive(current.right, val)
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root.val >= p.val and root.val <= q.val) or (root.val <= p.val and root.val >= q.val):
            return root
        else:
            if (p.val < root.val and q.val < root.val):
                return self.lowestCommonAncestor(root.left, p, q)
            elif (p.val > root.val and q.val > root.val):
                return self.lowestCommonAncestor(root.right, p, q)

def main():
        
    tree = BinarySearchTree()
    
    tree.root = TreeNode(random.randint(1,50))
    p = TreeNode(random.randint(1, 50))
    q = TreeNode(random.randint(1, 50))
    
    
    for i in range(1, 10):
        x = random.randint(1, 50)
        print(f"{i} node value: {x}")
        tree.add(x)
        
    tree.add(p.val)
    tree.add(q.val)
    
    
    print(f"Root is {tree.root.val} and q is {q.val} and p is {p.val}")
    
    print(tree.lowestCommonAncestor(tree.root, p, q).val)
    
if __name__ == "__main__":
    main()
            