/**有N个骰子，同时投掷出去，向上的数字之和为A，那么输入为N个骰子，请计算出A和它出现的概率，保留5位小数
Input: 1
Output: [[1, 0.16667], [2, 0.16667], [3, 0.16667], [4, 0.16667], [5, 0.16667], [6, 0.16667]]
**/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextInt()) {
			int n = scan.nextInt();
			int min = n;
			int max = n * 6;
			int[][] matrix = new int[n][n * 6];
			double total = 6;
			//initial
			for(int i = 0; i < n * 6; i ++) {
				matrix[0][i] = 1;
			}
			
			for (int i = 1; i < n; i ++) {
				for (int j = i; j < n * 6; j ++) {
					matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j - 1];
					total += matrix[i][j];
				}
			}

			String[][] res = new String[n * 6 - n + 1][2];
			for (int i = 0; i <= n * 6 - n; i++) {
				res[i][0] = n + i + "";
				double sa = matrix[n - 1][n + i - 1] / total;
				res[i][1] = String.format("%.5f", sa);
			}

			System.out.println(Arrays.deepToString(res));
		}

	}
}

/** DP 问题， , i 表示骰子数， j 表示总和，matrix[i][j] 表示i 个骰子加起来总和为j的组合数量；
	可推导出  
	matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j - 1];
**/