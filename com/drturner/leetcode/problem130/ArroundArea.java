package com.drturner.leetcode.problem130;

/**
 * ClassName: ArroundArea
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/9
 * Version: 1.0
 */
public class ArroundArea {
    /*
    示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
    *
    * */
    /*
    * 这一题我想到的解题思路是先在边缘搜索每一个是O的位置，
    * 针对每一个位置采用递归的方式找出其连通的区域，这里将连通的
    * 区域内用“K”表示，那么在完成之后所有标示为K的区域应该是最终剩下来的O，
    * 而未处理的O则是应该被替换为X的
    * */
    public void dye(char[][] board,int startR,int startC){
        if (startR<0||startR>board.length-1||startC<0||startC>board[0].length-1) return;
        board[startR][startC]='K';
        if (startR+1<board.length&&board[startR+1][startC]=='O'){
            dye(board, startR+1, startC);
        }
        if (startR-1>=0&&board[startR-1][startC]=='O'){
            dye(board, startR-1, startC);
        }
        if (startC-1>=0&&board[startR][startC-1]=='O'){
            dye(board, startR, startC-1);
        }
        if (startC+1<board[0].length&&board[startR][startC+1]=='O'){
            dye(board, startR, startC+1);
        }
    }
    public void solve(char[][] board) {
        if (board==null||board.length<1||board[0].length<1) return;
        int row = board.length;
        int col = board[0].length;
        int startR=0;
        int endR=row-1;
        int startC=0;
        int endC=col-1;
        if (startR==endR){
            for (int i=startC;i<=endC;i++){
                if (board[startR][i]=='O'){
                    dye(board,startR,i);
                   // board[startR][i]='K';
                }
            }
        }
        if (startC==endC){
            for (int i=startR;i<=endR;i++){
                if (board[i][endC]=='O'){
                    dye(board,i,endC);
                    //    board[i][endC]='K';
                }
            }
        }

        for (int i=startC;i<endC;i++){
            if (board[startR][i]=='O'){
              //      board[startR][i]='K';
                dye(board,startR,i);
            }
        }
        for (int i=startR;i<endR;i++){
            if (board[i][endC]=='O'){
             //       board[i][endC]='K';
                dye(board,i,endC);
            }
        }
        for (int i=endC;i>startC;i--){
            if (board[endR][i]=='O'){
                dye(board,endR,i);
                 //   board[endR][i]='K';
            }
        }
        for (int i=endR;i>startR;i--){
            if (board[i][startC]=='O'){
                dye(board,i,startC);
                //   board[i][startC]='K';
            }
        }
    //    solveSub(board, startR+1, startC+1, endR-1, endC-1);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='K'||board[i][j]=='O'){
                    if (board[i][j]=='K'){
                        board[i][j]='O';
                    }
                    else {
                        board[i][j]='X';
                    }
                }
            }
        }
    //    System.out.println("  ");
    }

    public static void main(String[] args) {
        ArroundArea arroundArea = new ArroundArea();
        String s="OXXOX XOOXO XOXOX OXOOO XXOXO";
        String[] split = s.split(" ");
        char [][] board=new char[split.length][split[0].length()];
        for (int i=0;i<split.length;i++){
            board[i]=split[i].toCharArray();
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("==================");
       // char [][] board={{}};
        arroundArea.solve(board);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
