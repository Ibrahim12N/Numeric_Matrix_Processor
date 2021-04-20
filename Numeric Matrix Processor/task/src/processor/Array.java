package processor;

import java.util.Scanner;

public class Array {

    double[][] arrayInput(int rows, int columns) {
        Scanner scanner= new Scanner(System.in);
        double [][] array=new double[rows][columns];

        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                array[i][j]=scanner.nextDouble();
            }
        }
        return array;
    }

    public void showArray(double[][] sumArray) {
        System.out.println("The result is:");
        for (double[] doubles : sumArray) {
            System.out.println();
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
        }
    }

    double [][]  addArray(double [][] array1, double [][] array2) {
        double [][] newArray=new double[array1.length][array1[0].length];
        for (int i=0;i<array1.length;i++){
            for (int j=0;j<array1[i].length;j++){
                newArray[i][j]=array1[i][j]+array2[i][j];
            }
        }
        return newArray;
    }

    double [][] multiplyArrayByConstant(double [][] array, double cons) {
        double [][] newArray=new double[array.length][array[0].length];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                newArray[i][j]=array[i][j]*cons;
            }
        }
        return newArray;
    }

    double [][] multiplyArrays(double [][] array1, double [][] array2) {
        double [][] newArray=new double[array1.length][array2[0].length];
        for (int i=0;i<array1.length;i++){
            for (int j=0;j<array2[i].length;j++){
                for(int k=0;k<array2.length;k++)
                    newArray[i][j]+=array1[i][k]*array2[k][j];
            }
            }
        return newArray;
    }

    public double[][] mainDiagonal(double [][] array) {
        double [][] newArray=new double[array.length][array[0].length];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                newArray[i][j]=array[j][i];
            }
        }
        return newArray;
    }

    public double[][] sideDiagonal(double [][] array) {
        double [][] newArray=new double[array.length][array[0].length];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                newArray[i][j]=array[array[i].length-j-1][array[i].length-i-1];
            }
        }
        return newArray;
    }

    public double[][] verticalLine(double [][] array) {
        double [][] newArray=new double[array.length][array[0].length];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                newArray[i][j]=array[i][array.length-j-1];
            }
        }
        return newArray;
    }

    public double[][] horizontalLine(double [][] array) {
        double [][] newArray=new double[array.length][array[0].length];
        for (int i=0;i<array.length;i++){
            System.arraycopy(array[array.length - i - 1], 0, newArray[i], 0, array[i].length);
        }
        return newArray;
    }

    public double [][] createSubMatrix(double [][] array, int excluding_row, int excluding_col,int n) {
        double [][] newArray = new double [n-1][n-1];
        int row = -1;
        for (int i=0;i<n;i++) {
            if (i==excluding_row)
                continue;
            row++;
            int column =-1;
            for (int j=0;j<n;j++) {
                if (j==excluding_col)
                    continue;
                column++;
                newArray[row][column]=array[i][j];
            }
        }
        return newArray;
    }

    public double determinantCalc(double[][] array, int n) {
        double determinant = 0;
        if (n == 1)
            return array[0][0];

        double[][] temp;
        int sign = 1;
        for (int f = 0; f < n; f++)
        {
            temp=createSubMatrix(array,0,f,n);
            determinant += sign * array[0][f] * determinantCalc(temp, n - 1);
            sign = -sign;
        }
        return determinant;
    }

    public double [][] coFactor (double [][] array){
        double [][] newArray = new double [array.length][array[0].length];
        for (int i=0;i<array.length;i++) {
            for (int j=0; j<array[i].length;j++) {
                newArray[i][j]=Math.pow(-1,i+j)*determinantCalc(createSubMatrix(array,i,j,array.length),array.length-1);
            }
        }
        return newArray;
    }

    public double [][] inverse(double[][] array, int rows) {
        double x=1.0/determinantCalc(array,rows);
        return multiplyArrayByConstant(mainDiagonal(coFactor(array)),x);
    }
}
