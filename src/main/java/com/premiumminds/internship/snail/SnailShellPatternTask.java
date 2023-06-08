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
        if (_n == 0) return new int[0];
        if (_n == 1) return _matrix[0];

        int[] solution = new int[_n * _n];
        int d = 0;

        if (_n % 2 == 0) d = _n / 2;
        else d = _n / 2 + 1;

        int last_index = 0;
        for (int i = 0; i < d; i++) {
            int count_up = 0;
            int count_right_bottom = 0;
            int count_left = 0;

            for (int j = i; j < _n - i; j++) {
                // Top
                solution[last_index + count_up++] = _matrix[i][j];

                // Right and Bottom
                if (j != i){
                    solution[last_index + _n - 2 * i + count_right_bottom] = _matrix[j][_n - i - 1];
                    solution[last_index + (_n - 2 * i) * 2 - 1 + count_right_bottom] = _matrix[_n - i - 1][_n - j - 1];
                    count_right_bottom++;
                }

                // Left
                if (j != i && j != _n - i - 1){
                    solution[last_index + (_n - 2 * i) * 3 - 2 + count_left++] = _matrix[_n - j - 1][i];
                }
            }
            last_index += count_up + count_right_bottom * 2 + count_left;
        }
        return solution;
    }

    @Override
    public int[] call() {
        return fillLinesFromMatrix();
    }
}