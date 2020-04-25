package game.dao;

import game.model.Game;

import java.util.List;

public interface GameDAO {
    List<Game> allGames(int id_user);
    void delete(Game game);
    void add(Game game);
    Game getById(int id);

}
