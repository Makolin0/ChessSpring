package ChessSpring.pieces;

import ChessSpring.model.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    void testMovableAndBeatableList() {
        // create pawns
        Map<Integer, Piece> piecesMap = new HashMap<>();
        Pawn pawnTestW = new Pawn(Piece.Team.WHITE, new Position(4, 4));
        Pawn pawnTestB = new Pawn(Piece.Team.BLACK, new Position(5, 6));
        Pawn pawnB1 = new Pawn(Piece.Team.BLACK, new Position(5, 5));
        Pawn pawnB2 = new Pawn(Piece.Team.BLACK, new Position(3, 5));
        Pawn pawnW1 = new Pawn(Piece.Team.WHITE, new Position(4, 5));

        // add checked pawns to list
        piecesMap.put(pawnTestB.getPosition().getInt(), pawnTestB);
        piecesMap.put(pawnTestW.getPosition().getInt(), pawnTestW);

        // create expected movable list without pawns
        List<Position> expectedNoPawnsW = new ArrayList<>();
        expectedNoPawnsW.add(new Position(4,5));
        List<Position> expectedNoPawnsB = new ArrayList<>();
        expectedNoPawnsB.add(new Position(5, 5));
        expectedNoPawnsB.add(new Position(5, 4));

        // check movable on empty board
        assertEquals(expectedNoPawnsW, pawnTestW.getMovableList(piecesMap));
        assertEquals(expectedNoPawnsB, pawnTestB.getMovableList(piecesMap));

        // add rest of pawns
        piecesMap.put(pawnB1.getPosition().getInt(),pawnB1);
        piecesMap.put(pawnB2.getPosition().getInt(),pawnB2);
        piecesMap.put(pawnW1.getPosition().getInt(),pawnW1);

        // create expected movable list with pawns (can't move)
        List<Position> expectedW = new ArrayList<>();
        List<Position> expectedB = new ArrayList<>();
        // create expected beatable list with pawns
        List<Position> expectedBeatableW = new ArrayList<>();
        List<Position> expectedBeatableB = new ArrayList<>();
        expectedBeatableW.add(new Position(3, 5));
        expectedBeatableW.add(new Position(5, 5));
        expectedBeatableB.add(new Position(4, 5));

        //check movable on board
        assertEquals(expectedW, pawnTestW.getMovableList(piecesMap));
        assertEquals(expectedB, pawnTestB.getMovableList(piecesMap));
        // check beatable on board
        assertEquals(expectedBeatableW, pawnTestW.getBeatableList(piecesMap));
        assertEquals(expectedBeatableB, pawnTestB.getBeatableList(piecesMap));



    }

    @Test
    void getBeatableList() {
    }

    @Test
    void move() {
    }
}