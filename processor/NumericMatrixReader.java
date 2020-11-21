package processor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumericMatrixReader {

    public static NumericMatrix readNumericMatrix(Scanner scanner) throws Exception {
        int rows;
        int columns;

        try {
            rows = scanner.nextInt();
            columns = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException ignored) {
            throw new Exception("ERROR!");
        }

        var matrixA = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            var row = scanner.nextLine().split(" ");
            try {
                for (int j = 0; j < columns; j++) {
                    matrixA[i][j] = Integer.parseInt(row[j]);
                }
            }catch (Exception ignored) {
                throw new Exception("ERROR!");
            }
        }

        return new NumericMatrix(matrixA, rows, columns);
    }
}
