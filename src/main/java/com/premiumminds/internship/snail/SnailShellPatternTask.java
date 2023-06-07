package com.premiumminds.internship.snail;

import java.util.concurrent.Callable;

public class SnailShellPatternTask implements Callable<int[]> {

    int[][] _matrix;
    int _n;

    public SnailShellPatternTask(int[][] matrix) {
        _matrix = matrix;
        _n = matrix.length;
    }

    private int[] fillLinesFromMatrix() {
        if (_n == 0)
            return new int[0];
        if (_n == 1)
            return _matrix[0];

        int[] solution = new int[_n * _n];
        int d = 0;

        if (_n % 2 == 0)
            d = _n / 2;
        else
            d = _n / 2 + 1;
        for (int i = 0; i < d; i++) {
            for (int j = i; j < _n - i; j++) {
                solution[i * 3 * (_n - i) + i + j] = _matrix[i][j];
            }
        }

        return solution;
    }

    @Override
    public int[] call() {
        return fillLinesFromMatrix();
    }
}