import java.util.*;

public class TicTacToe {

    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        int[][] board=new int[3][3];

        int game_stat=0;
        boolean player_one_turn=true;
        while(game_stat==0){
            int rowin, colin=0;
            if(player_one_turn){
                System.out.print("Player one: ");
                rowin= stdin.nextInt()-1;
                colin= stdin.nextInt()-1;
                board[rowin][colin]=1;
                player_one_turn=false;
            }
            else{
                System.out.print("Player two: ");
                rowin= stdin.nextInt()-1;
                colin= stdin.nextInt()-1;
                board[rowin][colin]=2;
                player_one_turn=true;
            }
            game_stat=board_state(board);
            if(game_stat==1) System.out.println("Player one win");
            else if(game_stat==2) System.out.println("Player two win");
            else if(game_stat==3) System.out.println("Tie");
            else if(game_stat==0) System.out.println("unfinished");
            board_print(board);
        }

    }
    public static int board_state(int[][] board){
        //check row
        for(int i=0;i<board.length;i++){
            boolean match_row=true;
            int value=board[i][0];
            for(int j=0;j<board[i].length;j++){
                if(value!=board[i][j]) match_row=false;
            }
            if(match_row){
                if(board[i][0]==1) return 1;
                if(board[i][0]==2) return 2;
            }
        }

        //check col
        for(int i=0;i<board.length;i++){
            boolean match_col=true;
            int value=board[0][i];
            for(int j=0;j<board[i].length;j++){
                if(value!=board[j][i]) match_col=false;
            }
            if(match_col){
                if(board[0][i]==1) return 1;
                if(board[0][i]==2) return 2;
            }
        }

        //check major diagonal
        int value=board[0][0];
        if(value==board[1][1]&&value==board[2][2]){
            if(board[0][0]==1) return 1;
            else if(board[0][0]==2) return 2;
        }

        //check minor diagonal
        int valueminor=board[0][2];
        if(valueminor==board[1][1]&&valueminor==board[2][0]){
            if(board[0][2]==1) return 1;
            else if(board[0][2]==2) return 2;
        }

        //check full
        boolean full=true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
              if (board[i][j]==0) full=false;
            }
        }
        if(full) return 3;


        return 0;
    }
    public static void board_print(int[][] board){
        char letter;
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                letter='-';
                if(board[i][j]==1) letter='X';
                else if(board[i][j]==2) letter='O';
                System.out.print(letter+" ");
            }
            System.out.println();
        }
    }
}
