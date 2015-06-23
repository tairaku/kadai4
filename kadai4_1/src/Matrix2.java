/*
 Class2のプログラムをもとにテストをしやすいように、
 行列の積を計算する関数(matrix)と行列の中身を全て足す関数(sum)に分離。
 Matrix3.javaとは少し違います。
 */


class Matrix2 {
		  public static void main(String args[])
		  {
		    if (args.length != 1) {
		      System.out.println("usage: java Matrix N");
		      return;
		    }
		    int n = Integer.parseInt(args[0]);
		    double[][] a = new double[n][n]; // Matrix A
		    double[][] b = new double[n][n]; // Matrix B
		    double[][] c = new double[n][n]; // Matrix C

		    // Initialize the matrices to some values.
		    int i, j;
		    for (i = 0; i < n; i++) {
		      for (j = 0; j < n; j++) {
		        a[i][j] = i * n + j;
		        b[i][j] = j * n + i;
		        c[i][j] = 0;
		      }
		    }
		    
		    c=matrix(a,b); //C = A * B
		    double sum=sum(c); //行列Cの中身を全て足す。
		    System.out.printf("sum: %.6f\n", sum);
		  }
		  
		  public static double[][] matrix(double[][] a,double[][] b){ //行列aとbの積を計算
			  int n = a.length;
			  double[][] c= new double[n][n]; // Matrix C
			// Initialize the matrices to some values.
			  int i, j;
			  for (i = 0; i < n; i++) {
			    for (j = 0; j < n; j++) {
			    	c[i][j] = 0;
			    }
			  }
			  
			// Write code to calculate C = A * B.
			  int k,l,m;
			  for(k=0;k<n;k++) {
			    	for(l=0;l<n;l++) {
			    		for(m=0;m<n;m++) {
			    			c[k][l]+=a[k][m]*b[m][l];
			    		}
			    	}
			   }
			 return c;
		  }
		  
		 public static double sum(double[][] c){ //行列式の中身を全て足す。
			 int i,j;
			 int n=c.length;
			// Print C for debugging. Comment out the print before measuring the execution time.
			 double sum2 = 0;
			 for (i = 0; i < n; i++) {
			    for (j = 0; j < n; j++) {
			        sum2 += c[i][j];
			    }
			 }
			 return sum2;
		 }
		 
}
