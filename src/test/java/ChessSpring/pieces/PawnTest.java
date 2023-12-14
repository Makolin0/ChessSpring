package ChessSpring.pieces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void getMovableSquares() {
        Pawn pawnW = new Pawn(Piece.Team.WHITE, new Position(4, 4));
        Pawn pawnB = new Pawn(Piece.Team.BLACK, new Position(5, 6));

        System.out.println(pawnW.getMovableSquares(new HashMap<>()));
        System.out.println(pawnB.getMovableSquares(new HashMap<>()));

        List<Position> expectedW = new ArrayList<>();
        expectedW.add(new Position(4, 5));
        List<Position> expectedB = new ArrayList<>();
        expectedB.add(new Position(5, 5));
        expectedB.add(new Position(5, 4));

        //assertEquals(expectedW, pawnW.getMovableSquares(new HashMap<>()));
        //assertEquals(expectedB, pawnB.getMovableSquares(new HashMap<>()));
    }

    @Test
    void getBeatableList() {
    }

    @Test
    void move() {
    }
}