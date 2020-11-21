package processor;

public class NumericMatrix {
    private int [][] matrix;
    private final int rows;
    private final int columns;

    public NumericMatrix(int[][] matrix, int rows, int columns) {
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
    }


    public NumericMatrix add(NumericMatrix numericMatrixBObj) throws Exception {
        if (rows == numericMatrixBObj.rows && columns == numericMatrixBObj.columns) {
            var result = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = matrix[i][j] + numericMatrixBObj.matrix[i][j];
                }
            }
            return new NumericMatrix(result, rows, columns);
        } else {
            throw new Exception("ERROR");
        }
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
}
