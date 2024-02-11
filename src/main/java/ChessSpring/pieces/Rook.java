package ChessSpring.pieces;

import ChessSpring.model.DTO.PieceDTO;
import ChessSpring.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook implements Piece{

    private final Team team;
    private final Type type;

    private Position position;

    public Rook(Team team,  Position position){
        this.team = team;
        this.type = Type.ROOK;
        this.position = position;
    }
    public Rook(PieceDTO pieceDTO){
        this.team = pieceDTO.getTeam();
        this.type = pieceDTO.getType();
        this.position = new Position(pieceDTO.getPosition());
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }
    @Override
    public Position getPosition(){
        return position;
    }
    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public Type getType(){
        return type;
    }
    @Override
    public List<Position> getMovableList(Map<Integer, Piece> allPieces) {
        List<Position> movableSquares = new ArrayList<>();
        // ruchy w lewo
        for(int y = position.getY() - 1; y >= 0; y--){
            if(allPieces.containsKey(position.getX() + y * 8)){
                break;
            } else {
                movableSquares.add(new Position(position.getX(), y));
            }
        }
        // ruchy w prawo
        for(int y = position.getY() + 1; y < 8; y++){
            if(allPieces.containsKey(position.getX() + y * 8)){
                break;
            } else {
                movableSquares.add(new Position(position.getX(), y));
            }
        }
        // ruchy w gore
        for(int x = position.getX() - 1; x >= 0; x--){
            if(allPieces.containsKey(position.getY() * 8 + x)){
                break;
            } else {
                movableSquares.add(new Position(x, position.getY()));
            }
        }
        // ruchy w dol
        for(int x = position.getX() + 1; x < 8; x++){
            if(allPieces.containsKey(position.getY() * 8 + x)){
                break;
            } else {
                movableSquares.add(new Position(x, position.getY()));
            }
        }
        return movableSquares;
    }

    @Override
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces) {
        List<Position> beatableSquares = new ArrayList<>();

        // ruchy w lewo
        for(int y = position.getY() - 1; y >= 0; y--){
            if(allPieces.containsKey(position.getX() + y * 8)){
                if(allPieces.get(position.getX() + y * 8).getTeam() != team){
                    beatableSquares.add(new Position(position.getX(),y));
                }
                break;
            }
        }
        // ruchy w prawo
        for(int y = position.getY() + 1; y < 8; y++){
            if(allPieces.containsKey(position.getX() + y * 8)){
                if(allPieces.get(position.getX() + y * 8).getTeam() != team){
                    beatableSquares.add(new Position(position.getX(),y));
                }
                break;
            }
        }
        // ruchy w gore
        for(int x = position.getX() - 1; x >= 0; x--){
            if(allPieces.containsKey(position.getY() * 8 + x)){
                if(allPieces.get(position.getY() * 8 + x).getTeam() != team){
                    beatableSquares.add(new Position(x, position.getY()));
                }
                break;
            }
        }
        // ruchy w dol
        for(int x = position.getX() + 1; x < 8; x++){
            if(allPieces.containsKey(position.getY() * 8 + x)){
                if(allPieces.get(position.getY() * 8 + x).getTeam() != team){
                    beatableSquares.add(new Position(x, position.getY()));
                }
                break;
            }
        }

        return beatableSquares;
    }

}
