package homeWork11;
import java.util.*;

public class TwoDArray {

	public int[][] arr;
	
	public TwoDArray(int row, int column)
	{
		arr = new int[row][column];
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color)
	{
		
		if (image[sr][sc] == color)
		{
			return image;
		}
		else
		{
			int originalColor = image[sr][sc];
			image[sr][sc] = color;
			
			//checks top
			if ((sr - 1 >= 0) && (image[sr - 1][sc] == originalColor))
			{
				floodFill(image, sr - 1, sc, color);
			}
			//checks up
			if ((sr + 1 < image.length) && image[sr + 1][sc] == originalColor)
			{
				floodFill(image, sr + 1, sc, color);
			}
			//checks left
			if ((sc - 1 >= 0) && image[sr][sc - 1] == originalColor)
			{
				floodFill(image, sr, sc - 1, color);
			}
			//checks right
			if ((sc + 1 < image[0].length) && image[sr][sc + 1] == originalColor)
			{
				floodFill(image, sr, sc + 1, color);
			}
			
			
			return image;
		}
	}
	
	public static String arrayToString(int[][] arr)
	{
		String str = "";
		
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				str += arr[i][j] + " ";
			}
			if (i < arr.length - 1) str += "\n";
		}
		
		return str;
	}
	
	public static void main(String[] args)
	{
		int[][] twoDArray = new int [3][3];
		twoDArray[0][0] = 1;
		twoDArray[0][1] = 1;
		twoDArray[0][2] = 1;
		twoDArray[1][0] = 0;
		twoDArray[1][1] = 1;
		twoDArray[1][2] = 0;
		twoDArray[2][0] = 0;
		twoDArray[2][1] = 0;
		twoDArray[2][2] = 1;
		
		Random rand = new Random();
		
		int[][] twoDArrayRand = new int[rand.nextInt(10)][rand.nextInt(10)];
		
		for (int i = 0; i < twoDArrayRand.length; i++)
		{
			for (int j = 0; j < twoDArrayRand[0].length; j++)
			{
				twoDArrayRand[i][j] = rand.nextInt(2);
			}
		}
		
		System.out.println(arrayToString(twoDArray));
		System.out.println();
		
		floodFill(twoDArray, 1, 1, 2);
		System.out.println(arrayToString(twoDArray));
		System.out.println();
		
		System.out.println(arrayToString(twoDArrayRand));
		System.out.println();
		
		floodFill(twoDArrayRand, 0, 0, 2);
		System.out.println(arrayToString(twoDArrayRand));
	}
}
