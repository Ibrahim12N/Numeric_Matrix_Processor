package processor;

import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {

        while(true) {
            menu();
            System.out.print("Your choice:");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyMatricesByConst();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 5:
                    determinant();
                    break;
                case 6:
                    inverseMatrix();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void inverseMatrix() {
        System.out.println("Enter size of matrix:");
        int rows=scanner.nextInt();
        int columns=scanner.nextInt();
        System.out.println("Enter matrix:");
        Array arrayObj=new Array();
        double[][] arrayInput=arrayObj.arrayInput(rows,columns);
        System.out.println("The result is:");
        double [][] result=arrayObj.inverse(arrayInput,rows);
        arrayObj.showArray(result);
    }

    private static void determinant() {
        System.out.println("Enter size of matrix:");
        int rows=scanner.nextInt();
        int columns=scanner.nextInt();
        System.out.println("Enter matrix:");
        Array arrayObj=new Array();
        double[][] arrayInput=arrayObj.arrayInput(rows,columns);
        System.out.println(arrayObj.determinantCalc(arrayInput,rows));
    }

    private static void transposeMatrix() {
        System.out.println("\n1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice:");
        int option = scanner.nextInt();
        System.out.println("Enter matrix size:");
        int rows=scanner.nextInt();
        int columns=scanner.nextInt();
        System.out.println("Enter matrix:");
        Array arrayObj=new Array();
        double[][] array=arrayObj.arrayInput(rows,columns);
        double [][] result;
        switch (option) {
            case 1:
                result=arrayObj.mainDiagonal(array);
                arrayObj.showArray(result);
                break;
            case 2:
                result=arrayObj.sideDiagonal(array);
                arrayObj.showArray(result);
                break;
            case 3:
                result=arrayObj.verticalLine(array);
                arrayObj.showArray(result);
                break;
            case 4:
                result=arrayObj.horizontalLine(array);
                arrayObj.showArray(result);
                break;
        }
    }

    private static void multiplyMatrices() {
        System.out.println("Enter size of first matrix:");
        int rows1=scanner.nextInt();
        int columns1=scanner.nextInt();
        System.out.println("Enter first matrix:");
        Array arrayObj=new Array();
        double[][] array1=arrayObj.arrayInput(rows1,columns1);
        System.out.println("Enter size of second matrix:");
        int rows2=scanner.nextInt();
        int columns2=scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] array2=arrayObj.arrayInput(rows2,columns2);
        double[][] result=arrayObj.multiplyArrays(array1,array2);
        arrayObj.showArray(result);
    }

    private static void multiplyMatricesByConst() {
        System.out.println("Enter size of matrix:");
        int rows=scanner.nextInt();
        int columns=scanner.nextInt();
        System.out.println("Enter matrix:");
        Array arrayObj=new Array();
        double[][] array=arrayObj.arrayInput(rows,columns);
        System.out.println("Enter constant:");
        double constant=scanner.nextInt();
        double[][] result=arrayObj.multiplyArrayByConstant(array,constant);
        arrayObj.showArray(result);
    }

    private static void addMatrices() {
        System.out.println("Enter size of first matrix:");
        int rows1=scanner.nextInt();
        int columns1=scanner.nextInt();
        System.out.println("Enter first matrix:");
        Array arrayObj=new Array();
        double[][] array1=arrayObj.arrayInput(rows1,columns1);
        System.out.println("Enter size of second matrix:");
        int rows2=scanner.nextInt();
        int columns2=scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] array2=arrayObj.arrayInput(rows2,columns2);
        double[][] result=arrayObj.addArray(array1,array2);
        arrayObj.showArray(result);
    }

    private static void menu() {
        System.out.println("\n1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
    }
}
