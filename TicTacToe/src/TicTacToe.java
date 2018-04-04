import java.util.Scanner;

public class TicTacToe {

    static int n = 3;
    static int[][] game = new int[n][n];
    static boolean win = false;
    static boolean finished = false;
    static String player1;
    static String player2;

    static final String SIGN_X = "X";
    static final String SIGN_0 = "0";

    static String boxSign(int value) {
        if (2 == value) {
            return SIGN_0;
        } else if (1 == value) {
            return SIGN_X;
        } else {
            return " ";
        }
    }

    static int boxValue(String sign) {
        if (SIGN_X.equals(sign)) {
            return 1;
        } else if (SIGN_0.equals(sign)) {
            return 2;
        } else {
            return 0;
        }
    }

    static String getPlayerSign(String player) {
        if (player1.equals(player)) {
            return SIGN_X;
        } else {
            return SIGN_0;
        }
    }

    static void printGame() {
        System.out.println("-------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String sign = boxSign(game[i][j]);
                System.out.print("|" + sign);
            }
            System.out.println("|");
            System.out.println("-------");
        }
    }

    static boolean isWinLine(int lineNo, int value) {
        boolean winL = true;
        int i = 0;
        while ((winL) && (i < n)) {
            if (game[lineNo][i] != value) {
                winL = false;
            }
            i++;
        }
        return winL;
    }

    static boolean isWinCols(int colNo, int value) {
        boolean winC = true;
        int i = 0;
        while ((winC) && (i < n)) {
            if (game[i][colNo] != value) {
                winC = false;
            }
            i++;
        }
        return winC;
    }

    static boolean isWinDiags(int value) {
        boolean winD1 = true;
        boolean winD2 = true;
        int i = 0;
        while ((winD1 || winD2) && (i < n)) {
            if (game[i][i] != value) {
                winD1 = false;
            }
            if (game[i][n - 1 - i] != value) {
                winD2 = false;
            }
            i++;
        }
        return (winD1 || winD2);
    }

    static boolean validateMove(int line, int col) {
        boolean valid = false;
        if (game[line][col] == 0) {
            valid = true;
        }
        return valid;
    }

        static boolean isWin ( int value){
            boolean gameWin = false;
            int i = 0;
            while ((i < n) && !gameWin) {
                gameWin = isWinLine(i, value);
                i++;
            }
            while ((i < n) && !gameWin) {
                gameWin = isWinCols(i, value);
                i++;
            }
            if (!gameWin) {
                gameWin = isWinDiags(value);
            }
            return gameWin;
        }

        public static void main (String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Tic Tac Toe");

            System.out.println("Name player X: ");
            player1 = sc.nextLine();
            System.out.println("Name player 0: ");
            player2 = sc.nextLine();
            System.out.println("Players name are: " + player1 + "/" + player2);
            printGame();
            int numberOfMoves = 0;
            String currentPlayer = player1;
            while (!(win || finished)) {
                //play game
                System.out.println("Player " + currentPlayer + "'s turn: ");
                //player inputs moves
                int mLine;
                int mCol;

                //validate move
                do {
                    System.out.print("line: ");
                    mLine = sc.nextInt();
                    System.out.print("column: ");
                    mCol = sc.nextInt();
                }while(validateMove(mLine, mCol));

                //player moves
                game[mLine][mCol] = boxValue(getPlayerSign(currentPlayer));
                numberOfMoves++;

                //test for win
                win = isWin(boxValue(getPlayerSign(currentPlayer)));

                //test for finished
                if (numberOfMoves == n * n) {
                    finished = true;
                }
                printGame();

                if (!(win || finished)) {
                    //change player
                    if (currentPlayer.equals(player1)) {
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
                }
            }
            if (win) {
                System.out.println("Player " + currentPlayer + " won!");
            } else if (finished) {
                System.out.println("Game is a draw!!!");
            }
        }
    }
