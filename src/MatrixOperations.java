import java.util.Arrays;

/**
 * Клас для виконання побітових операцій з матрицями та обчислення середніх значень.
 * <p>
 * Використовується для роботи з двома матрицями типу byte[][].
 *
 * @author Кудіна Діана
 * @version 1.0
 * @since 13-10-2024
 */

public class MatrixOperations {

    public static byte[][] bitwiseXorAnd(byte[][] matrixA, byte[][] matrixB) throws IllegalArgumentException {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            throw new IllegalArgumentException("Матриці повинні бути однакового розміру");
        }

        byte[][] resultMatrix = new byte[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                resultMatrix[i][j] = (byte) (matrixA[i][j] ^ matrixB[i][j]);
            }
        }

        return resultMatrix;
    }

    public static double[] calculateRowAverages(byte[][] matrix) {
        double[] averages = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            averages[i] = (double) sum / matrix[0].length;
        }

        return averages;
    }

    public static void printMatrix(byte[][] matrix) {
        System.out.println("Матриця:");
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printAverages(double[] averages) {
        System.out.println("Середні значення елементів кожного рядка:");
        System.out.println(Arrays.toString(averages));
    }

    public static byte[][] initializeMatrixA() {
        return new byte[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    public static byte[][] initializeMatrixB() {
        return new byte[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
    }

    public static void main(String[] args) {
        try {

            byte[][] matrixA = initializeMatrixA();
            byte[][] matrixB = initializeMatrixB();

            byte[][] matrixC = bitwiseXorAnd(matrixA, matrixB);
            System.out.println("Матриця C (результат побітового виключного АБО):");
            printMatrix(matrixC);

            double[] rowAverages = calculateRowAverages(matrixC);
            printAverages(rowAverages);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Невідома помилка: " + e.getMessage());
        }
    }
}
