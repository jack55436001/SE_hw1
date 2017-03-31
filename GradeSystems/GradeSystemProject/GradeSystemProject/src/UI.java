import java.util.*;

public class UI {
	/**
	 * @uml.property  name="gradeSystems"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private GradeSystems gradeSystems;
	/**
	 * @uml.property  name="scanner"
	 */
	private Scanner scanner;
	
	/* method  UI----------------------------------------------------------------------------------                                                                                                    
	* UI建構子
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.創建一個GradeSystems與一個Scanner
    *
	* Time estimate : O (1)
	* Example: ui = new UI()  建立一個新的UI
	----------------------------------------------------------------------------------------------------------*/
	public UI(){
		gradeSystems = new GradeSystems();
		scanner = new Scanner(System.in);
	}
	
	/* method  finalize----------------------------------------------------------------------------------                                                                                                    
	* override finalize確保Scanner在最後有關閉
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.Call Scanner的Close method
    *
	* Time estimate : O (1)
	* Example: ui.finalize() 在UI object delete前會呼叫
	----------------------------------------------------------------------------------------------------------*/
	@Override
	public void finalize()
	{
		scanner.close();
	}
	
	/* method  checkID----------------------------------------------------------------------------------                                                                                                    
	* 確認該學號是否存在於gradeSystems
	*
	* @param id 學生學號
	* @return boolean 存在與否
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.gradeSystems call containsID這個method,並回傳之
    *
	* Time estimate : O (1)
	* Example: ui.checkID(103062319) 確認此學號是否存在於gradeSystems
	----------------------------------------------------------------------------------------------------------*/
	public boolean checkID(int id){
		return gradeSystems.containsID(id);
	}
	
	/* method  promptID----------------------------------------------------------------------------------                                                                                                    
	* 螢幕顯示並且輸入學號
	*
	* @param 無
	* @return id 學號
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.螢幕顯示輸入ID
	*2.利用變數id記住使用者輸入的學號
	*3.回傳id
    *
	* Time estimate : O (1)
	* Example: ui.promptID()  螢幕顯示與輸入學號後,回傳學號
	----------------------------------------------------------------------------------------------------------*/
	public String promptID(){
		String id;
		System.out.println("請輸入ID 或 輸入Q離開：");
		id = scanner.next();
		return id;
	}
	
	/* method  showFinishMsg----------------------------------------------------------------------------------                                                                                                    
	* 顯示結束畫面
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.顯示結束畫面
    *
	* Time estimate : O (1)
	* Example: ui.showFinishMsg()  顯示結束畫面
	----------------------------------------------------------------------------------------------------------*/
	public void showFinishMsg(){
		System.out.println("謝謝使用本系統");
	}
	
	/* method  showWelcomeMsg----------------------------------------------------------------------------------                                                                                                    
	* 顯示登入畫面
	*
	* @param id 學號
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.呼叫gradeSystems的findNameByID method取得使用者名稱
	*2.螢幕顯示歡迎與使用者名稱
    *
	* Time estimate : O (1)
	* Example: ui.showWelcomeMsg(103062319)  螢幕顯示“歡迎 JSharp”
	----------------------------------------------------------------------------------------------------------*/
	public void showWelcomeMsg(int id){
		String name = gradeSystems.findNameByID(id);
		System.out.println("歡迎 "+name);
	}
	
	/* method  promptCommand----------------------------------------------------------------------------------                                                                                                    
	* 顯示可輸入的指令,並呼叫適當的method處理該指令
	*
	* @param id 學號
	* @return boolean 是否離開系統
	*
	* @throws CommandException-當輸入非螢幕指定的指令
	*		  
	*Pseudo code:
	*1.顯示可輸入之指令
	*2.使用者輸入欲執行項目之相對指令,呼叫相對應的method
	*3.回傳boolean是否離去
    *
	* Time estimate : O (1)
	* Example: ui.promptCommand(103062319) 回傳false
	----------------------------------------------------------------------------------------------------------*/
	public boolean promptCommand(int id){
		System.out.println("輸入指令\n1) G 顯示成績 (Grade)\n2) "
				+ "R 顯示排名 (Rank)\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n5) E 離開選單 (Exit)");
		try{
			String command = scanner.next();     
			if(command.equals("G"))	   gradeSystems.showGrade(id);
			else if(command.equals("R"))	gradeSystems.showRank(id);
			else if(command.equals("A"))	gradeSystems.showAverage();
			else if(command.equals("W"))	weightFunction();
			else if(command.equals("E"))	return false;
			else	throw new CommandException();
		}
		catch(CommandException e){
			e.CommandError();
		}
		catch(InputMismatchException e){
			System.out.println("Please enter number between 0 to 100.");
		}
		promptExit();
		return true;
	}
	
	/* method  weightFunction----------------------------------------------------------------------------------                                                                                                    
	* 處理更新權重之指令
	*
	* @param 無
	* @return 無
	*
	* @throws CommandException-當輸入非螢幕指定的指令
	*	
	*Pseudo code:
	*1.呼叫showOldWeights顯示當前權重分佈
	*2.呼叫getNewWeights取得新權重array
	*3.呼叫showNewWeights顯示更新權重分佈
	*4.顯示是否確認修改
    *
	* Time estimate : O (1)
	* Example: weightFunction() 處理更新權重之核心
	----------------------------------------------------------------------------------------------------------*/
	private void weightFunction()
	{
		gradeSystems.showOldWeights();
		int [] newWeights=getNewWeights();
		showNewWeights(newWeights);
		System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
		String t = scanner.next();
		try{
			if(t.equals("Y"))	gradeSystems.updateWeights(newWeights);
			else if(t.equals("N"))	System.out.println("Weights not change");
			else throw new CommandException();
		}
		catch(CommandException e){
			e.CommandError();
		}
	}
	
	/* method  promptExit----------------------------------------------------------------------------------                                                                                                    
	* 顯示回到主選單需要輸入之指令
	*
	* @param 無
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.螢幕顯示使用者需要輸入之指令
	*2.跑while迴圈,直到使用者輸入對應之指令
    *
	* Time estimate : O (1)
	* Example: ui.promptExit() 直到輸入Ｅ才離開
	----------------------------------------------------------------------------------------------------------*/
	private void promptExit(){
		System.out.println("請輸入 Ｅ 回到主選單");
		
		while(true){
			String command = scanner.next();
			if(command.equals("E"))break;
		}
		
	}
	
	/* method  getNewWeights()----------------------------------------------------------------------------------                                                                                                    
	* 取得使用者輸入之權重陣列並回傳該權重陣列
	*
	* @param 無
	* @return newWeights 使用者輸入之權重陣列
	*
	* @throws InputMismatchException-非integer的輸入
	*	
	*Pseudo code:
	*1.初始化新的權重陣列皆為0
	*2.顯示欲輸入之成績名稱,並讀取使用者輸入
	*3.回傳新的權重陣列
    *
	* Time estimate : O (1)
	* Example: getNewWeights()  回傳更新之權重陣列
	----------------------------------------------------------------------------------------------------------*/
	private int[] getNewWeights() throws InputMismatchException{
		int[] newWeights = {0,0,0,0,0};
		System.out.println("---New Weights(%)---");
		System.out.println("Lab1: ");
		newWeights[0] = scanner.nextInt();
		System.out.println("Lab2: ");
		newWeights[1] = scanner.nextInt();
		System.out.println("Lab3: ");
		newWeights[2] = scanner.nextInt();
		System.out.println("midTerm: ");
		newWeights[3] = scanner.nextInt();
		System.out.println("finalExam: ");
		newWeights[4] = scanner.nextInt();
		
		return newWeights;
	}
	
	/* method  showNewWeights----------------------------------------------------------------------------------                                                                                                    
	* 顯示欲更新之權重陣列
	*
	* @param NewWeights 欲更新之權重陣列
	* @return 無
	*
	* @throws 無
	*	
	*Pseudo code:
	*1.顯示相對應之成績與權重
    *
	* Time estimate : O (1)
	* Example: ui.showNewWeights()  顯示相對應之成績與權重
	----------------------------------------------------------------------------------------------------------*/
	public void showNewWeights(int [] NewWeights){
		System.out.println("---Confirm New Weights(%)---");
		System.out.println("Lab1: " + (int)(NewWeights[0]) +"%");
		System.out.println("Lab2: " + (int)(NewWeights[1])+"%");
		System.out.println("Lab3: " + (int)(NewWeights[2]) +"%");
		System.out.println("midTerm: " + (int)(NewWeights[3]) +"%");
		System.out.println("finalExam: " + (int)(NewWeights[4]) +"%");
	}
	
	/* method  login----------------------------------------------------------------------------------                                                                                                    
	* 取得使用者學號並判斷是否有效
	*
	* @param 無
	* @return id 學號(若為0,-1為錯誤代碼)
	*
	* @throws IdException-當學號不存在於系統中,throw	 IdException
	* 		  NumberFormatException-當使用者輸入英文做為學號時,throw NumberFormatException
	*	
	*Pseudo code:
	*1.利用promptID()取得學號
	*2.判斷學號是否存在於系統
	*3.回傳學號或錯誤代碼
    *
	* Time estimate : O (1)
	* Example: login() 回傳-1(離開系統)
	----------------------------------------------------------------------------------------------------------*/
	public int login()
	{
		try{
			String id_string = promptID();
			if(id_string.equals("Q")){
				showFinishMsg();
				return -1;
			}
			int id = Integer.parseInt(id_string);
			if(!checkID(id)){
				throw new IdException(id);
			}
			return id;
			}
		catch(IdException e){
			e.IdNotFound();
			return 0;
		}
		catch(NumberFormatException e){
			System.out.println("學號只包括數字(Ex:962001044)");
			return 0;
		}
	}
}
