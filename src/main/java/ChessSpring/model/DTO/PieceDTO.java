package ChessSpring.model.DTO;

import ChessSpring.pieces.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PieceDTO {
    private Piece.Team team;
    private Piece.Type type;
    private Integer position;

    public PieceDTO(Piece piece){
        this.team = piece.getTeam();
        this.type = piece.getType();
        this.position = (new PositionDTO(piece.getPosition())).getPosition();
    }
}
