package processor;

import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

public class NumericMatrix {
    private final int [][] matrix;
    private final int rows;
    private final int columns;

    public NumericMatrix(int[][] matrix, int rows, int columns) {
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
    }


    public NumericMatrix add(NumericMatrix matrixB) throws Exception {
        if (rows == matrixB.rows && columns == matrixB.columns) {
            return matrixOperation(Integer::sum, (i, j) -> matrixB.matrix[i][j]);
        } else {
            throw new Exception("ERROR");
        }
    }

    public NumericMatrix mulByScalar(int scalar) {
        return matrixOperation(Math::multiplyExact, (a, b) -> scalar);
    }

    @Override
    public String toString() {
        StringBuilder matrixStr = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            matrixStr.append(this.matrix[i][0]);
            for (int j = 1; j < columns; j++) {
                matrixStr.append(String.format(" %d", matrix[i][j]));
            }
            matrixStr.append('\n');
        }
        matrixStr.deleteCharAt(matrixStr.length() - 1);
        return matrixStr.toString();
    }

    private NumericMatrix matrixOperation (IntBinaryOperator operator, ToIntBiFunction<Integer, Integer> valueReader) {
        var result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = operator.applyAsInt(matrix[i][j], valueReader.applyAsInt(i, j));
            }
        }
        return new NumericMatrix(result, rows, columns);
    }
}
