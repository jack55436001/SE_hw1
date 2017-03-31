
public class CommandException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	/* method  CommandException----------------------------------------------------------------------------------                                                                                                    
	* 指令錯誤Exception建構子
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫super()
    *
	* Time estimate : O (1)
	* Example: e.CommandException() 建構CommandException
	----------------------------------------------------------------------------------------------------------*/
	public CommandException(){
		super();
	}
	
	/* method  CommandError----------------------------------------------------------------------------------                                                                                                    
	* 螢幕顯示輸入指令錯誤
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.螢幕顯示輸入指令錯誤
    *
	* Time estimate : O (1)
	* Example: e.CommandError() 螢幕顯示輸入指令錯誤
	----------------------------------------------------------------------------------------------------------*/
	public void CommandError(){
		System.out.println("Command Error(EX:若要顯示成績請輸入Ｇ)");
	}
}
