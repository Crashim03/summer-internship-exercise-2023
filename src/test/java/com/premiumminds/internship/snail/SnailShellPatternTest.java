package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  private void PrintMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++)
        System.out.print(matrix[i][j] + " ");
      System.out.println();
    }
  }

  public void Test(int[][] matrix, int[] expected)
      throws InterruptedException, ExecutionException, TimeoutException {
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);

    try {
      assertArrayEquals(result, expected);
    } catch (AssertionError e) {
      System.out.println("Wrong result.");
      System.out.println("Expected: " + Arrays.toString(expected));
      System.out.println("Got: " + Arrays.toString(result));
      System.out.println("Matrix:");
      PrintMatrix(matrix);
      System.out.println();
      throw e;
    }
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Test(matrix, expected);
  }

  @Test
  public void OneByOneTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 } };
    int[] expected = { 1 };
    Test(matrix, expected);
  }

  @Test
  public void TwoByTwoTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 3, 4 } };
    int[] expected = { 1, 2, 4, 3 };
    Test(matrix, expected);
  }

  @Test
  public void EmptyTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { {} };
    int[] expected = {};
    Test(matrix, expected);
  }

  @Test
  public void TenByTenTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = new int[10][10];
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        20, 30, 40, 50, 60, 70, 90, 100,
        99, 98, 97, 96, 95, 94, 93, 92, 91,
        81, 71, 61, 51, 41, 31, 21, 11,
        12, 13, 14, 15, 16, 17, 18, 19,
        29, 39, 49, 59, 69, 79, 89,
        88, 87, 86, 85, 84, 83, 82,
        72, 62, 52, 42, 32, 22,
        23, 24, 25, 26, 27, 28,
        38, 48, 58, 68, 78,
        77, 76, 75, 74, 73,
        63, 53, 43, 33,
        34, 35, 36, 37,
        47, 57, 67,
        66, 65, 64,
        54, 44,
        45, 46,
        56, 55 };

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++)
        matrix[i][j] = i * 10 + j + 1;
    }
    Test(matrix, expected);
  }
}