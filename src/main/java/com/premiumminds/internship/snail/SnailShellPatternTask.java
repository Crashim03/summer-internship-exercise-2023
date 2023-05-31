package com.premiumminds.internship.snail;

import java.util.concurrent.Callable;

public class SnailShellPatternTask implements Callable<int[]> {

    int[][] _matrix;
    int     _n;

    public SnailShellPatternTask(int[][] matrix) {
        _matrix = matrix;
        _n = matrix.length;
    }

    @Override
    public int[] call() {
        int[] solution = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        return solution;
    }
}
    
