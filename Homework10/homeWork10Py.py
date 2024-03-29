'''
Created on Mar 28, 2024

@author: downtownwonton
'''

import random
from typing import List, Optional

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
                
    def levelOrder(self, root: Optional['TreeNode']) -> List[List[int]]:
        printLevels = []
        self.levelOrderHelper(root, 0, printLevels)
        return printLevels
                
    def levelOrderHelper(self, root: Optional['TreeNode'], level, printLevels):
        if root is None:
            return 
        else:
            intList = []
            if len(printLevels) == level:
                printLevels.append(intList)
                
            printLevels[level].append(root.val)
            self.levelOrderHelper(root.left, level + 1, printLevels)
            self.levelOrderHelper(root.right, level + 1, printLevels)
                
    def invertTree(self, root: 'TreeNode'):
        if root is None:
            return root
        else:
            temp = TreeNode(0, root.left, root.right)
            root.left = temp
            root.right = temp.left
            root.left = temp.right
            self.invertTree(root.right)
            self.invertTree(root.left)
            
            return root
        
    def getHeight(self, root: 'TreeNode'):
        if root is None:
            return 0
        else:
            leftHeight = self.getHeight(root.left)
            rightHeight = self.getHeight(root.right)
            
            if leftHeight > rightHeight:
                return (leftHeight + 1)
            else:
                return (rightHeight + 1)
            
    def printCurrentLevel(self, root: 'TreeNode', level):
        if root is None:
            return 
        if level == 1:
            print(f"{root.val}", end =" ")
        else:
            self.printCurrentLevel(root.left, level - 1)
            self.printCurrentLevel(root.right, level - 1)
     
    '''
    this is not the homework assignment.
    '''       
    def levelOrderTraversal(self):
        height = self.getHeight(self.root)
        
        for i in range(1, height):
            self.printCurrentLevel(self.root, i)
        


def main():
        
    tree = BinarySearchTree()
    
    tree.root = TreeNode(random.randint(1,50))
    
    
    for i in range(1, 10):
        x = random.randint(1, 50)
        print(f"{i} node value: {x}")
        tree.add(x)
        
    
    
    print(f"Root is {tree.root.val}")
    
    tree.levelOrderTraversal()
    print(" ")
    
    print(tree.levelOrder(tree.root))
    
    
    
if __name__ == "__main__":
    main()
            