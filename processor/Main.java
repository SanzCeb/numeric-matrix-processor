package processor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int rows;
        int columns;

        try {
            rows = scanner.nextInt();
            columns = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException ignored) {
            System.err.println("ERROR!");
            return;
        }
        var matrixA = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            var row = scanner.nextLine().split(" ");
            try {
                for (int j = 0; j < columns; j++) {
                    matrixA[i][j] = Integer.parseInt(row[j]);
                }
            }catch (Exception ignored) {
                System.out.println("ERROR!");
                return;
            }
        }

        Matrix matrixAObj = new Matrix(matrixA, rows, columns);


        try {
            rows = scanner.nextInt();
            columns = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException ignored) {
            System.out.println("ERROR");
            return;
        }
        matrixA = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            var row = scanner.nextLine().split(" ");
            try {
                for (int j = 0; j < columns; j++) {
                    matrixA[i][j] = Integer.parseInt(row[j]);
                }
            }catch (Exception ignored) {
                System.out.println("ERROR");
                return;
            }
        }

        Matrix matrixBObj = new Matrix(matrixA, rows, columns);

        try {
            Matrix result = matrixAObj.add(matrixBObj);
            System.out.print(result);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
