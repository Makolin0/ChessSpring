package ChessSpring.pieces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PawnTest {

    @Test
    void getMovableSquares() {
        Pawn pawnW = new Pawn(Piece.Team.WHITE, new Position(4, 4));
        Pawn pawnB = new Pawn(Piece.Team.BLACK, new Position(5, 6));

        Pawn pawnB1 = new Pawn(Piece.Team.BLACK, new Position(5, 5));
        Pawn pawnB2 = new Pawn(Piece.Team.BLACK, new Position(3, 5));
        Pawn pawnW1 = new Pawn(Piece.Team.WHITE, new Position(4, 5));
        Map<Integer, Piece> piecesMap = new HashMap<>();

        System.out.println("white move: " + pawnW.getMovableList(piecesMap));
        System.out.println("black move: " + pawnB.getMovableList(piecesMap));
        System.out.println("white beat: " + pawnW.getBeatableList(piecesMap));
        System.out.println("black beat: " + pawnB.getBeatableList(piecesMap));

        System.out.println("adding pawns");
        piecesMap.put(pawnB1.getPosition().getInt(),pawnB1);
        piecesMap.put(pawnB2.getPosition().getInt(),pawnB2);
        piecesMap.put(pawnW1.getPosition().getInt(),pawnW1);

        System.out.println("white move: " + pawnW.getMovableList(piecesMap));
        System.out.println("black move: " + pawnB.getMovableList(piecesMap));
        System.out.println("white beat: " + pawnW.getBeatableList(piecesMap));
        System.out.println("black beat: " + pawnB.getBeatableList(piecesMap));

        List<Position> expectedW = new ArrayList<>();
        expectedW.add(new Position(4, 5));
        List<Position> expectedB = new ArrayList<>();
        expectedB.add(new Position(5, 5));
        expectedB.add(new Position(5, 4));

        //assertEquals(expectedW, pawnW.getMovableSquares(piecesMap));
        //assertEquals(expectedB, pawnB.getMovableSquares(piecesMap));
    }

    @Test
    void getBeatableList() {
    }

    @Test
    void move() {
    }
}