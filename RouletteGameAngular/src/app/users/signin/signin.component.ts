import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'nag-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(public loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.resetForm();
    window.localStorage.removeItem('loginUserName');
    window.localStorage.removeItem('loginUserAccount');
    window.localStorage.removeItem('loginUserID')
  }
  resetForm(loginForm?: NgForm) {
    if (loginForm != null)
      loginForm.resetForm();

    this.loginService.loginFormData = {
      customerID: 'sdf68198sdf7'
    }
  }

  onSubmit(loginForm: NgForm) {
    this.validateUser(loginForm);
  }

  isInvalidUser: boolean = false;

  validateUser(loginForm: NgForm) {
    this.loginService.validateUser(loginForm.value).subscribe(response => {

      this.resetForm(loginForm);

      if (response == null)
        this.isInvalidUser = true;
      else {
        window.localStorage.setItem('loginUserName', response.customerName.toString());
        window.localStorage.setItem('loginUserAccountBalance', response.accountBalance.toString());
        window.localStorage.setItem('loginUserID', response.customerID.toString());

        this.router.navigate(['home']);
      }
    });
  }
}
