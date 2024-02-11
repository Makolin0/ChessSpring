package ChessSpring;

import ChessSpring.pieces.Pawn;
import ChessSpring.pieces.Piece;
import ChessSpring.model.Position;
import ChessSpring.services.BoardService;
import org.junit.jupiter.api.Test;

class BoardServiceTest {

    @Test
    void movePiece() {
    }

    @Test
    void beatPiece() {
        BoardService boardService = new BoardService();

        Pawn pawnW = new Pawn(Piece.Team.WHITE, new Position(4, 4));
        Pawn pawnB = new Pawn(Piece.Team.BLACK, new Position(5, 6));

        Pawn pawnB1 = new Pawn(Piece.Team.BLACK, new Position(5, 5));
        Pawn pawnB2 = new Pawn(Piece.Team.BLACK, new Position(3, 5));
        Pawn pawnB3 = new Pawn(Piece.Team.BLACK, new Position(7, 7));
        Pawn pawnW1 = new Pawn(Piece.Team.WHITE, new Position(4, 5));


        System.out.println("adding pawns");
        boardService.setPiece(pawnB1);
        boardService.setPiece(pawnB2);
        boardService.setPiece(pawnB3);
        boardService.setPiece(pawnW1);
        boardService.setPiece(pawnW);
        boardService.setPiece(pawnB);

        System.out.println(boardService);

        boardService.movePiece(new Position(4, 4), new Position(3, 5));

        System.out.println(boardService);

    }
}