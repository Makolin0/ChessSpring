package ChessSpring.pieces;

import ChessSpring.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pawn implements Piece{
    private final Team team;
    private final Type type;

    private Position position;

    public Pawn(Team team,  Position position){
        this.team = team;
        this.type = Type.PAWN;
        this.position = position;
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
        switch (team){
            case WHITE -> {
                if(position.getY() > 6)
                    return movableSquares;

                if(Objects.isNull(allPieces.get(position.getInt()+8))) {
                    movableSquares.add(new Position(position.getX(), position.getY() + 1));
                } else {return movableSquares;}
                if(position.getY()==1)
                    if(Objects.isNull(allPieces.get(position.getInt()+16)))
                        movableSquares.add(new Position(position.getX(), 3));
            }
            case BLACK -> {
                if(position.getY() < 1)
                    return movableSquares;

                if(Objects.isNull(allPieces.get(position.getInt()-8))) {
                    movableSquares.add(new Position(position.getX(), position.getY() - 1));
                } else {return movableSquares;}
                if(position.getY()==6)
                    if(Objects.isNull(allPieces.get(position.getInt()-16)))
                        movableSquares.add(new Position(position.getX(), 4));
            }
        }
        return movableSquares;
    }

    @Override
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces) {
        List<Position> beatableSquares = new ArrayList<>();
        switch (team){
            case WHITE -> {
                Piece checkLeft = allPieces.get(position.getInt()+7);
                Piece checkRight = allPieces.get(position.getInt()+9);
                if(!Objects.isNull(checkLeft) && checkLeft.getTeam()==Team.BLACK)
                    beatableSquares.add(new Position(position.getInt()+7));
                if(!Objects.isNull(checkRight) && checkRight.getTeam()==Team.BLACK)
                    beatableSquares.add(new Position(position.getInt()+9));
            }
            case BLACK -> {
                Piece checkLeft = allPieces.get(position.getInt()-9);
                Piece checkRight = allPieces.get(position.getInt()-7);
                if(!Objects.isNull(checkLeft) && checkLeft.getTeam()==Team.WHITE)
                    beatableSquares.add(new Position(position.getInt()-9));
                if(!Objects.isNull(checkRight) && checkRight.getTeam()==Team.WHITE)
                    beatableSquares.add(new Position(position.getInt()-7));
            }
        }
        return beatableSquares;
    }

}
