public class GradeSystemProject {
	private static UI ui;
	
	/* method  main----------------------------------------------------------------------------------                                                                                                    
	* 程式開始執行,重複操作指令直到使用者選擇離開
	*
	* @param 無
	* @return 無
	*
	* @throws 
	*	
	*Pseudo code:
	*1.利用迴圈取得使用者正確學號
	*2.利用另一個迴圈呼叫promptCommand()處理指令直到使用者選擇離開
    *
	* Time estimate : O (1)
	* Example: 無
	----------------------------------------------------------------------------------------------------------*/
	public static void main(String[] args){
		// TODO Auto-generated method stub
		ui = new UI();
		while(true){
			int id = ui.login();
			if(id==-1)return;
			else if(id==0);
			else{
				ui.showWelcomeMsg(id);
				while(true){
					if(!ui.promptCommand(id))
						break;
					System.out.println();
				}
			}
		}
	}
	
	
}