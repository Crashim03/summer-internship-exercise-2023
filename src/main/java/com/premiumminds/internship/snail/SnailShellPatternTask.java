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
        if (_n == 0) return new int[0];
        if (_n == 1) return _matrix[0];
        
        int[] solution = new int[_n * _n];
        int d = 0;

        if (_n % 2 == 0)  d = _n / 2;
        else d = _n / 2 + 1; 
        System.out.println("d: " + d);

        for (int i = 0; i < d; i++) {
            for (int j = i; j < _n - i; j++) {
                System.out.print(_matrix[i][j] + " ");
            }
            System.out.println();
        }

        return solution;
    }
}