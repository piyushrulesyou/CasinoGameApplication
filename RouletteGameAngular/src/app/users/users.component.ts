import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { PlayingService } from '../services/playing.service';

@Component({
  selector: 'nag-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private loginService: LoginService, private playingService: PlayingService, private router: Router) { }

  ngOnInit() {
    if (!window.localStorage.getItem('loginUserName')) {
      this.router.navigate(['login']);
    }
  }

  customerName: string = window.localStorage.getItem('loginUserName');
  accountBalance: number = parseFloat(window.localStorage.getItem('loginUserAccountBalance'));

  onLogout() {
    this.loginService.deleteToken();
    location.reload();
  }

}
