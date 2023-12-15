package ChessSpring;

import ChessSpring.BoardService;
import ChessSpring.pieces.Piece;
import ChessSpring.pieces.Position;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Tag(name = "controller for chess board")
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
        this.boardService.setNewGame();
    }

    @Operation(summary = "lists every piece on the board")
    @GetMapping
    public ResponseEntity<Map<Integer, Piece>> getBoard(){
        Map<Integer, Piece> board = boardService.getPieceMap();
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @Operation(summary = "lists every movable position for given piece")
    @GetMapping("/{pos}/move")
    public ResponseEntity<List<Position>> getMovable (@PathVariable Integer pos){
        List<Position> movableList = boardService.getMovablePiece(new Position(pos));
        return ResponseEntity.status(HttpStatus.OK).body(movableList);
    }
    @Operation(summary = "lists every beatable position for given piece")
    @GetMapping("/{pos}/beat")
    public ResponseEntity<List<Position>> getBeatable (@PathVariable Integer pos){
        List<Position> beatableList = boardService.getBeatablePiece(new Position(pos));
        return ResponseEntity.status(HttpStatus.OK).body(beatableList);
    }

    @Operation(summary = "moves a piece to a given position")
    @PutMapping
    public ResponseEntity<Map<Integer, Piece>> movePiece(@RequestBody MoveDTO moveDTO){
        Position oldP = new Position(moveDTO.getOldPosition());
        Position newP = new Position(moveDTO.getNewPosition());
        System.out.println("old: " + oldP);
        System.out.println("new: " + newP);
        boardService.movePiece(oldP, newP);
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getPieceMap());
    }



}
