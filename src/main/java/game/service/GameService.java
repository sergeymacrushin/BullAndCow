package game.service;

import game.model.Game;
import game.model.Result;

import java.util.List;

public interface GameService {
    List<Game> allGames(int id_user);
    List<Result> allResults(int id_game);
    void delete(Game game);
    void add(Game game);
    Game getById(int id);
    void add(Result result);

}
