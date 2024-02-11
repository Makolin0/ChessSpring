package ChessSpring.controllers;

import ChessSpring.Converters;
import ChessSpring.model.DTO.MoveDTO;
import ChessSpring.model.DTO.PieceDTO;
import ChessSpring.pieces.Piece;
import ChessSpring.model.Position;
import ChessSpring.services.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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
    public ResponseEntity<List<PieceDTO>> getBoard(){
        Map<Integer, Piece> boardMap = boardService.getPieceMap();
        List<PieceDTO> boardList = Converters.pieceToList(boardMap);
        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @Operation(summary = "returns current active player")
    @GetMapping("/current")
    public ResponseEntity<Piece.Team> getActivePlayer(){
        Piece.Team activePlayer = boardService.getActivePlayer();
        return ResponseEntity.status(HttpStatus.OK).body(activePlayer);
    }

    @Operation(summary = "lists every movable position for given piece")
    @GetMapping("/{pos}/move")
    public ResponseEntity<List<Integer>> getMovable (@PathVariable Integer pos){
        List<Position> movableList = boardService.getMovablePiece(new Position(pos));
        List<Integer> movableListDTO = Converters.positionListToDTO(movableList);
//        System.out.println("list for: " + pos);
//        System.out.println(movableListDTO);
        return ResponseEntity.status(HttpStatus.OK).body(movableListDTO);
    }
    @Operation(summary = "lists every beatable position for given piece")
    @GetMapping("/{pos}/beat")
    public ResponseEntity<List<Integer>> getBeatable (@PathVariable Integer pos){
        List<Position> beatableList = boardService.getBeatablePiece(new Position(pos));
        List<Integer> beatableListDTO = Converters.positionListToDTO(beatableList);
        return ResponseEntity.status(HttpStatus.OK).body(beatableListDTO);
    }

    @Operation(summary = "moves a piece to a given position")
    @PutMapping
    public ResponseEntity<List<PieceDTO>> movePiece(@RequestBody MoveDTO moveDTO){
        Position oldP = new Position(moveDTO.getOldP());
        Position newP = new Position(moveDTO.getNewP());
//        System.out.println("old: " + oldP + " - " + moveDTO.getOldP());
//        System.out.println("new: " + newP + " - " + moveDTO.getNewP());
        boardService.movePiece(oldP, newP);
        List<PieceDTO> board = Converters.pieceToList(boardService.getPieceMap());
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }



}
