
public class IdException extends Exception{

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	private static final long serialVersionUID = 1L;
	
	/* method  IdException----------------------------------------------------------------------------------                                                                                                    
	* IdException建構子
	*
	* @param id 學號
	* @return 無
	*
	* @throws 無
	*		  
	*Pseudo code:
	*1.儲存id至private變數
    *
	* Time estimate : O (1)
	* Example: e = new IdException(103062319) 建構子
	----------------------------------------------------------------------------------------------------------*/
	public IdException(int id){
		this.id=id;
	}
	
	/* method  IdNotFound----------------------------------------------------------------------------------                                                                                                    
	* 螢幕顯示該學號不存在於系統中
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*		  
	*Pseudo code:
	*1.螢幕顯示該學號不存在於系統中
    *
	* Time estimate : O (1)
	* Example: e.IdNotFound() 螢幕顯示“Id 103062319 not found”
	----------------------------------------------------------------------------------------------------------*/
	public void IdNotFound(){
		System.out.println("Id "+id+" not found");
	}

}
