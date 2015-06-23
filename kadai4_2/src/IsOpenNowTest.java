import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;


public class IsOpenNowTest {

	@Test
	public void test() {
		assertTrue(IsOpenNow.isOpenNow(Calendar.MONDAY, 12)); //昼と夜の営業で昼の時間帯
	    assertTrue(IsOpenNow.isOpenNow(Calendar.MONDAY, 20)); //昼と夜の営業で夜の時間帯
	    assertTrue(IsOpenNow.isOpenNow(Calendar.TUESDAY, 13)); //昼営業のみ
	    assertTrue(IsOpenNow.isOpenNow(Calendar.SUNDAY, 3));//日をまたいで
	    assertTrue(IsOpenNow.isOpenNow(Calendar.THURSDAY, 2)); //日をまたいで
	    assertTrue(IsOpenNow.isOpenNow(Calendar.THURSDAY, 21)); //朝と昼と夜の営業
	    
	    
	    assertFalse(IsOpenNow.isOpenNow(Calendar.THURSDAY, 16)); //朝と昼の営業
	    assertFalse(IsOpenNow.isOpenNow(Calendar.THURSDAY, 4)); //朝と昼と夜で営業
	    assertFalse(IsOpenNow.isOpenNow(Calendar.FRIDAY, 2)); //closeの日
	    assertFalse(IsOpenNow.isOpenNow(Calendar.SATURDAY, 10)); 
	    assertTrue(IsOpenNow.isOpenNow(Calendar.SUNDAY, 3)); //日をまたいで
		
	}

}
