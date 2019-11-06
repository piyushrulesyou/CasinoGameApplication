import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './users/home/home.component';
import { SigninComponent } from './users/signin/signin.component';
import { UsersComponent } from './users/users.component';
import { PlayComponent } from './users/play/play.component';

const routes: Routes = [
    { path: 'login', component: SigninComponent },
    { path: 'home', component: HomeComponent },
    { path: '', component: SigninComponent },
    { path: 'users', component: UsersComponent },
    { path: 'play', component: PlayComponent }
];
export const routing = RouterModule.forRoot(routes);