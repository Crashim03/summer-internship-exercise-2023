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

        for (int i = 0; i < _n; i++) 
            for (int j = 0; j < _n; j++) {

            
        }

        return solution;
    }
}