import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { SigninComponent } from './users/signin/signin.component';
import { HomeComponent } from './users/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    SigninComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
