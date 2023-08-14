package chapter1.section1;

import java.util.Arrays;

public class Q33 {
    public static void main(String[] args) {
        // vectors
        double[] vector1 = {2, 3, -1};
        double[] vector2 = {4, -2, 5};
        // matrices
        double[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        Matrix.transpose(matrix1);
    }

    static class Matrix {

        // vector dot product
        static double dot(double[] x, double[] y) {
            double sum = 0;
            for (int i = 0; i < x.length; i++) {
                sum += x[i] * y[i];
            }
            return sum;
        }

        // matrix-matrix product
        static double[][] mult(double[][] a, double[][] b) {
            final int completeMatrixLength = Math.min(a.length, a[0].length);
            double[][] completeMatrix = new double[completeMatrixLength][completeMatrixLength];
            // iterate for each row of first matrix
            for (int k = 0; k < a.length; k++) {
                int cmj = 0; // helper index J to write into new matrix
                int countProductTimes = 0; // helper counter to know when to stop write in new row in completeMatrix
                // iterate for each element in matrix2 vertically '|'
                for (int i = 0; i < a.length; i++) {
                    double intervalProduct = 0;
                    // iterate for each element in each matrix horizontally '-'
                    for (int j = 0; j < a[0].length; j++) {
                        intervalProduct += a[k][j] * b[j][i]; // count each values for new matrix
                        countProductTimes++;
                    }
                    // write into new matrix
                    if (countProductTimes == completeMatrixLength) { // if length is max then switch to new row
                        countProductTimes = 0;
                    } else { // else write into new matrix
                        completeMatrix[k][cmj] = intervalProduct;
                        cmj++;
                    }
                }
            }

            return completeMatrix;
        }

        // transpose
        static double[][] transpose(double[][] a) {
            double[][] transposedMatrix = new double[a[0].length][a.length];
            for (int i = 0; i < a[0].length; i++) {
                for (int j = 0; j < a.length; j++) {
                    transposedMatrix[i][j] = a[j][i];
                }
            }
            System.out.println("transposedMatrix = " + Arrays.deepToString(transposedMatrix));
            return transposedMatrix;
        }

        // matrix-vector product
        static double[] mult(double[][] a, double[] x) {
            if(a[0].length != x.length) throw new ArithmeticException("Such matrices cannot be multiplied because " +
                    "the number of columns of matrix A is not equal to the number of rows of matrix B.");
            double[] result = new double[x.length - 1];
            int k = 0;
            for (int i = 0; i < a.length; i++) {
                double product = 0;
                for (int j = 0; j < a[0].length; j++) {
                    product += a[i][j] * x[j];
                }
                result[k] = product;
                k++;
            }
            System.out.println("result = " + Arrays.toString(result));
            return result;
        }

        /* vector-matrix product*/
        static double[] mult(double[] y, double[][] a) {
            if(y.length != a.length) throw new ArithmeticException(
                    "Such matrices cannot be multiplied because the number of columns" +
                            " of matrix A is not equal to the number of rows of matrix B. ");

            double[] result = new double[a[0].length];
            int resIterator = 0;

            for (int i = 0; i < a[0].length; i++) {
                double intervalProduct = 0;
                for(int j = 0; j <a.length ; j++) {
                    intervalProduct += y[j] * a[j][i];
                }
                result[resIterator] = intervalProduct;
                resIterator++;
            }
            return result;
        }

    }
}

