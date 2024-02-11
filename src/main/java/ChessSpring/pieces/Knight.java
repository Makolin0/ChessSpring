package ChessSpring.pieces;

import ChessSpring.model.DTO.PieceDTO;
import ChessSpring.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Knight implements Piece{

    private final Team team;
    private final Type type;

    private Position position;

    public Knight(Team team,  Position position){
        this.team = team;
        this.type = Type.KNIGHT;
        this.position = position;
    }
    public Knight(PieceDTO pieceDTO){
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

        if(position.getX() < 6 && position.getY() >= 1) {
            if (!allPieces.containsKey(position.getInt() - 6)) {
                    movableSquares.add(new Position(position.getInt() - 6));

            }
        }
        if(position.getX() >= 2 && position.getY() >= 1) {
            if (!allPieces.containsKey(position.getInt() - 10)) {
                    movableSquares.add(new Position(position.getInt() - 10));

            }
        }
        if(position.getX() < 7 && position.getY() >= 2) {
            if (!allPieces.containsKey(position.getInt() - 15)) {
                    movableSquares.add(new Position(position.getInt() - 15));

            }
        }
        if(position.getX() >= 1 && position.getY() >= 2){
            if(!allPieces.containsKey(position.getInt() - 17)){
                    movableSquares.add(new Position(position.getInt() - 17));

            }
        }
        if(position.getX() >= 2 && position.getY() <= 6) {
            if (!allPieces.containsKey(position.getInt() + 6)) {
                    movableSquares.add(new Position(position.getInt() + 6));

            }
        }
        if(position.getX() <= 5 && position.getY() <= 6) {
            if (!allPieces.containsKey(position.getInt() + 10)) {
                    movableSquares.add(new Position(position.getInt() + 10));

            }
        }
        if(position.getX() >= 1 && position.getY() <= 5) {
            if (!allPieces.containsKey(position.getInt() + 15)) {
                    movableSquares.add(new Position(position.getInt() + 15));

            }
        }
        if(position.getX() <= 6 && position.getY() <= 5){
            if(!allPieces.containsKey(position.getInt() + 17)) {
                    movableSquares.add(new Position(position.getInt() + 17));

            }
        }

        return movableSquares;
    }

    @Override
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces) {
        List<Position> beatableSquares = new ArrayList<>();

        if(position.getX() < 6 && position.getY() >= 1) {
            if (allPieces.containsKey(position.getInt() - 6)) {
                if (allPieces.get(position.getInt() - 6).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() - 6));
                }
            }
        }
        if(position.getX() >= 2 && position.getY() >= 1) {
            if (allPieces.containsKey(position.getInt() - 10)) {
                if (allPieces.get(position.getInt() - 10).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() - 10));
                }
            }
        }
        if(position.getX() < 7 && position.getY() >= 2) {
            if (allPieces.containsKey(position.getInt() - 15)) {
                if (allPieces.get(position.getInt() - 15).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() - 15));
                }
            }
        }
        if(position.getX() >= 1 && position.getY() >= 2){
            if(allPieces.containsKey(position.getInt() - 17)){
                if(allPieces.get(position.getInt() - 17).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() - 17));
                }
            }
        }
        if(position.getX() >= 2 && position.getY() <= 6) {
            if (allPieces.containsKey(position.getInt() + 6)) {
                if (allPieces.get(position.getInt() + 6).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() + 6));
                }
            }
        }

        // POZAMIENIAC SRODKOWY IF

        if(position.getX() <= 5 && position.getY() <= 6) {
            if (allPieces.containsKey(position.getInt() + 10)) {
                if (allPieces.get(position.getInt() + 10).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() + 10));
                }
            }
        }
        if(position.getX() >= 1 && position.getY() <= 5) {
            if (allPieces.containsKey(position.getInt() + 15)) {
                if (allPieces.get(position.getInt() + 15).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() + 15));
                }
            }
        }
        if(position.getX() <= 6 && position.getY() <= 5){
            if(allPieces.containsKey(position.getInt() + 17)) {
                if (allPieces.get(position.getInt() + 17).getTeam() != team) {
                    beatableSquares.add(new Position(position.getInt() + 17));
                }
            }
        }


        return beatableSquares;
    }
}
