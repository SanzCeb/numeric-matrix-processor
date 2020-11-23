package processor.client;

import processor.NumericMatrix;
import processor.NumericMatrixReader;

import java.util.Scanner;


public class NumericMatrixProcessor {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void run() {
        try {
            runNumericMatrixProcessorMenu();
        }catch (Exception ignored) {
            System.out.println("ERROR");
        }
    }

    static void runNumericMatrixProcessorMenu() {
        int choice;
        do {
            printMenu();
            System.out.print("Your choice: ");
            choice = Integer.parseInt(SCANNER.nextLine());
            switch (choice) {
                case 0:
                    break;
                case 1:
                    runBiMatrixOperator("add");
                    break;
                case 2:
                    runMulMatricesByAConst();
                    break;
                case 3:
                    runBiMatrixOperator("multiply");
                    break;
                case 4:
                    runTranspose();
                    break;
                case 5:
                    runUnaryMatrixOperator("getDeterminant");
                    break;
                default:
                    choice = -1;
                    break;
            }
        } while(choice != 0);
    }

    private static void runTranspose() {
        int choice;
        do {
            printTransposeMenu();
            System.out.print("Your choice: ");
            choice = Integer.parseInt(SCANNER.nextLine());
            switch (choice) {
                case 0:
                    break;
                case 1:
                    runUnaryMatrixOperator("transposeMainDiagonal");
                    break;
                case 2:
                    runUnaryMatrixOperator("transposeSideDiagonal");
                    break;
                case 3:
                    runUnaryMatrixOperator("transposeVerticalLine");
                    break;
                case 4:
                    runUnaryMatrixOperator("transposeHorizontalLine");
                    break;
                default:
                    choice = -1;
                    break;
            }

        } while(choice == -1);
    }

    private static void runUnaryMatrixOperator(String matrixOperator) {
        try {
            NumericMatrix matrixA = NumericMatrixReader.readNumericMatrix(SCANNER, "");
            System.out.println("The result is:");
            var numericMatrixClass = NumericMatrix.class;
            var matrixOperatorMethod = numericMatrixClass.getMethod(matrixOperator);
            System.out.println(matrixOperatorMethod.invoke(matrixA));

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void runBiMatrixOperator(String matrixOperator) {
        try {

            NumericMatrix matrixA = NumericMatrixReader.readNumericMatrix(SCANNER, " first");
            NumericMatrix matrixB = NumericMatrixReader.readNumericMatrix(SCANNER, " second");
            System.out.println("The result is:");
            var numericMatrixClass = NumericMatrix.class;
            var matrixOperatorMethod = numericMatrixClass.getMethod(matrixOperator, numericMatrixClass);
            System.out.println(matrixOperatorMethod.invoke(matrixA, matrixB));

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void runMulMatricesByAConst() {
        try {
            NumericMatrix matrixA = NumericMatrixReader.readNumericMatrix(SCANNER, "");
            var scalar = SCANNER.nextDouble();
            System.out.println("The result is:");
            System.out.print(matrixA.mulByScalar(scalar));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    private static void printTransposeMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
    }

    private static void printMenu() {
        System.out.println("\n1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrices");
        System.out.println("5. Calculate a determinant");
        System.out.println("0. Exit");
    }
}
