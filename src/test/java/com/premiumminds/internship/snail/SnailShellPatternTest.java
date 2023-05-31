package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

  public void Test(int[][] matrix, int[] expected) 
    throws InterruptedException, ExecutionException, TimeoutException {
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    assertArrayEquals("Wrong result", result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
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
    int[][] matrix = { { } };
    int[] expected = { };
    Test(matrix, expected);
  }
  @Test
  public void TenByTenTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { } };
    int[] expected = { };
    Test(matrix, expected);
  }
}