package processor;

import java.util.Scanner;

public class NumericMatrixProcessor {

    public static void run() {
        var scanner = new Scanner(System.in);

        try {

            NumericMatrix matrixA = NumericMatrixReader.readNumericMatrix(scanner);
            NumericMatrix matrixB = NumericMatrixReader.readNumericMatrix(scanner);
            System.out.print(matrixA.add(matrixB));

        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
