import static org.junit.Assert.*;

import org.junit.Test;


/*
行列の積を計算し、行列の中身を全て足した値が正しいかのみ
のテスト
*/

public class Matrix3Test {

	@Test
	public void test() {
		assertEquals(0,Matrix3.sum(0),0.000001);
		assertEquals(450,Matrix3.sum(3),0.000001);
		assertEquals(3680,Matrix3.sum(4),0.000001);
	}

}
