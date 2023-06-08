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

        int index = 0;
        for (int i = 0; i < d; i++) {

            // Top
            for (int j = i; j < _n - i; j++) {
                solution[index++] = _matrix[i][j];
            }

            // Right
            for (int j = i + 1; j < _n - i; j++) {
                solution[index++] = _matrix[j][_n - i - 1];
            }

            // Bottom
            for (int j = i + 1; j < _n - i; j++) {
                solution[index++] = _matrix[_n - i - 1][_n - j - 1];
            }

            // Left
            for (int j = i + 1; j < _n - i - 1; j++) {
                solution[index++] = _matrix[_n - j - 1][i];
            }
        }
        return solution;
    }

    @Override
    public int[] call() {
        return fillLinesFromMatrix();
    }
}