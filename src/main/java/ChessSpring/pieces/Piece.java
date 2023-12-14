package ChessSpring.pieces;

import java.util.List;
import java.util.Map;

public interface Piece {
    public enum Team{
        WHITE, BLACK;
    }

    public List<Position> getMovableSquares(Map<Integer, Piece> allPieces);
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces);
    public void move(Position coordinates);
}
