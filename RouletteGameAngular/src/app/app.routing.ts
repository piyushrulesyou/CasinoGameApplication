import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './users/home/home.component';
import { SigninComponent } from './users/signin/signin.component';
import { UsersComponent } from './users/users.component';
import { PlayComponent } from './users/play/play.component';
import { ResultComponent } from './users/result/result.component';

const routes: Routes = [
    { path: 'login', component: SigninComponent },
    { path: 'home', component: HomeComponent },
    { path: '', component: SigninComponent },
    { path: 'users', component: UsersComponent },
    { path: 'play', component: PlayComponent },
    { path: 'result', component: ResultComponent },
];
export const routing = RouterModule.forRoot(routes);