import { Routes } from '@angular/router';

export const routes: Routes = [
  {path: "", redirectTo: "games", pathMatch: "full"},
  {
    path: 'games',
    loadChildren: () => import('./games/games.module').then(m => m.GamesModule)
  }
];
