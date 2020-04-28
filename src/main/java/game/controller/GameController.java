package game.controller;

import game.model.Game;
import game.model.Result;
import game.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
    public ModelAndView allGames(@PathVariable("id") int id) {
        List<Game> games = gameService.allGames(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("games");
        modelAndView.addObject("gamesList", games);
        modelAndView.addObject("id_u", id);
        return modelAndView;
    }
    @RequestMapping(value="/deleteGame/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGame(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Game game = gameService.getById(id);
        gameService.delete(game);
        modelAndView.setViewName( "redirect:/games/"+game.getId_user());
        return modelAndView;
    }


    @RequestMapping(value = "/addGame/{id_u}", method = RequestMethod.GET)
    public ModelAndView addPageGame(@PathVariable("id_u") int id_u) {
        ModelAndView modelAndView = new ModelAndView();
        Game game= new Game();
        game.setId_user(id_u);
        gameService.add(game);
        modelAndView.setViewName("redirect:/games/"+id_u);
        return modelAndView;
    }


    @RequestMapping (value = "/results/{id_game}", method = RequestMethod.GET)
    public ModelAndView allResults(@PathVariable("id_game") int id_game)
    {
        ModelAndView modelAndView  = new ModelAndView();
        int random = gameService.getById(id_game).getRandom();
        int id_u = gameService.getById(id_game).getId_user();
        List<Result> resultList = gameService.allResults(id_game);
        modelAndView.setViewName("results");
        modelAndView.addObject("resultList", resultList);
        modelAndView.addObject("random", random);
        modelAndView.addObject("id_game", id_game);
        modelAndView.addObject("id_u", id_u);
        return modelAndView;
    }

    @RequestMapping(value = "/addResult/{id_game}", method = RequestMethod.GET)
    public ModelAndView addPageResult(@PathVariable("id_game") int id_game) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addResult");
        modelAndView.addObject("id_game", id_game);
        return modelAndView;
    }

    @RequestMapping(value = "/addResult", method = RequestMethod.POST)
    public ModelAndView addResult(@ModelAttribute("result") Result result) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/results/"+result.getId_game());
        gameService.add(result);
        return modelAndView;
    }

}
