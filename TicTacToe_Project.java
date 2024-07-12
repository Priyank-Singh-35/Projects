import java.util.Scanner;
public class TicTacToe {

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean isGameOver(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; 
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; 
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; 
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; 
        }

        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    draw = false;
                    break;
                }
            }
        }
        return draw;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        char currentPlayer = 'X'; 
        int row, col;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            System.out.println("\nCurrent board:");
            printBoard(board);

            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row - 1][col - 1] = currentPlayer;

            if (isGameOver(board, currentPlayer)) {
                System.out.println("Current board:");
                printBoard(board);
                if (isGameOver(board, 'X')) {
                    System.out.println("Player X wins!");
                } else if (isGameOver(board, 'O')) {
                    System.out.println("Player O wins!");
                } else {
                    System.out.println("It's a draw!");
                }
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }
}
