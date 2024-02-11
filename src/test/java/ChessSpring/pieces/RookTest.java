package ChessSpring.pieces;

import ChessSpring.model.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    void testMovableAndBeatableList() {
        // create pawns
        Map<Integer, Piece> piecesMap = new HashMap<>();
        Rook rookTestW = new Rook(Piece.Team.WHITE, new Position(4, 4));
        Rook rookTestB = new Rook(Piece.Team.BLACK, new Position(5, 6));
        Rook rookB1 = new Rook(Piece.Team.BLACK, new Position(5, 5));
        Rook rookB2 = new Rook(Piece.Team.BLACK, new Position(3, 5));
        Rook rookW1 = new Rook(Piece.Team.WHITE, new Position(4, 5));

        // add checked pawns to list
        piecesMap.put(rookTestB.getPosition().getInt(), rookTestB);
        piecesMap.put(rookTestW.getPosition().getInt(), rookTestW);

        // create expected movable list without pawns
        List<Position> expectedNoPawnsW = new ArrayList<>();
        expectedNoPawnsW.add(new Position(4,5));
        List<Position> expectedNoPawnsB = new ArrayList<>();
        expectedNoPawnsB.add(new Position(5, 5));
        expectedNoPawnsB.add(new Position(5, 4));

        // check movable on empty board
        assertEquals(expectedNoPawnsW, rookTestW.getMovableList(piecesMap));
        assertEquals(expectedNoPawnsB, rookTestB.getMovableList(piecesMap));

        // add rest of pawns
        piecesMap.put(rookB1.getPosition().getInt(),rookB1);
        piecesMap.put(rookB2.getPosition().getInt(),rookB2);
        piecesMap.put(rookW1.getPosition().getInt(),rookW1);

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
        assertEquals(expectedW, rookTestW.getMovableList(piecesMap));
        assertEquals(expectedB, rookTestB.getMovableList(piecesMap));
        // check beatable on board
        assertEquals(expectedBeatableW, rookTestW.getBeatableList(piecesMap));
        assertEquals(expectedBeatableB, rookTestB.getBeatableList(piecesMap));



    }
}