import static org.junit.Assert.*;

import org.junit.Test;

/*
 ①行列の積がちゃんと計算出来ているか、
 ②行列の中身を全て足せているか
 についてのテスト
 */

public class Matrix2Test {

	@Test
	public void test() {
		double[][] s=new double[2][2];
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				s[i][j]=0;
			 }
		 }
		double[][] a1=new double[3][3];
		double[][] b1=new double[3][3];
		double[][] a2=new double[3][3]; //マイナスの値
		double[][] b2=new double[3][3];	//マイナスの値
		double[][] a3=new double[3][3]; //小数点
		double[][] b3=new double[3][3]; //小数点
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				a1[i][j] = i * 3 + j;
		        b1[i][j] = j * 3 + i;
		        a2[i][j] = i * -3 - j;
		        b2[i][j] = j * -3 - i;
		        a3[i][j] = i * 1.3 + j;
		        b3[i][j] = j * 1.3 + i;
			 }
		}
		double[][] c1={{5,14,23},{14,50,86},{23,86,149}};
		double[][] c3={{5,8.9,12.8},{8.9,17.87,26.84},{12.8,26.84,40.88}};
		 
		//assertEquals(0,Matrix2.sum(0),0);
		//assertEquals(450,Matrix2.sum(3),0);
		//assertEquals(3680,Matrix2.sum(4),0);
		//assertArrayEquals(s,Matrix2.a());
		
		/*関数matrixのテスト*/
		assertArrayEquals(s,Matrix2.matrix(s,s)); //s*s
		assertArrayEquals(c1,Matrix2.matrix(a1,b1)); //a1*b1
		assertArrayEquals(c1,Matrix2.matrix(a2,b2)); //a2*b2
		assertEquals(c3[0][0],Matrix2.matrix(a3,b3)[0][0],0.000001); //少数点
		assertEquals(c3[0][1],Matrix2.matrix(a3,b3)[0][1],0.000001);
		assertEquals(c3[0][2],Matrix2.matrix(a3,b3)[0][2],0.000001);
		assertEquals(c3[1][2],Matrix2.matrix(a3,b3)[1][2],0.000001);
		assertEquals(c3[2][1],Matrix2.matrix(a3,b3)[2][1],0.000001);
		
		/*関数sumのテスト*/
		assertEquals(0,Matrix2.sum(s),0.000001); //中身が全部0
		assertEquals(36,Matrix2.sum(a1),0.000001);	
		assertEquals(-36,Matrix2.sum(a2),0.000001); //マイナスの値
		assertEquals(20.7,Matrix2.sum(a3),0.000001); //小数点
	}

}
