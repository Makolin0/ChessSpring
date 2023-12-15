package ChessSpring;

import ChessSpring.pieces.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDTO {
    PositionDTO oldPosition;
    PositionDTO newPosition;
}
