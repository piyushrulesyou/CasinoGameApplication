import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PlayingService } from '../../services/playing.service';
import { Router } from '@angular/router';


import { UserBettingValue } from 'src/app/model/betting.model';
import { GameResult } from '../../model/game_result.model';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent {

  // refresh = false;
  // generatedNum;
  // winResponse: boolean;
  // balance: number;

  error: string = null;
  insufficientBalError: string = null;

  valueZero: number[] = new Array(9).fill(0);

  money: number;
  segment: number;

  constructor(public playingService: PlayingService, private router: Router) { }

  ngOnInit() {

    if (!window.localStorage.getItem('loginUserName')) {
      this.router.navigate(['login']);
    }

    const firstTime = window.localStorage.getItem('key')
    if (!firstTime) {
      localStorage.setItem('key', 'loaded')
      location.reload()
    } else {
      localStorage.removeItem('key')
    }
  }

  customerID: string = window.localStorage.getItem('loginUserID');
  customerName: string = window.localStorage.getItem('loginUserName');
  accountBalance: number = parseFloat(window.localStorage.getItem('loginUserAccountBalance'));

  callMe(event: MouseEvent) {

    console.log(
      parseInt((event.target as HTMLInputElement).value));
    console.log(
      (event.target as HTMLInputElement).name);

    let inputValue = parseInt((event.target as HTMLInputElement).value);
    let id = parseInt((event.target as HTMLInputElement).id);

    let temp = this.valueZero[id];

    this.valueZero.fill(0);
    if (this.accountBalance > inputValue) {
      this.valueZero[id] = inputValue;
      this.insufficientBalError = null;
    }
    else {
      this.valueZero[id] = temp;
      this.insufficientBalError = "Insufficient Balance!"
    }

    console.log(temp + "temp");


    //   console.log(this.amount);
    //   console.log(this.betSegment);

  }

  onSubmit() {

    let money = this.valueZero.find(c => c != 0);
    let gameCase = this.valueZero.findIndex(c => c != 0);

    this.money = money;
    this.segment = gameCase;

    if (gameCase != -1) {
      this.generateResult();
    }
    else {
      this.error = "Please do betting on any one of them."
    }

  }


  resetButton() {
    let gameCase = this.valueZero.findIndex(c => c != 0);
    // if (gameCase != -1)
    location.reload();
  }


  resetButton2() {
    let gameCase = this.valueZero.findIndex(c => c != 0);
    // if (gameCase != -1)
    location.reload();
  }

  generateResult() {
    this.playingService.generateResult(this.customerID, this.money, this.segment).subscribe(response => {
      console.log(response);
      // this.gameResult = response;
      if (response != null) {
        window.localStorage.setItem('loginUserAccountBalance', response.finalUserAccountBalance.toString());
        window.localStorage.setItem('blockedAmount', response.finalUserBlockAmount.toString());
        window.localStorage.setItem('gameStatus', response.gameResult.toString());
        window.localStorage.setItem('rouletteResult', response.resultantNumber.toString());
        window.localStorage.setItem('nullResponse', "false");
        this.router.navigate(['result']);
      } else {
        window.localStorage.setItem('nullResponse', "true");
        this.router.navigate(['result']);
      }
    });
  }
}