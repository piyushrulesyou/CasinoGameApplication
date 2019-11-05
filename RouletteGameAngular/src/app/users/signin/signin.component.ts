// import { ValidateUser } from '../../model/validate_user.model';
import { Component, OnInit, Input } from '@angular/core';

import { UserLogin } from '../../model/login_info.model';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'nag-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(public service: LoginService) { }

  ngOnInit() {
    this.resetForm();
  }
  resetForm() {
    throw new Error("Method not implemented.");
  }
}
