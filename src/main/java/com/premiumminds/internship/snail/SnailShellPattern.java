package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<int[]> result = executor.submit(new SnailShellPatternTask(matrix));
    return result;
  };


}
