package ChessSpring.controllers;

import ChessSpring.model.AuthenticationResponse;
import ChessSpring.model.DTO.LoginDTO;
import ChessSpring.model.DTO.RegisterDTO;
import ChessSpring.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "controller for authentication")
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @Operation(summary = "registration endpoint")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDTO request) {
        return ResponseEntity.ok(service.register(request));
    }

    @Operation(summary = "login endpoint")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginDTO request) {
        return ResponseEntity.ok(service.login(request));
    }
}
