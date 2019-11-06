import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'nag-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

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
  customerName: string = window.localStorage.getItem('loginUserName');
  accountBalance: string = window.localStorage.getItem('loginUserAccountBalance');

}
