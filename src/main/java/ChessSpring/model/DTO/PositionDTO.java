package ChessSpring.model.DTO;

import ChessSpring.model.Position;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO {
    private int x;
    private int y;

    public PositionDTO(Position position){
        this.x = position.getX();
        this.y = position.getY();
    }

    public Integer getPosition() {
        return y*8 + x;
    }

}
