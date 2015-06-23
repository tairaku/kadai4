/*
 Class2のプログラムをもとにテストをしやすいように、
 行列の積を計算し、行列の中身を全て足す関数(sum)のみ。
 Matrix2.javaとは違い、matrix関数はなし。
 */


class Matrix3 {
		  public static void main(String args[])
		  {
		    if (args.length != 1) {
		      System.out.println("usage: java Matrix N");
		      return;
		    }
		    int n = Integer.parseInt(args[0]);
		   
		    double sum=sum(n); //行列Cの中身を全て足す。
		    System.out.printf("sum: %.6f\n", sum);
		  }
		  
		  public static double sum(int n){ //行列aとbの積を計算し、中身を足す。
			  double[][] a = new double[n][n]; // Matrix A
			  double[][] b = new double[n][n]; // Matrix B
			  double[][] c= new double[n][n]; // Matrix C
			// Initialize the matrices to some values.
			  int i, j;
			  for (i = 0; i < n; i++) {
			    for (j = 0; j < n; j++) {
			    	a[i][j] = i * n + j;
			        b[i][j] = j * n + i;
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
