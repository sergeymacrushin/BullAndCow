package game.dao;

import game.model.Result;

import java.util.List;

public interface ResultDAO {
    void add(Result result);
    List<Result> allResults(int id_game);
}
