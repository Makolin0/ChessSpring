package ChessSpring.pieces;

import ChessSpring.model.DTO.PieceDTO;
import ChessSpring.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class King implements Piece{

    private final Team team;
    private final Type type;

    private Position position;

    public King(Team team,  Position position){
        this.team = team;
        this.type = Type.KING;
        this.position = position;
    }
    public King(PieceDTO pieceDTO){
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

        int xLeft = position.getX() - 1;
        int xRight = position.getX() + 1;
        int yDown = position.getY() - 1;
        int yUp = position.getY() + 1;
        if(xLeft >= 0){
            if(!allPieces.containsKey(position.getY() * 8 + xLeft)){
                movableSquares.add(new Position(xLeft, position.getY()));
            }
            if(yDown >= 0){
                if(!allPieces.containsKey(yDown * 8 + xLeft)){
                    movableSquares.add(new Position(xLeft, yDown));
                }
            }
            if(yUp < 8){
                if(!allPieces.containsKey(yUp * 8 + xLeft)){
                    movableSquares.add(new Position(xLeft, yUp));
                }
            }
        }
        if(xRight < 8){
            if(!allPieces.containsKey(position.getY() * 8 + xRight)){
                movableSquares.add(new Position(xRight, position.getY()));
            }
            if(yDown >= 0){
                if(!allPieces.containsKey(yDown * 8 + xRight)){
                    movableSquares.add(new Position(xRight, yDown));
                }
            }
            if(yUp < 8){
                if(!allPieces.containsKey(yUp * 8 + xRight)){
                    movableSquares.add(new Position(xRight, yUp));
                }
            }
        }
        if(yDown >= 0){
            if(!allPieces.containsKey(yDown * 8 + position.getX())){
                movableSquares.add(new Position(position.getX(), yDown));
            }
        }
        if(yUp < 8){
            if(!allPieces.containsKey(yUp * 8 + position.getX())){
                movableSquares.add(new Position(position.getX(), yUp));
            }
        }

        return movableSquares;
    }

    @Override
    public List<Position> getBeatableList(Map<Integer, Piece> allPieces) {
        List<Position> beatableSquares = new ArrayList<>();


        int xLeft = position.getX() - 1;
        int xRight = position.getX() + 1;
        int yDown = position.getY() - 1;
        int yUp = position.getY() + 1;
        if(xLeft >= 0){
            if(allPieces.containsKey(position.getY() * 8 + xLeft)){
                if(allPieces.get(position.getY() * 8 + xLeft).getTeam() != team)
                    beatableSquares.add(new Position(xLeft, position.getY()));
            }
            if(yDown >= 0){
                if(allPieces.containsKey(yDown * 8 + xLeft)){
                    if(allPieces.get(yDown * 8 + xLeft).getTeam() != team)
                        beatableSquares.add(new Position(xLeft, yDown));
                }
            }
            if(yUp < 8){
                if(allPieces.containsKey(yUp * 8 + xLeft)){
                    if(allPieces.get(yUp * 8 + xLeft).getTeam() != team)
                        beatableSquares.add(new Position(xLeft, yUp));
                }
            }
        }
        if(xRight < 8){
            if(allPieces.containsKey(position.getY() * 8 + xRight)){
                if(allPieces.get(position.getY() * 8 + xRight).getTeam() != team)
                    beatableSquares.add(new Position(xRight, position.getY()));
            }
            if(yDown >= 0){
                if(allPieces.containsKey(yDown * 8 + xRight)){
                    if(allPieces.get(yDown * 8 + xRight).getTeam() != team)
                        beatableSquares.add(new Position(xRight, yDown));
                }
            }
            if(yUp < 8){
                if(allPieces.containsKey(yUp * 8 + xRight)){
                    if(allPieces.get(yUp * 8 + xRight).getTeam() != team)
                        beatableSquares.add(new Position(xRight, yUp));
                }
            }
        }
        if(yDown >= 0){
            if(allPieces.containsKey(yDown * 8 + position.getX())){
                if(allPieces.get(yDown * 8 + position.getX()).getTeam() != team)
                    beatableSquares.add(new Position(position.getX(), yDown));
            }
        }
        if(yUp < 8){
            if(allPieces.containsKey(yUp * 8 + position.getX())){
                if(allPieces.get(yUp * 8 + position.getX()).getTeam() != team)
                    beatableSquares.add(new Position(position.getX(), yUp));
            }
        }

        return beatableSquares;
    }
}
