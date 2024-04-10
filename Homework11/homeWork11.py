'''
Created on Apr 9, 2024

@author: downtownwonton
'''

import random

def floodFill(image, sr, sc, colorVal: int):
    if image[sr][sc] is colorVal:
        return image
    else:
        originalColor = image[sr][sc]
        image[sr][sc] = colorVal
        
        if sr - 1 >= 0 and image[sr - 1][sc] == originalColor:
            floodFill(image, sr - 1, sc, colorVal)
            
        if sr + 1 < len(image) and image[sr + 1][sc] == originalColor:
            floodFill(image, sr + 1, sc, colorVal)
            
        if sc - 1 >= 0 and image[sr][sc - 1] == originalColor:
            floodFill(image, sr, sc - 1, colorVal)
            
        if sc + 1 < len(image[0]) and image[sr][sc + 1] == originalColor:
            floodFill(image, sr, sc + 1, colorVal)
            
        return image
    
def arrayToString(image):
    for row in image:
        for i in row:   
            print(i, end=" ")
        print(" ")
        
def main():
    twoDArray = [
        [1, 1, 1],
        [0, 1, 0],
        [0, 0, 1]
    ]
    
    twoDArrayRand = [[random.randint(0, 1) for _ in range(random.randint(0, 9))] for _ in range(random.randint(0, 9))]
    
    print(arrayToString(twoDArray))
    print(" ")
    
    floodFill(twoDArray, 1, 1, 2)
    print(arrayToString(twoDArray))
    print(" ")
    
    print(arrayToString(twoDArrayRand))
    print(" ")
    
    floodFill(twoDArrayRand, 0, 0, 2)
    print(arrayToString(twoDArrayRand))
    
if __name__ == "__main__":
    main()

    