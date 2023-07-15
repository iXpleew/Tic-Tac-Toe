import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    char [] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void  main (String [] args) {
        Main mainInstance = new Main();

        boolean sbWon;
        boolean Xturn = false;
        char turn;
        int answer;

        System.out.println("-----Tic Tac Toe-----");

        do {
            do {
                Xturn = !Xturn;
                if (Xturn) turn = 'X';
                else turn = 'O';

                System.out.println("It's " + turn + " turn, type the number of a square you want to put your sign in");
                mainInstance.drawBoard();
                mainInstance.typeSign(Xturn);
                sbWon = mainInstance.checkWin(turn);

            } while (!sbWon);

            System.out.println("Player " + turn + " won");
            System.out.println("Do you want to play once again?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            answer = mainInstance.scanner.nextInt();
            mainInstance.clearBoard();

        } while(answer == 1);
        System.out.println("Thank you for playing this game!");
    }

    public void drawBoard()   {
        System.out.println(board[0] + "|" + board [1] + "|" + board[2]);
        System.out.println(board[3] + "|" + board [4] + "|" + board[5]);
        System.out.println(board[6] + "|" + board [7] + "|" + board[8]);
    }
    public void typeSign(boolean activeTurn)    {
        int position = scanner.nextInt();

        while ( !((position > 0 && position < 10) && (board [position - 1] != 'O' && board[position - 1] != 'X'))) {
            System.out.println("You typed a wrong number or this square was used before, please type your number once again: ");
            position = scanner.nextInt();
        }
        if(activeTurn) board[position - 1] = 'X';
        else board [position - 1] = 'O';
    }
    public boolean checkWin(char si) {
        if ((board[0] == si && board [1] == si && board [2] == si)
                || (board[3] == si && board [4] == si && board [5] == si)
                || (board[6] == si && board [7] == si && board [8] == si)
                || (board[0] == si && board [3] == si && board [6] == si)
                || (board[1] == si && board [4] == si && board [7] == si)
                || (board[2] == si && board [5] == si && board [8] == si)
                || (board[0] == si && board [4] == si && board [8] == si)
                || (board[2] == si && board [4] == si && board [6] == si))  {
            return true;
        }
        else return false;
    }
    public void clearBoard()    {
        char[] initialBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.arraycopy(initialBoard, 0, board, 0, initialBoard.length);
    }
}