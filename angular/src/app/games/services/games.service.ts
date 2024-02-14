import { Injectable } from '@angular/core';
import { Game } from '../model/Game';
import { HttpClient } from '@angular/common/http';
import { get } from 'http';
import { first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GamesService {

  private readonly API = "/assets/games.json";

  constructor(private httpClient: HttpClient) { }

  listAll(){
    return this.httpClient.get<Game[]>(this.API)
    .pipe(first());
  }

}
