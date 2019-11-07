import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    const firstTime = window.localStorage.getItem('key')
    if (!firstTime) {
      localStorage.setItem('key', 'loaded')
      location.reload()
    } else {
      localStorage.removeItem('key')
    }

    if (!window.localStorage.getItem('loginUserName')) {
      this.router.navigate(['login']);
    }
  }

  accountBalance: number = parseFloat(window.localStorage.getItem('loginUserAccountBalance'));
  blockedAmount: number = parseFloat(window.localStorage.getItem('blockedAmount'));
  winOrLose: string = window.localStorage.getItem('gameStatus');
  rouletteResult: number = parseInt(window.localStorage.getItem('rouletteResult'));

  nullResponse = window.localStorage.getItem('nullResponse');



}
