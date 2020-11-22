package processor;

import java.util.function.*;

public class NumericMatrix {
    private final double [][] matrix;
    private final int rows;
    private final int columns;

    public NumericMatrix(double[][] matrix, int rows, int columns) {
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
    }


    public NumericMatrix add(NumericMatrix matrixB) throws Exception {
        if (rows == matrixB.rows && columns == matrixB.columns) {
            return matrixOperation(Double::sum, (i, j) -> matrixB.matrix[i][j]);
        } else {
            throw new Exception("ERROR");
        }
    }

    public NumericMatrix mulByScalar(double scalar) {
        return matrixOperation((a, b) -> a * b, (a, b) -> scalar);
    }

    public NumericMatrix multiply(NumericMatrix matrixB) throws Exception {
        if (columns == matrixB.rows) {
            var result = new double[rows][matrixB.columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < matrixB.columns; j++) {
                    result[i][j] = dotProduct(matrix[i], matrixB, j);
                }
            }
            return new NumericMatrix(result, rows, matrixB.columns);
        }
        throw new Exception("The operation cannot be performed.");
    }

    @Override
    public String toString() {
        StringBuilder matrixStr = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            matrixStr.append(this.matrix[i][0]);
            for (int j = 1; j < columns; j++) {
                matrixStr.append(String.format(" %.2f", matrix[i][j]));
            }
            matrixStr.append('\n');
        }
        matrixStr.deleteCharAt(matrixStr.length() - 1);
        return matrixStr.toString();
    }

    private NumericMatrix matrixOperation (DoubleBinaryOperator operator,
                                           ToDoubleBiFunction<Integer, Integer> valueReader) {
        var result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = operator.applyAsDouble(matrix[i][j], valueReader.applyAsDouble(i, j));
            }
        }
        return new NumericMatrix(result, rows, columns);
    }

    private double dotProduct(double[] matrix, NumericMatrix matrixB, int j) {
        double result = 0;
        for (int i = 0; i < columns; i++) {
            result += matrix[i] * matrixB.matrix[i][j];
        }
        return result;
    }

    public NumericMatrix transposeVerticalLine() {
        var result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[j][columns - i - 1];
            }
        }
        return new NumericMatrix(result, rows, columns);
    }

    public NumericMatrix transposeSideDiagonal() {
        var result = new double[rows][columns];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                result[j][i] = matrix[rows - j - 1][columns - i - 1];
            }
        }
        return new NumericMatrix(result, rows, columns).transposeMainDiagonal();
    }

    public NumericMatrix transposeHorizontalLine() {
        var result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (columns >= 0)
                System.arraycopy(matrix[rows - i - 1], 0, result[i], 0, columns);
        }
        return new NumericMatrix(result, rows, columns);
    }

    public NumericMatrix transposeMainDiagonal() {
        var result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return new NumericMatrix(result, rows, columns);
    }
}
