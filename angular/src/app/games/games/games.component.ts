import { Component, OnInit } from '@angular/core';
import { Game } from '../model/Game';
import { AppMaterialModule } from '../../shared/app-material/app-material.module';


@Component({
  selector: 'app-games',
  standalone: true,
  imports: [AppMaterialModule],
  templateUrl: './games.component.html',
  styleUrl: './games.component.scss'
})
export class GamesComponent implements OnInit{

  games: Game[] = [
    {_id: 1, nome:"Fortnite", genero: "Multiplayer"},
    {_id: 2, nome:"Overcooked", genero: "Cozinha"},
  ];
  displayedColumns  = ['nome', 'genero'];
  constructor(){

  }

  ngOnInit(): void {

  }
}
