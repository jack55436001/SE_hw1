import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GradesTest {
	/**
	 * @uml.property  name="gd"
	 * @uml.associationEnd  
	 */
	Grades gd = null;
	/**
	 * @uml.property  name="gd2"
	 * @uml.associationEnd  
	 */
	Grades gd2 = null;
	
	/* method  setUp----------------------------------------------------------------------------------                                                                                                    
	* 初始化GradesTest
	*
	* @param 無
	* @return 無
	*
	* @throws Exception
	*	
	*Pseudo code:
	*1.創建並初始化兩個不同之Grades
    *
	* Time estimate : O (1)
	* Example:GradesTest.setUp()   初始化GradesTest
	----------------------------------------------------------------------------------------------------------*/
	@Before
	public void setUp() throws Exception {
		gd = new Grades(103062319, "JSharp", 30, 40, 50, 60, 70, new float[] { 0.2f, 0.2f, 0.2f, 0.2f, 0.2f });
		gd2 = new Grades(103062320, "CSharp", 100, 100, 50, 60, 70, new float[] { 0.2f, 0.2f, 0.2f, 0.2f, 0.2f });

	}
	
	/* method  testGetTotalGrade1----------------------------------------------------------------------------------                                                                                                    
	* 測試gd之GetTotalGrade
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.利用assertEquals比較手算與實際運算有無差別
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetTotalGrade1()   測試testGetTotalGrade1
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetTotalGrade1() {
		assertEquals(50,gd.getTotalGrade());
	}
	
	/* method  testGetTotalGrade2----------------------------------------------------------------------------------                                                                                                    
	* 測試gd2之GetTotalGrade
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.利用assertEquals比較手算與實際運算有無差別
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetTotalGrade2()   測試testGetTotalGrade2
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetTotalGrade2() {
		assertEquals(76,gd2.getTotalGrade());
	}

	/* method  testUpdateTotalGrade1----------------------------------------------------------------------------------                                                                                                    
	* 測試gd之UpdateTotalGrade
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd的updateTotalGrade()
	*2.利用assertEquals比較手算總成績與實際運算總成績有無差別,來判定是否更改權重
    *
	* Time estimate : O (1)
	* Example:GradesTest.testUpdateTotalGrade1()   測試testUpdateTotalGrade1
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testUpdateTotalGrade1() {
		gd.updateTotalGrade(new float[] {0.1f,0.1f,0.1f,0.1f,0.6f});
		assertEquals(60,gd.getTotalGrade());
	}
	
	/* method  testUpdateTotalGrade2----------------------------------------------------------------------------------                                                                                                    
	* 測試gd2之UpdateTotalGrade
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd2的updateTotalGrade()
	*2.利用assertEquals比較手算總成績與實際運算總成績有無差別,來判定是否更改權重
    *
	* Time estimate : O (1)
	* Example:GradesTest.testUpdateTotalGrade2()   測試testUpdateTotalGrade2
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testUpdateTotalGrade2() {
		gd2.updateTotalGrade(new float[] {0.1f,0.1f,0.1f,0.1f,0.6f});
		assertEquals(73,gd2.getTotalGrade());
	}
	
	/* method  testGetID1----------------------------------------------------------------------------------                                                                                                    
	* 測試gd之getID
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd的updateTotalGrade()
	*2.利用assertEquals比較id和回傳值是否相同
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetID1()   測試testGetID1
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetID1(){
		assertEquals(103062319,gd.getID());
	}
	
	/* method  testGetID2----------------------------------------------------------------------------------                                                                                                    
	* 測試gd2之getID
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd2的updateTotalGrade()
	*2.利用assertEquals比較id和回傳值是否相同
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetID2()  測試testGetID2
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetID2(){
		assertEquals(103062320,gd2.getID());
	}
	
	/* method  testGetGrades1----------------------------------------------------------------------------------                                                                                                    
	* 測試gd之getGrades
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd的getGrades()
	*2.利用assertEquals比較grade[]和回傳值是否相同
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetGrades1()  測試testGetGrades1
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetGrades1(){
		Assert.assertArrayEquals( new int[]{30, 40, 50, 60, 70}, gd.getGrades() );
	}
	
	/* method  testGetGrades2----------------------------------------------------------------------------------                                                                                                    
	* 測試gd2之getGrades
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd2的getGrades()
	*2.利用assertEquals比較grade[]和回傳值是否相同
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetGrades2()  測試testGetGrades2
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetGrades2(){
		Assert.assertArrayEquals( new int[]{100, 100, 50, 60, 70}, gd2.getGrades() );
	}
	
	/* method  testGetName1----------------------------------------------------------------------------------                                                                                                    
	* 測試gd之getName
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd的getName()
	*2.利用assertEquals比較名字和回傳值是否相同
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetName1()  測試testGetName1
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetName1(){
		assertEquals("JSharp",gd.getName());
	}
	
	/* method  testGetName2----------------------------------------------------------------------------------                                                                                                    
	* 測試gd2之getName
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gd2的getName()
	*2.利用assertEquals比較名字和回傳值是否相同
    *
	* Time estimate : O (1)
	* Example:GradesTest.testGetName2()  測試testGetName2
	----------------------------------------------------------------------------------------------------------*/
	@Test
	public void testGetName2(){
		assertEquals("CSharp",gd2.getName());
	}
}
