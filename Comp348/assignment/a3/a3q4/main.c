#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int** matrixTranspose (int **matrix, int r, int c);
int printMatrix(int **matrix, int row, int col);

int main() {

//    Generate a new 2D array.
    srand((unsigned)time(NULL));
    int row, col;
    printf("Enter the number of rows: ");
    scanf("%d",&row);
    printf("Enter the number of columns: ");
    scanf("%d",&col);
    int ** b = (int**)malloc(row * sizeof(int*));
    for(int i =0 ; i < row;i++)
        b[i] = (int*)malloc(col * sizeof(int));
    for(int i = 0; i < row; i++)
        for(int j = 0; j < col; j++)
            b[i][j] = rand() % 10;

//    print the array
    printf("Randomly generated Two Dimensional array:\n");
    printMatrix(b, row, col);

//    Transpose
    int ** newMatrix = matrixTranspose(b, row, col);

//    print it again
    printf("\nTranspose:\n");
    printMatrix(newMatrix, col, row);

    return 0;
}

int printMatrix(int **matrix, int row, int col){
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            printf("%d ", matrix[i][j]);
            if(j == col - 1){
                printf("\n");
            }
        }
    }
    return 0;
}

int** matrixTranspose (int **matrix , int r, int c){
    if (r == c){
        for(int i=0; i<r; i++) {
            for(int j=i+1;j<c;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    } else {
        int **newMatrix = (int**)malloc(c * sizeof(int*));
        for(int i =0 ; i < c;i++)
            newMatrix[i] = (int*)malloc(r * sizeof(int));
        for(int i = 0; i < r; i++) {
            for(int j = 0;j<c;j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
    return matrix;
}
