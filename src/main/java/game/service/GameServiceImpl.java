package game.service;

import game.dao.GameDAO;
import game.dao.ResultDAO;
import game.model.Game;
import game.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private GameDAO gameDAO;
    private ResultDAO resultDAO;

    @Autowired
    public void setGameDAO(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Autowired
    public void setResultDAO(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Transactional
    public List<Game> allGames(int id_user) {
        return gameDAO.allGames(id_user);
    }

    @Transactional
    public void add(Game game) {
        gameDAO.add(game);
    }

    @Transactional
    public void delete(Game game) {
        gameDAO.delete(game);
    }

    @Transactional
    public Game getById(int id) {
        return gameDAO.getById(id);
    }

    @Transactional
    public void add(Result result)
    {
        resultDAO.add(result);
    }

    @Transactional
    public List<Result> allResults(int id_game)
    {
        return resultDAO.allResults(id_game);
    }
}
