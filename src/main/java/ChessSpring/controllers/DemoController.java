package ChessSpring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "controller for tests")
@Controller
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/user")
    @Operation(summary = "tests if user is logged in")
    public ResponseEntity<String> authenticated() {
        return ResponseEntity.ok("hello from secured endpoint");
    }

    @GetMapping("/everyone")
    @Operation(summary = "returns string for everyone")
    public ResponseEntity<String> everyone() {
        return ResponseEntity.ok("hello from public endpoint");
    }

}
