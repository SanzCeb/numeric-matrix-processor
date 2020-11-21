package processor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumericMatrixReader {

    public static NumericMatrix readNumericMatrix(Scanner scanner, String order) throws Exception {
        int rows;
        int columns;

        System.out.printf("Enter the size of%s matrix: ", order);
        try {
            rows = scanner.nextInt();
            columns = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException ignored) {
            throw new Exception("ERROR!");
        }
        System.out.printf("Enter%s matrix:%n", order);
        var matrixA = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            var row = scanner.nextLine().split(" ");
            try {
                for (int j = 0; j < columns; j++) {
                    matrixA[i][j] = Double.parseDouble(row[j]);
                }
            }catch (Exception ignored) {
                throw new Exception("ERROR!");
            }
        }

        return new NumericMatrix(matrixA, rows, columns);
    }
}
