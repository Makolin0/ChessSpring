package ChessSpring;

import ChessSpring.pieces.Pawn;
import ChessSpring.pieces.Piece;
import ChessSpring.pieces.Position;
import org.hibernate.dialect.SybaseSqlAstTranslator;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BoardService {
    private Map<Integer, Piece> pieceMap;

    public BoardService(){
        pieceMap = new HashMap<>();
    }
    public Map<Integer, Piece> getPieceMap() {
        return pieceMap;
    }

    public void setPiece(Piece piece){
        pieceMap.put(piece.getPosition().getInt(), piece);
    }
    public Piece getPiece(Position position){
        return pieceMap.get(position);
    }
    public List<Position> getMovablePiece(Position position){
        Piece piece = pieceMap.get(position.getInt());
        if(Objects.nonNull(piece))
            return piece.getMovableList(pieceMap);
        else
            return new ArrayList<>();
    }
    public List<Position> getBeatablePiece(Position position){
        Piece piece = pieceMap.get(position.getInt());
        if(Objects.nonNull(piece))
            return piece.getBeatableList(pieceMap);
        else
            return new ArrayList<>();
    }

    public void setNewGame(){
        pieceMap.clear();
        for(int x = 0; x < 8; x++){
            Piece pieceW = new Pawn(Piece.Team.WHITE,new Position(x, 1));
            Piece pieceB = new Pawn(Piece.Team.BLACK,new Position(x, 6));
            pieceMap.put(pieceW.getPosition().getInt(), pieceW);
            pieceMap.put(pieceB.getPosition().getInt(), pieceB);
        }
    }

    public void movePiece(Position oldPosition, Position newPosition){
        Piece movingPiece = pieceMap.get(oldPosition.getInt());
        if(Objects.nonNull(movingPiece)){
            System.out.println("znaleziono pion");
            List<Position> movable = movingPiece.getMovableList(pieceMap);
            System.out.println(movable);
            System.out.println("ruch do: " + newPosition);
            if(movable.contains(newPosition)){
                System.out.println("mozna sie ruszyc");
                movingPiece.setPosition(newPosition);
                pieceMap.put(newPosition.getInt(), movingPiece);
                pieceMap.remove(oldPosition.getInt());
            }
        }
    }

    public void beatPiece(Position myPosition, Position beatPosition){
        Piece movingPiece = pieceMap.get(myPosition.getInt());
        Piece beatingPiece = pieceMap.get(beatPosition.getInt());
        if(Objects.nonNull(movingPiece) && Objects.nonNull(beatingPiece)){
            pieceMap.replace(beatingPiece.getPosition().getInt(), movingPiece);
            pieceMap.remove(movingPiece.getPosition().getInt());
            movingPiece.setPosition(beatPosition);

        }

    }

    @Override
    public String toString() {
        String board = "";

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                Piece piece = pieceMap.get(y*8+x);
                board = board + (Objects.isNull(piece) ? " __ " : (piece.getTeam() == Piece.Team.WHITE ? " wp " : " bp "));
            }
            board = board + "\n";
        }
        return board;
    }
}
