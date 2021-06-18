//**Run main method to play**
//importing Scanner 
import java.util.Scanner; 

public class TicTacToe
{
    public static void main(String[] args) 
    {
        //Declaring and Initializing Variables
        Scanner scan = new Scanner(System.in);
        //Row and Column 
        int r = 0;
        int c = 0;
        //Which player's turn it currently is
        boolean xTurn = true;
        boolean oTurn = false;
        //Current 'piece' being played (X or O)
        String piece = "";
        //The board itself 
        String[][] board = { { "|___|", "|___|", "|___|" }, { "|___|", "|___|", "|___|" }, { "|___|", "|___|", "|___|" } };
        //Prints out the board (see method below) 
        printBoard(board); 
        //while(true) loop to keep the game running 
        while (true) {
            //If statements to check which player's turn it currently is
            if (xTurn == true) 
            {
                piece = "|_X_|";
                System.out.println("X to move...");
            }
            if (oTurn == true) 
            {
                piece = "|_O_|";
                System.out.println("O to move...");
            }
            //Taking unput for player's move 
            System.out.println("Enter row:");
            r = scan.nextInt();
            System.out.println("Enter column:");
            c = scan.nextInt();
            //If the move is not invalid...
            if (!(r < 1 || r > 3 || c < 1 || c > 3 || board[r - 1][c - 1] != "|___|"))
            {
                //Sets position to the piece being played
                board[r - 1][c - 1] = piece;
                //Switches turns
                xTurn = !xTurn; 
                oTurn = !oTurn;
                //Clears screen
                System.out.print("\u000c");
                //Prints board 
                printBoard(board);
                //Testing for win
                if(end(board, piece).equals(piece))
                {
                    System.out.print("\u000c");
                    printBoard(board); 
                    if(piece == "|_X_|")
                    {
                        System.out.println("X wins!"); 
                    }
                    if(piece == "|_O_|")
                    {
                        System.out.println("O wins!"); 
                    }
                    break;
                }
                //Testing for draw
                else if(end(board, piece).equals("draw"))
                {
                    System.out.print("\u000c");
                    printBoard(board); 
                    System.out.println("Draw!"); 
                    break; 
                }
            }
            //If the move is invalid, asks for new move by repeating the loop without changing turns 
            else
            {
                System.out.print("\u000c");
                System.out.println("Invalid move!"); 
                printBoard(board);
            }
        }
    }
    //Static method to print the board 
    public static void printBoard(String[][] b) 
    {
        //Prints board using nested for loops 
        for (int i = 0; i < b.length; i++) 
        {
            for (int j = 0; j < b[i].length; j++) 
            {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }
    //Static method to check for win conditions 
    public static String end(String[][] a, String p)
    {
        //Testing row win conditions  
        for(int i = 0; i < a.length; i++)
        {
            if(a[i][0] == p && a[i][1] == a[i][0] && a[i][1] == a[i][2])
            {
                return p;
            }
        }
        //Testing column win conditions 
        for(int j = 0; j < a[0].length; j++)
        {
            if(a[0][j] == p && a[1][j] == a[0][j] && a[1][j] == a[2][j])
            {
                return p; 
            }
        }
        //Testing diagonal win conditions
        if(a[0][0] == p && a[0][0] == a[1][1] && a[0][0] == a[2][2])
        {
            return p; 
        }
        if(a[2][0] == p && a[2][0] == a[1][1] && a[2][0] == a[0][2])
        {
            return p; 
        }
        //Testing draw conditions
        int count = 0; 
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                if(a[i][j] == "|_X_|" || a[i][j] == "|_O_|")
                {
                    count++; 
                }
            }
        }
        if(count == (a.length) * (a[0].length))
        {
            return "draw"; 
        }
        return ""; 
    }
}
