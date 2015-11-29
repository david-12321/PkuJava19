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
			String board[][] = chessboard.getBoard();
			
			int whiteScore[][][] = new int [Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE][5];
			int blackScore[][][] = new int [Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE][5];

			int scoreStandard[] = {0,1,2,3,4};
			
			// 白子扫描
			whiteScore = this.scanChess(board, scoreStandard, whiteScore);
			blackScore = this.scanChess(board, scoreStandard, blackScore);
			
			//找出最大值得坐标
			int maxWhite = this.getMaxScore(whiteScore);
			int maxBlack = this.getMaxScore(blackScore);

			int[] pos={0,0};
			if(maxWhite>maxBlack)
			{
				pos = this.getPosition(maxWhite, whiteScore);
			}
			else 
			{
				pos = this.getPosition(maxBlack, blackScore);
			}
			
			return pos;
		}
		
		public int[][][] scanChess(String[][] board,int[] scoreStandard,int[][][] score)
		{
			int flag = 0;
			for(int i = 0 ; i < Chessboard.BOARD_SIZE; i++){
				for(int j = 0; j < Chessboard.BOARD_SIZE; j++){
					// 如果扫描到空位置，以此点开始向四个方向扫描并计分
					if(board[i][j] == "十")	
					{
						int posX = i;
						int posY = j;
						
						// 行
						while(posY > 0 && board[posX][posY - 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posY --;
						}
						posY = j;
						
						while(posY < board[posX].length-1 && board[posX][posY + 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posY ++;
						}
						score[i][j][0] = scoreStandard[flag];
						
						posY = j; 
						flag = 0;
						
						// 列
						while(posX > 0 && board[posX - 1][posY] == Chessman.WHITE.getChessman()){
							flag ++;
							posX --;
						}
						posX = i; 
						
						while(posX < board.length-1 && board[posX + 1][posY] == Chessman.WHITE.getChessman()){
							flag ++;
							posX ++;
						}
						
						score[i][j][1] = scoreStandard[flag];
						posX = i;
						flag = 0; 
						
						// 对角线
						while(posX > 0 && posY > 0 && board[posX - 1][posY - 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX --;
							posY --;
						}
						posX = i; 
						posY = j;
						
						while(posX < board.length-1 && posY < board[posX].length-1 && board[posX + 1][posY + 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX ++;
							posY ++;
						}
						
						score[i][j][2] = scoreStandard[flag];
						posX = i; 
						posY = j;
						
						flag = 0; 
						
						// 反对角线
						while(posX > 0 && posY < board[posX].length-1 && board[posX - 1][posY + 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX --;
							posY ++;
						}
						
						posX = i; 
						posY = j;
						
						while(posX < board.length-1 && posY > 0 && board[posX + 1][posY - 1] == Chessman.WHITE.getChessman()){
							flag ++;
							posX ++;
							posY --;
						}
						
						score[i][j][3] = scoreStandard[flag];
						posX = i; 
						posY = j;
						
						flag = 0; 						
				
						for(int n = 0 ; n < 4 ; n++){
							if (score[i][j][n] > score[i][j][4])
								score[i][j][4] = score[i][j][n];
						}
					} 
				}
			}
			return score;
		}
		
		public int getMaxScore(int[][][] score)
		{
			int maxScore=0;
			for(int i = 0; i < score.length; i++)
			{
				for(int j = 0; j < score[i].length; j++)
				{
					if(maxScore < score[i][j][4])
						maxScore = score[i][j][4];
				}
			}
			return maxScore;
		}
		
		public int[] getPosition(int maxScore, int[][][] score)
		{
			breakFlag:for(int i = 0; i < score.length; i++){
				for(int j = 0; j < score[i].length; j++){
					if(score[i][j][4] == maxScore){
						posX = i;
						posY = j;
						break breakFlag;
					}
				}
			}		
			int [] pos = {posX, posY};
			return pos;
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
			
			// 临时坐标，复位用
			int tempX = posX;	
			int tempY = posY; 	
			
			//行
			while(posY > 0 && board[posX][posY-1] == ico )
			{
				count ++;
				posY --;
			}
			posY = tempY; 
			
			while(posY < board[posX].length-1 && board[posX][posY+1] == ico)
			{
				count ++;
				posY ++;
			}
			posY = tempY;
			
			if(count >= 5)
				return true;
			else
				count = 1;
			
			// 列
			while(posX > 0 && board[posX - 1][posY] == ico)
			{
				count ++;
				posX --;
			}
			posX = tempX;
			
			while(posX < board.length - 1 && board[posX + 1][posY] == ico)
			{
				count ++;
				posX ++;
			}
			
			posX = tempX;
			
			if(count >= 5)
				return true;
			else 
				count = 1;
			
			// 对角线
			while(posX > 0 && posY > 0 && board[posX - 1][posY - 1] == ico)
			{ 
				count ++;
				posX --;
				posY --;
			}
			posX = tempX;
			posY = tempY;
			
			while(posX < board.length-1 && posY < board[posX].length-1 && board[posX + 1][posY + 1] == ico)
			{
				count ++;
				posX ++;
				posY ++;
			}
			posX = tempX;
			posY = tempY;
			
			if(count >= 5)
				return true;
			else
				count = 1;

			// 反对角线			
			while(posX > 0 && posY < board[posX].length-1 && board[posX - 1][posY + 1] == ico)
			{
				count ++;
				posX --;
				posY ++;
			}
			posX = tempX;
			posY = tempY;
			
			while(posX < board.length-1 && posY > 0 && board[posX + 1][posY - 1] == ico)
			{
				count ++;
				posX ++;
				posY --;
			}
			posX = tempX;
			posY = tempY;
			
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