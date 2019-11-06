// import { ValidateUser } from '../../model/validate_user.model';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { UserLogin } from '../../model/login_info.model';
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
  }
  resetForm(loginForm?: NgForm) {
    if (loginForm != null)
      loginForm.resetForm();

    this.loginService.loginFormData = {
      customerID: ''
    }
  }

  onSubmit(loginForm: NgForm) {
    this.validateUser(loginForm);
  }

  isInvalidUser: boolean = false;

  validateUser(loginForm: NgForm) {
    this.loginService.validateUser(loginForm.value).subscribe((response) => {
      console.log(response);
      this.resetForm(loginForm);

      if (response == null)
        this.isInvalidUser = true;
      else {
        window.localStorage.setItem('loginUserName', response.customerName.toString());
        window.localStorage.setItem('loginUserAccount', response.accountBalance.toString());
        // console.log(response.customerName);
        // console.log(response.accountBalance);
        this.router.navigate(['home']);
      }
    });
  }
}
