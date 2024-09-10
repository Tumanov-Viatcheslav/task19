public class Rook extends ChessPiece{
    public Rook(int x, int y) {
        super(x, y);
    }

    public void eat(boolean[][] board) {
        for (int i = 0; i < 8; i++) {
            board[this.x][i] = true;
            board[i][this.y] = true;
        }
    }

    //public Rook(int x, int y) {
    //    this.x = x;
    //    this.y = y;
    //}
}
