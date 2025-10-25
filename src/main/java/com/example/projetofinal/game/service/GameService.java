package com.example.projetofinal.game.service;

import com.example.projetofinal.game.domain.Game;
import com.example.projetofinal.game.domain.Link;
import com.example.projetofinal.game.repository.GameRepository;
import com.example.projetofinal.game.repository.LinkRepository;
import com.example.projetofinal.game.rest.GameDetails;
import com.example.projetofinal.game.rest.GameForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final LinkRepository linkRepository;

    public GameService(GameRepository gameRepository, LinkRepository linkRepository) {
        this.gameRepository = gameRepository;
        this.linkRepository = linkRepository;
    }

    public void addGame(GameForm form) {
        Link link = new Link(form.link());
        link = linkRepository.save(link); // ✅ SALVA PRIMEIRO e obtém a entidade gerenciada
        Game game = new Game(form, link); // ✅ Agora o link já está persistido
        gameRepository.save(game);
    }

    public List<GameDetails> getGames() {
        List<Game> all = gameRepository.findAll();
        return all.stream().map(GameDetails::new).toList();
    }

    public GameDetails getGameById(Long id) {
        return gameRepository.findById(id)
                .map(GameDetails::new)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com id " + id));
    }

    public List<GameDetails> getGamesByCategory(String categoriaParam) {
        System.out.println("Categoria recebida: " + categoriaParam);

        String categoriaNormalizada = normalizeUrlToCategoryName(categoriaParam);
        System.out.println("Categoria normalizada: " + categoriaNormalizada);

        List<Game> games = gameRepository.findByCategoriaIgnoreCase(categoriaNormalizada);
        System.out.println("Jogos encontrados: " + games.size());

        return games.stream()
                .map(GameDetails::new)
                .toList();
    }

    // 🧹 NOVO: método para deletar jogo
    public void deleteGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com id " + id));

        // Deleta o link associado
        if (game.getLink() != null) {
            linkRepository.delete(game.getLink());
        }

        gameRepository.deleteById(id);
    }

    private String normalizeUrlToCategoryName(String urlName) {
        if (urlName == null || urlName.isEmpty()) {
            return "";
        }

        String withSpaces = urlName.toLowerCase().replace("-", " ");
        String[] words = withSpaces.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                if (word.length() <= 3) {
                    result.append(word.toUpperCase());
                } else {
                    result.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1));
                }
            }
        }
        return result.toString();
    }
}