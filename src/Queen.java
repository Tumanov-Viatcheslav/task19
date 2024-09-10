public class Queen extends ChessPiece{
    public void eat(boolean[][] board) {
        for (int i = 0; i < 8; i++) {
            board[this.x][i] = true;
            board[i][this.y] = true;
            if ((this.x + this.y) < 8 && (this.x + this.y - i) >= 0)
                board[i][this.x + this.y - i] = true;
            if ((this.y - this.x + i) >= 0)
                board[i][this.y - this.x + i] = true;
        }
    }

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
