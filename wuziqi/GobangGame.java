import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	//�жϵ�ǰλ�ÿ����ڸ����������ߵ�������Ŀ
	private static int[][][][] line;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
//		
//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "ʮ") {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
//		int[] result = { posX, posY };
//		return result;
		LineCount();
		int black[][] = new int[Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE];
		int white[][] = new int[Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE];
		String[][] board = chessboard.getBoard();
		for(int i = 0; i < Chessboard.BOARD_SIZE; i++)
			for(int j = 0; j < Chessboard.BOARD_SIZE; j++)
			{
				if(board[i][j].equals("ʮ"))
				{
					for(int k = 0; k < 4; k++)
					{
						if(line[i][j][k][0] >= 4)//0Ϊ����
							black[i][j] += 10000;
						else if(line[i][j][k][0] == 3)
							black[i][j] += 1000;
						else if(line[i][j][k][0] == 2)
							black[i][j] += 100;
						else if(line[i][j][k][0] == 1)
							black[i][j] += 10;
					}
					for(int k = 0; k < 4; k++)
					{
						if(line[i][j][k][1] >= 4)//0Ϊ����
							white[i][j] += 10000;
						else if(line[i][j][k][1] == 3)
							white[i][j] += 1000;
						else if(line[i][j][k][1] == 2)
							white[i][j] += 100;
						else if(line[i][j][k][1] == 1)
							white[i][j] += 10;
					}
				}
			}
		int max_black = black[0][0];
		int max_white = white[0][0];
		int attack_x = 0;
		int attack_y = 0;
		int defend_x = 0;
		int defend_y = 0;
		for(int i = 0; i < Chessboard.BOARD_SIZE; i++)
			for(int j = 0; j < Chessboard.BOARD_SIZE; j++)
			{
				if(black[i][j] > max_black)
				{
					max_black = black[i][j];
					defend_x = i;
					defend_y = j;
				}
				if(white[i][j] > max_white)
				{
					max_white = white[i][j];
					attack_x = i;
					attack_y = j;
				}
			}
		if(max_black > max_white)
		{
			int[] result = new int[]{defend_x,defend_y};
				return result;
		}
		else
		{
			int[] result = new int[]{attack_x,attack_y};
			return result;
		}
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//0����  1������  2����  3������  4����  5������  6����  7������
		int move_x[] = new int[]{1, 1, 0, -1, -1, -1, 0, 1};  
		int move_y[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
		int x,y,count;
		String[][] board = chessboard.getBoard();
		for(int k = 0; k < 4; k++)
		{
			count = 0;
			x = posX;
			y = posY;
			for(int num = 0; num < 4; num++)
			{
				x = x + move_x[k];
				y = y + move_y[k];
				if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
                    break;  
                if(board[x][y].equals("��"))
                    count++;
                else
                	break;
			}
			x = posX;
			y = posY;
			for(int num = 0; num < 4; num++)
			{
				x = x + move_x[k + 4];
				y = y + move_y[k + 4];
				if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
                    break;  
                if(board[x][y].equals("��"))
                    count++;
                else
                	break;
			}
			line[posX][posY][k][0] = count;
			
			count = 0;
			x = posX;
			y = posY;
			for(int num = 0; num < 4; num++)
			{
				x = x + move_x[k];
				y = y + move_y[k];
				if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
                    break;  
                if(board[x][y].equals("��"))
                    count++;
                else
                	break;
			}
			x = posX;
			y = posY;
			for(int num = 0; num < 4; num++)
			{
				x = x + move_x[k + 4];
				y = y + move_y[k + 4];
				if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
                    break;  
                if(board[x][y].equals("��"))
                    count++;
                else
                	break;
			}
			line[posX][posY][k][1] = count;
		}
		for(int k = 0 ; k < 4; k++)
		{
			if(ico.equals("��"))
			{
				if(line[posX][posY][k][0] >= 4)
					return true;
			}
			else
			{
				if(line[posX][posY][k][1] >= 4)
					return true;
			}
		}
		return false;
	}
	
	public void LineCount()
	{
		int move_x[] = new int[]{1, 1, 0, -1, -1, -1, 0, 1};  
	    int move_y[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
	    int x,y,count;
	    String[][] board = chessboard.getBoard();
	    for(int i = 0; i < Chessboard.BOARD_SIZE; i++)
	    	for(int j = 0; j < Chessboard.BOARD_SIZE; j++)
	    	{
	    		if(board[i][j].equals("ʮ"))
	    		{
	    			for(int k = 0; k < 4; k++)
	    			{
	    				count = 0;
	    				x = i;
	    				y = j;
	    				for(int num = 0; num < 4; num++)
	    				{
	    					x = x + move_x[k];
	    					y = y + move_y[k];
	    					if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
	    	                    break;  
	    	                if(board[x][y].equals("��"))
	    	                    count++;
	    	                else
	    	                	break;
	    				}
	    				x = i;
	    				y = j;
	    				for(int num = 0; num < 4; num++)
	    				{
	    					x = x + move_x[k + 4];
	    					y = y + move_y[k + 4];
	    					if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
	    	                    break;  
	    	                if(board[x][y].equals("��"))
	    	                    count++;
	    	                else
	    	                	break;
	    				}
	    				line[i][j][k][0] = count;
	    				
	    				count = 0;
	    				x = i;
	    				y = j;
	    				for(int num = 0; num < 4; num++)
	    				{
	    					x = x + move_x[k];
	    					y = y + move_y[k];
	    					if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
	    	                    break;  
	    	                if(board[x][y].equals("��"))
	    	                    count++;
	    	                else
	    	                	break;
	    				}
	    				x = i;
	    				y = j;
	    				for(int num = 0; num < 4; num++)
	    				{
	    					x = x + move_x[k + 4];
	    					y = y + move_y[k + 4];
	    					if (x >= Chessboard.BOARD_SIZE || x < 0 || y >= Chessboard.BOARD_SIZE || y < 0 )  
	    	                    break;  
	    	                if(board[x][y].equals("��"))
	    	                    count++;
	    	                else
	    	                	break;
	    				}
	    				line[i][j][k][1] = count;
	    			}
	    		}
	    	}
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		line = new int[Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE][4][2];
		gb.start();
	}
}
