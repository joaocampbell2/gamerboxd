package com.example.gamerboxd.controller;

import com.example.gamerboxd.entities.Game;
import com.example.gamerboxd.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    private GameRepo gameRepo;
    @GetMapping("/getGames")
    public ResponseEntity<List<Game>> getAllGames(){
        try{
            List<Game> gamelist = new ArrayList<>();
            gameRepo.findAll().forEach(gamelist::add);

            if (gamelist.isEmpty()){
                return new ResponseEntity<>(gamelist, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(gamelist, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getGameById/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id){
        Optional<Game> game= gameRepo.findById(id);
        if (game.isPresent()){
            return new ResponseEntity<>(game.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/addGame")

    public ResponseEntity<Game> addGame(@RequestBody Game game){
       Game gameObj =  gameRepo.save(game);
       return new ResponseEntity<>(gameObj, HttpStatus.OK);
    }
    @PutMapping("/updateGameById/{id}")

    public ResponseEntity<Game> updateGameById(@PathVariable Long id, @RequestBody Game newGame){
        Optional<Game> oldGame= gameRepo.findById(id);
        if (oldGame.isPresent()){

            Game game = oldGame.get();
            game.setNome(newGame.getNome());
            game.setGenero(newGame.getGenero());

            Game gameObj =  gameRepo.save(game);

            return new ResponseEntity<>(game, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/deleteGame/{id}")
    public ResponseEntity<HttpStatus> deleteGameById(@PathVariable Long id){
        gameRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
