package wuziqi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的坐标
	private int posX = 0;
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	
	/**
	 * 空构造器
	 * */
	public GobangGame(){

	}
	
	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 * 			棋盘类
	 * */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}
	
	/**
	 * 检查输入是否合法
	 *
	 * @param inputStr
	 * 				由控制台输入的字符串
	 * @return 字符串合法返回true，反则返回false
	 * */
	public boolean isValid(String inputStr){
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字，数字)的格式输入: ");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0 || posY >= Chessboard.BOARD_SIZE)
		{
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1，与小于等于" + Chessboard.BOARD_SIZE + ",请重新输入： ");
			return false;
		}
		//检查输入的位置是否已有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十"){
			chessboard.printBoard();
			System.out.println("此位置已有棋子，请重新输入： ");
			return false;
		}
		return true;
	}
	
	/**
	 * 开始下棋
	 * */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取
		while ((inputStr = br.readLine()) != null){
			isOver = false;
			if (!isValid(inputStr)) {
				//如果不合法，要求重新输入，再继续
				continue;
			}
			//把对应数组元素赋值为“●”
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;
			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1], chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者， 询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)){
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				//如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入： ");
			}
		}
		
		/**
		 * 是否重新开始下棋。
		 * 
		 * @param chessman
		 * 				"●"为用户，"○"为计算机。
		 * @return 开始返回true，反则返回false。
		 * */
		public boolean isReplay(String chessman) throws Exception {
			chessboard.printBoard();
			String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了， " : "很遗憾，您输了， ";
			System.out.println(message + "再下一局？ (y/n)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if (br.readLine().equals("y")) {
				// 开始新一局
				return true;
			}		
			return false;
		}
		
		/**
		 * 计算机随机下棋
		 * */
		public int [] computerDo() {
//			int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			String[][] board = chessboard.getBoard();
//			while (board[posX][posY] != "十") {
//				posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//				posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			}
			
			String board[][] = chessboard.getBoard();
			
//		定义得分数组分别用来记录每个格子的得分，Wscore[x][y][n],Bscore[x][y][n]其中n为0-5，0-3分别依次代表横，竖，右斜，左斜四个方向,4为该坐标最大得分
			int Wscore[][][] = new int [Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE][5];
			int Bscore[][][] = new int [Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE][5];
			int scoreStandard[] = {0,100,400,2000,10000};
			int flag = 0;
			
			// 白子扫描
			for(int i = 0 ; i < Chessboard.BOARD_SIZE; i++){
				for(int j = 0; j < Chessboard.BOARD_SIZE; j++){
					if(board[i][j] == "十")	// 如果扫描到空位置，以此点开始向四个方向扫描并计分
					{
						// 保留坐标
						int posX = i;
						int posY = j;
						
						//----------------------横向计分------------------------------------
						while(posY > 0 && board[posX][posY - 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posY --;
						}
						
						posY = j;	// 坐标复位
						
						while(posY < board[posX].length-1 && board[posX][posY + 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posY ++;
						}
						Wscore[i][j][0] = scoreStandard[flag];	// 横向计分
						
						posY = j;  // 坐标复位
						flag = 0;  // 标记复位
						
						//---------------------纵向计分--------------------------------------
						while(posX > 0 && board[posX - 1][posY] == Chessman.WHITE.getChessman()){
							flag ++;
							posX --;
						}
						
						posX = i; // 坐标复位
						
						while(posX < board.length-1 && board[posX + 1][posY] == Chessman.WHITE.getChessman()){
							flag ++;
							posX ++;
						}
						
						Wscore[i][j][1] = scoreStandard[flag];
						
						posX = i; // 坐标复位
						flag = 0; // 标记复位
						
						//---------------------右斜计分--------------------------------------
						while(posX > 0 && posY > 0 && board[posX - 1][posY - 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX --;
							posY --;
						}
						
						// 坐标复位
						posX = i; 
						posY = j;
						
						while(posX < board.length-1 && posY < board[posX].length-1 && board[posX + 1][posY + 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX ++;
							posY ++;
						}
						
						Wscore[i][j][2] = scoreStandard[flag];
						// 坐标复位
						posX = i; 
						posY = j;
						
						flag = 0; // 标记复位	
						
						//---------------------左斜计分--------------------------------------
						while(posX > 0 && posY < board[posX].length-1 && board[posX - 1][posY + 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX --;
							posY ++;
						}
						
						// 坐标复位
						posX = i; 
						posY = j;
						
						while(posX < board.length-1 && posY > 0 && board[posX + 1][posY - 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX ++;
							posY --;
						}
						
						Wscore[i][j][3] = scoreStandard[flag];
						// 坐标复位
						posX = i; 
						posY = j;
						
						flag = 0; // 标记复位							
					//----计算最高分----
						for(int n = 0 ; n < 4 ; n++){
							if (Wscore[i][j][n] > Wscore[i][j][4])
							Wscore[i][j][4] = Wscore[i][j][n];
						}
					} 
				}
			}
			
			
			// 黑子扫描
			for(int i = 0 ; i < Chessboard.BOARD_SIZE; i++){
				for(int j = 0; j < Chessboard.BOARD_SIZE; j++){
					if(board[i][j] == "十")	// 如果扫描到空位置，以此点开始向四个方向扫描并计分
					{
						// 保留坐标
						int posX = i;
						int posY = j;
						
						//----------------------横向计分------------------------------------
						while(posY > 0 && board[posX][posY - 1] == Chessman.BLACK.getChessman()){
							flag ++;
							posY --;
						}
						
						posY = j;	// 坐标复位
						
						while(posY < board[posX].length-1 && board[posX][posY + 1] == Chessman.BLACK.getChessman()){
							flag ++;
							posY ++;
						}
						Bscore[i][j][0] = scoreStandard[flag];	// 横向计分
						
						posY = j;  // 坐标复位
						flag = 0;  // 标记复位
						
						//---------------------纵向计分--------------------------------------
						while(posX > 0 && board[posX - 1][posY] == Chessman.BLACK.getChessman()){
							flag ++;
							posX --;
						}
						
						posX = i; // 坐标复位
						
						while(posX < board.length-1 && board[posX + 1][posY] == Chessman.BLACK.getChessman()){
							flag ++;
							posX ++;
						}
						
						Bscore[i][j][1] = scoreStandard[flag];
						
						posX = i; // 坐标复位
						flag = 0; // 标记复位
						
						//---------------------右斜计分--------------------------------------
						while(posX > 0 && posY > 0 && board[posX - 1][posY - 1] == Chessman.BLACK.getChessman()){
							flag ++;
							posX --;
							posY --;
						}
						
						// 坐标复位
						posX = i; 
						posY = j;
						
						while(posX < board.length-1 && posY < board[posX].length-1 && board[posX + 1][posY + 1] == Chessman.BLACK.getChessman()){
							flag ++;
							posX ++;
							posY ++;
						}
						
						Bscore[i][j][2] = scoreStandard[flag];
						// 坐标复位
						posX = i; 
						posY = j;
						
						flag = 0; // 标记复位	
						
						//---------------------左斜计分--------------------------------------
						while(posX > 0 && posY < board[posX].length-1 && board[posX - 1][posY + 1] == Chessman.BLACK.getChessman()){
							flag ++;
							posX --;
							posY ++;
						}
						
						// 坐标复位
						posX = i; 
						posY = j;
						
						while(posX < board.length-1 && posY > 0 && board[posX + 1][posY - 1] == Chessman.BLACK.getChessman()){
							flag ++;
							posX ++;
							posY --;
						}
						
						Bscore[i][j][3] = scoreStandard[flag];
						// 坐标复位
						posX = i; 
						posY = j;
						
						flag = 0; // 标记复位							
					//----计算最高分----
						for(int n = 0 ; n < 4 ; n++){
							if (Bscore[i][j][n] > Bscore[i][j][4])
							Bscore[i][j][4] = Bscore[i][j][n];
						}
					} 
				}
			}
			
			//找出最大值得坐标
			int Wmax = 0;
			int Bmax = 0;
			int max = 0;
			
			for(int i = 0; i < Wscore.length; i++){
				for(int j = 0; j < Wscore[i].length; j++){
					if(Wmax < Wscore[i][j][4])
						Wmax = Wscore[i][j][4];
				}
			}
			for(int i = 0; i < Bscore.length; i++){
				for(int j = 0; j < Bscore[i].length; j++){
					if(Bmax < Bscore[i][j][4])
						Bmax = Bscore[i][j][4];
				}
			}
			
			if(Wmax >= Bmax)
			{	
				max = Wmax;
				label:for(int i = 0; i < Wscore.length; i++){
					for(int j = 0; j < Wscore[i].length; j++){
						if(Wscore[i][j][4] == max){
							posX = i;
							posY = j;
							break label;
						}
					}
				}
			}
			else
			{
				max = Bmax;
				label:for(int i = 0; i < Bscore.length; i++){
					for(int j = 0; j < Bscore[i].length; j++){
						if(Bscore[i][j][4] == max){
							posX = i;
							posY = j;
							break label;
						}
					}
				}
			}
			
//		棋型评分标准：从0-4连子得分分别为{0，100，400，2000，10000}			
			int [] result = {posX, posY};
			return result;
		}
		
		/**
		 *  判断输赢
		 *  
		 *  @param posX
		 *  			棋子的x坐标
		 *  @param posY
		 *  			棋子的y坐标
		 *  @param ico
		 *  			棋子类型
		 *  @return 如果有五颗相邻棋子连成一条直线，返回真，否则相反
		 * */
		public boolean isWon(int posX, int posY, String ico){
			String[][] board = chessboard.getBoard();
			int count = 1;
			//保留坐标
			int a = posX;	
			int b = posY; 	
			
//-----------横向判断-------------------------------------------
			while(posY > 0 && board[posX][posY-1] == ico )
			{
				count ++;
				posY --;
			}
			
			posY = b; 	//Y坐标复位
			
			while(posY < board[posX].length-1 && board[posX][posY+1] == ico)
			{
				count ++;
				posY ++;
			}
			
			posY = b;	//Y坐标复位
			
			if(count >= 5)
				return true;
			else
				count = 1;
			
//-----------纵向判断-------------------------------------------
			while(posX > 0 && board[posX - 1][posY] == ico)
			{
				count ++;
				posX --;
			}
			
			posX = a; 	//X坐标复位
			
			while(posX < board.length - 1 && board[posX + 1][posY] == ico)
			{
				count ++;
				posX ++;
			}
			
			posX = a;	//X坐标复位
			
			if(count >= 5)
				return true;
			else 
				count = 1;
			
//-----------右斜向判断-------------------------------------------
			while(posX > 0 && posY > 0 && board[posX - 1][posY - 1] == ico)
			{ 
				count ++;
				posX --;
				posY --;
			}
			
			//X,Y坐标复位
			posX = a;
			posY = b;
			
			while(posX < board.length-1 && posY < board[posX].length-1 && board[posX + 1][posY + 1] == ico)
			{
				count ++;
				posX ++;
				posY ++;
			}
			
			//X,Y坐标复位
			posX = a;
			posY = b;
			
			if(count >= 5)
				return true;
			else
				count = 1;

//-----------左斜向判断-------------------------------------------			
			while(posX > 0 && posY < board[posX].length-1 && board[posX - 1][posY + 1] == ico)
			{
				count ++;
				posX --;
				posY ++;
			}
			
			//X,Y坐标复位
			posX = a;
			posY = b;
			
			while(posX < board.length-1 && posY > 0 && board[posX + 1][posY - 1] == ico)
			{
				count ++;
				posX ++;
				posY --;
			}
			
			//X,Y坐标复位
			posX = a;
			posY = b;
			
			if(count >= 5)
				return true;
			else
				count = 1;
			
			return false;
		}
		
		public static void main(String[] args) throws Exception {
			GobangGame gb = new GobangGame (new Chessboard());
			gb.start();
		}
		
}
