package competitions;

import java.util.Arrays;

/**
 * @author: ryjarvis Nov 25, 2017
 * 
 */

public class Question601 {

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || newColor == image[sr][sc]) {
			return image;
		}
		return floodFillHelper(image, sr, sc, newColor, image[sr][sc]);
	}

	public static int[][] floodFillHelper(int[][] image, int sr, int sc, int newCol, int old) {
		if (sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || old != image[sr][sc]) {
			return image;
		}
		image[sr][sc] = newCol;
		floodFillHelper(image, sr + 1, sc, newCol, old);
		floodFillHelper(image, sr - 1, sc, newCol, old);
		floodFillHelper(image, sr, sc - 1, newCol, old);
		floodFillHelper(image, sr, sc + 1, newCol, old);
		return image;
	}

	// String[] w = str.split("\\s+");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		floodFill(image, sr, sc, newColor);

	}

}
