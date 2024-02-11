package ChessSpring;

import ChessSpring.model.DTO.PieceDTO;
import ChessSpring.model.DTO.PositionDTO;
import ChessSpring.pieces.Piece;
import ChessSpring.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Converters {
    public static List<PieceDTO> pieceToList (Map<Integer, Piece> pieceMap){
        List<PieceDTO> pieceList = new ArrayList<>();

        for(Piece piece : pieceMap.values()){
            pieceList.add(new PieceDTO(piece));
        }
        return pieceList;
    }

    public static List<Integer> positionListToDTO(List<Position> positionList){
        List<Integer> positionDTOList = new ArrayList<>();

        for(Position position : positionList){
            positionDTOList.add((new PositionDTO(position)).getPosition());
        }
        return positionDTOList;
    }

}
