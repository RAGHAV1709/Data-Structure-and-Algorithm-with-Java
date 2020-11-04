package matrixmultiplication1;
import java.util.*;
public class MatrixMultiplication1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        int[][] c = new int[n][m];
        System.out.println("The matrix a is: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j]=sc.nextInt();
            }
            
        }
        System.out.println("The matrix b is: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                b[i][j] = sc.nextInt();
            }
            
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<n; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("The resultant matrix is: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
