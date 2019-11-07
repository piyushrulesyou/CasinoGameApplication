import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }

  accountBalance: number = parseInt(window.localStorage.getItem('loginUserAccountBalance'));
  blockedAmount: number = parseInt(window.localStorage.getItem('blockedAmount'));
  winOrLose: string = window.localStorage.getItem('gameStatus');
  rouletteResult: number = parseInt(window.localStorage.getItem('rouletteResult'));


}
