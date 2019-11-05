// import { ValidateUser } from '../../model/validate_user.model';
import { Component, OnInit, Input } from '@angular/core';

import { UserLogin } from '../../model/login_info.model';
import { LoginService } from '../../services/login.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'nag-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(public loginService: LoginService) { }

  ngOnInit() {
    this.resetForm();
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

  validateUser(loginForm: NgForm) {
    this.loginService.validateUser(loginForm.value).subscribe(res => {
      this.resetForm(loginForm);
    });
  }
}
