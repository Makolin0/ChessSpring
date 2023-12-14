package ChessSpring.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pawn implements Piece{
    private Team team;
    private Position position;

    public Pawn(Team team, Position position){
        this.team = team;
        this.position = position;
    }
    @Override
    public List<Position> getMovableSquares(Map<Integer, Piece> allPieces) {
        List<Position> movableSquares = new ArrayList<>();
        switch (team){
            case WHITE -> {
                if(position.getY()==1)
                    if(Objects.isNull(allPieces.get(position.getPositionInt()+16)))
                        movableSquares.add(new Position(position.getX(), 3));
                if(Objects.isNull(allPieces.get(position.getPositionInt()+8)))
                    movableSquares.add(new Position(position.getX(), position.getY()+1));
            }
            case BLACK -> {
                if(position.getY()==6)
                    if(Objects.isNull(allPieces.get(position.getPositionInt()-16)))
                        movableSquares.add(new Position(position.getX(), 4));
                if(Objects.isNull(allPieces.get(position.getPositionInt()-8)))
                    movableSquares.add(new Position(position.getX(), position.getY()-1));
            }
        }
        return movableSquares;
    }

    @Override
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces) {
        return null;
    }

    @Override
    public void move(Position position) {

    }
}
