import { GamesService } from './../services/games.service';
import { Component, OnInit } from '@angular/core';
import { Game } from '../model/Game';
import { AppMaterialModule } from '../../shared/app-material/app-material.module';
import { Observable } from 'rxjs/internal/Observable';


@Component({
  selector: 'app-games',
  standalone: true,
  imports: [AppMaterialModule],
  templateUrl: './games.component.html',
  styleUrl: './games.component.scss'
})
export class GamesComponent implements OnInit{

 // gamesService: GamesService;

  games: Observable<Game[]>;
  displayedColumns  = ['nome', 'genero'];
  constructor(private gamesService: GamesService){
    this.games = this.gamesService.listAll();
  }



  ngOnInit(): void {

  }
}
