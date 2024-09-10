public class Horseman extends ChessPiece{
    public void eat(boolean[][] board) {
        int[] sign = {-1, 1};
        boolean[] isDirect = {true, false};
        for (int xSign: sign) {
            for (int ySign: sign) {
                for (boolean order: isDirect) {
                    if (order &&
                            ((this.x + xSign) < 8) && ((this.x + xSign) >= 0) &&
                            ((this.y + ySign * 2) < 8) && ((this.y + ySign * 2) >= 0)) {
                        board[this.x + xSign][this.y + ySign * 2] = true;
                    }
                    else if (!order &&
                            ((this.x + xSign * 2) < 8) && ((this.x + xSign * 2) >= 0) &&
                            ((this.y + ySign) < 8) && ((this.y + ySign) >= 0)) {
                        board[this.x + xSign * 2][this.y + ySign] = true;
                    }
                }
            }
        }
    }
    public Horseman(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
