import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PlayingService } from '../../services/playing.service';
import { Router } from '@angular/router';

// import * as $ from 'jquery';
import { UserBettingValue } from 'src/app/model/betting.model';
import { GameResult } from '../../model/game_result.model';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit {

  constructor(public playingService: PlayingService, private router: Router) { }

  bettingForm: UserBettingValue;

  ngOnInit() {

    this.resetForm();

    if (!window.localStorage.getItem('loginUserName')) {
      this.router.navigate(['login']);
    }

    this.count = 0;
    this.ele = 0;
    this.type = 0;
    this.isValidGame = true;
  }

  resetForm(bettingForm?: NgForm) {

    if (bettingForm != null)
      bettingForm.resetForm();

    this.bettingForm = {
      first12: 0,
      second12: 0,
      last12: 0,
      zero: 0,
      first18: 0,
      last18: 0,
      even: 0,
      odd: 0,
    }
  }

  customerID: string = window.localStorage.getItem('loginUserID');
  customerName: string = window.localStorage.getItem('loginUserName');
  accountBalance: number = parseFloat(window.localStorage.getItem('loginUserAccountBalance'));

  // value = '';
  counter: number = 0;
  amount = 0;
  gameResult: GameResult;
  betSegment = '';
  tempBalance = 0;
  isValidGame;
  arr: number[] = [];

  count: number = 0;
  ele: any;
  type: number;

  onSubmit() {
    // this.resetForm();
    console.log(this.count);
    // this.verify();
    if (this.isValidGame)
      this.generateResult(this.bettingForm);
    this.resetForm();
  }

  modalVerify() {
    this.verify();
  }

  verify() {
    this.arr[0] = this.bettingForm.first12;
    this.arr[1] = this.bettingForm.second12;
    this.arr[2] = this.bettingForm.last12;
    this.arr[3] = this.bettingForm.zero;
    this.arr[4] = this.bettingForm.first18;
    this.arr[5] = this.bettingForm.last18;
    this.arr[6] = this.bettingForm.even;
    this.arr[7] = this.bettingForm.odd;

    console.log(this.bettingForm.first12);
    console.log(this.bettingForm.second12);
    console.log(this.bettingForm.last12);
    console.log(this.bettingForm.zero);
    console.log(this.bettingForm.first18);
    console.log(this.bettingForm.last18);
    console.log(this.bettingForm.even);
    console.log(this.bettingForm.odd);

    this.arr.forEach(element => {
      this.counter++;
      if (element != 0) {
        this.count++;
        this.ele = element;
        this.type = this.counter;
      }
    });

    console.log(this.count + "count");
    console.log(this.type + "counter"); //will contain the selected slot in number
    console.log(this.ele + "element");  //will contain the value of the selected slot

    if (this.count > 1)
      this.isValidGame = false;
  }



  generateResult(bettingForm: UserBettingValue) {
    this.playingService.generateResult(this.customerID, this.ele, this.type).subscribe(response => {
      console.log(response);
      this.gameResult = response;
      if (response != null) {
        window.localStorage.setItem('loginUserAccountBalance', response.finalUserAccountBalance.toString());
        window.localStorage.setItem('blockedAmount', response.finalUserBlockAmount.toString());
        window.localStorage.setItem('gameStatus', response.gameResult.toString());
        window.localStorage.setItem('rouletteResult', response.resultantNumber.toString());
        this.router.navigate(['result']);
      }
    });
  }

  resetButton() {
    this.count = 0;
    this.isValidGame = true;
    this.ele = 0;
    this.type = 0;
    this.resetForm();
  }

  resetButton2() {
    this.count = 0;
    this.isValidGame = true;
    this.ele = 0;
    this.type = 0;
    this.resetForm();
    // location.reload();
  }
}