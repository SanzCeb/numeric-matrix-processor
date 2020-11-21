package processor;

import java.util.Scanner;

public class NumericMatrixProcessor {

    public static void run() {
        var scanner = new Scanner(System.in);

        try {

            NumericMatrix matrixA = NumericMatrixReader.readNumericMatrix(scanner);
            var scalar = scanner.nextInt();
            System.out.print(matrixA.mulByScalar(scalar));

        }catch (Exception exception) {
            System.out.println("ERROR");
        }

    }
}
