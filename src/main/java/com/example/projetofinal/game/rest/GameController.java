package com.example.projetofinal.game.rest;

import com.example.projetofinal.game.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public void createGame(@RequestBody @Valid GameForm form) {
        gameService.addGame(form);
    }

    @GetMapping
    public List<GameDetails> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/{id}")
    public GameDetails getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<GameDetails> getGamesByCategory(@PathVariable String categoria) {
        return gameService.getGamesByCategory(categoria);
    }

    // 🧹 NOVO: deletar jogo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGameById(id);
        return ResponseEntity.noContent().build();
    }
}