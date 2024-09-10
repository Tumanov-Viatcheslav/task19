import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Chess {
    public static void main(String[] args) {
        int numberOfChoices = 0;
        String buffer = "", queenPosition, rookPosition, horsemanPosition;
        String[] inputValues;
        boolean[][] chessBoard = {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}
        };

        // https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = input.readLine()) != null) {
                buffer += line;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        inputValues = buffer.split(" ");
        queenPosition = inputValues[0];
        rookPosition = inputValues[1];
        horsemanPosition = inputValues[2];
        int[] queenPositionMatrix = {(int)queenPosition.charAt(0) - (int)'A', (int)queenPosition.charAt(1) - (int)'1'},
                rookPositionMatrix = {(int)rookPosition.charAt(0) - (int)'A', (int)rookPosition.charAt(1) - (int)'1'},
                horsemanPositionMatrix = {(int)horsemanPosition.charAt(0) - (int)'A', (int)horsemanPosition.charAt(1) - (int)'1'};
        Queen queen = new Queen(queenPositionMatrix[0], queenPositionMatrix[1]);
        queen.eat(chessBoard);
        Rook rook = new Rook(rookPositionMatrix[0], rookPositionMatrix[1]);
        rook.eat(chessBoard);
        Horseman horseman = new Horseman(horsemanPositionMatrix[0], horsemanPositionMatrix[1]);
        horseman.eat(chessBoard);
        chessBoard[queenPositionMatrix[0]][queenPositionMatrix[1]] = false;
        chessBoard[rookPositionMatrix[0]][rookPositionMatrix[1]] = false;
        chessBoard[horsemanPositionMatrix[0]][horsemanPositionMatrix[1]] = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j])
                    numberOfChoices++;
            }
        }

        try(FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(numberOfChoices));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
