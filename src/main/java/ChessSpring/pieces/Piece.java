package ChessSpring.pieces;

import java.util.List;
import java.util.Map;

public interface Piece {
    public enum Team{
        WHITE, BLACK;
    }
    public enum Type{
        PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING;
    }

    public void setPosition(Position position);
    public Position getPosition();
    public Team getTeam();
    public Type getType();
    public List<Position> getMovableList(Map<Integer, Piece> allPieces);
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces);
}
