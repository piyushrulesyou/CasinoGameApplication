// import { ValidateUser } from '../users/model/validate_user.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { UserLogin } from '../model/login_info.model';
// import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly loginURI = "http://localhost:8080/validate/validateUser";

  loginFormData: UserLogin;

  constructor(private httpClient: HttpClient) { }

  validateUser(loginFormData: UserLogin) {
    return this.httpClient.get(this.loginURI + '/loginFormData');
  }

}