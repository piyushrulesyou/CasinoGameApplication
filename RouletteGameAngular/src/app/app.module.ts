import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { SigninComponent } from './users/signin/signin.component';
import { HomeComponent } from './users/home/home.component';
import { LoginService } from './services/login.service';
import { PlayingService } from './services/playing.service';

import { routing } from "../app/app.routing";
import { PlayComponent } from './users/play/play.component';
import { ResultComponent } from './users/result/result.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    SigninComponent,
    HomeComponent,
    PlayComponent,
    ResultComponent
  ],
  imports: [
    BrowserModule,
    routing,
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginService, PlayingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
