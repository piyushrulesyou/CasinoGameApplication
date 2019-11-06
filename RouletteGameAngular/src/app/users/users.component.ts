import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'nag-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    if (!window.localStorage.getItem('loginUserName')) {
      this.router.navigate(['login']);
    }
  }

  customerName: string = window.localStorage.getItem('loginUserName');
  accountBalance: string = window.localStorage.getItem('loginUserAccountBalance');

  onLogout() {
    this.loginService.deleteToken();
    location.reload();
  }

}
