package ChessSpring.services;

import ChessSpring.model.Position;
import ChessSpring.pieces.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
public class BoardService {
    private Map<Integer, Piece> pieceMap;
    private Piece.Team activePlayer;

    public BoardService(){
        pieceMap = new HashMap<>();
        activePlayer = Piece.Team.WHITE;
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
        pieceMap.put(0, new Rook(Piece.Team.WHITE, new Position(0)));
        pieceMap.put(7, new Rook(Piece.Team.WHITE, new Position(7)));
        pieceMap.put(56, new Rook(Piece.Team.BLACK, new Position(56)));
        pieceMap.put(63, new Rook(Piece.Team.BLACK, new Position(63)));

        pieceMap.put(2, new Bishop(Piece.Team.WHITE, new Position(2)));
        pieceMap.put(5, new Bishop(Piece.Team.WHITE, new Position(5)));
        pieceMap.put(58, new Bishop(Piece.Team.BLACK, new Position(58)));
        pieceMap.put(61, new Bishop(Piece.Team.BLACK, new Position(61)));

        pieceMap.put(1, new Knight(Piece.Team.WHITE, new Position(1)));
        pieceMap.put(6, new Knight(Piece.Team.WHITE, new Position(6)));
        pieceMap.put(57, new Knight(Piece.Team.BLACK, new Position(57)));
        pieceMap.put(62, new Knight(Piece.Team.BLACK, new Position(62)));

        pieceMap.put(3, new Queen(Piece.Team.WHITE, new Position(3)));
        pieceMap.put(59, new Queen(Piece.Team.BLACK, new Position(59)));

        pieceMap.put(4, new King(Piece.Team.WHITE, new Position(4)));
        pieceMap.put(60, new King(Piece.Team.BLACK, new Position(60)));
    }

    public void movePiece(Position oldPosition, Position newPosition){
        Piece movingPiece = pieceMap.get(oldPosition.getInt());
        if(Objects.nonNull(movingPiece)){
            System.out.println("znaleziono pion");
            List<Position> movable = movingPiece.getMovableList(pieceMap);
            List<Position> beatable = movingPiece.getBeatableList(pieceMap);
            System.out.println("move " + movable);
            System.out.println("beat " + beatable);
            System.out.println("ruch do: " + newPosition);
            if(beatable.contains(newPosition)){
                System.out.println("można zbić");
                beatPiece(oldPosition, newPosition);
                if(activePlayer == Piece.Team.WHITE) {
                    activePlayer = Piece.Team.BLACK;
                }
                else {
                    activePlayer = Piece.Team.WHITE;
                }
            }
            else if(movable.contains(newPosition)){
                System.out.println("mozna sie ruszyc");
                movingPiece.setPosition(newPosition);
                pieceMap.put(newPosition.getInt(), movingPiece);
                pieceMap.remove(oldPosition.getInt());
            }
        }

        if(activePlayer == Piece.Team.WHITE){
            activePlayer = Piece.Team.BLACK;
        } else {
            activePlayer = Piece.Team.WHITE;
        }
    }

    public void beatPiece(Position myPosition, Position beatPosition){
        Piece movingPiece = pieceMap.get(myPosition.getInt());
        Piece beatingPiece = pieceMap.get(beatPosition.getInt());
        if(Objects.nonNull(movingPiece) && Objects.nonNull(beatingPiece)){
            pieceMap.replace(beatingPiece.getPosition().getInt(), movingPiece);
            pieceMap.remove(movingPiece.getPosition().getInt());
            movingPiece.setPosition(beatPosition);
            if(activePlayer == Piece.Team.WHITE) {
                activePlayer = Piece.Team.BLACK;
            }
            else {
                activePlayer = Piece.Team.WHITE;
            }

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
