import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './users/home/home.component';
import { SigninComponent } from './users/signin/signin.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
    { path: 'login', component: SigninComponent },
    { path: 'home', component: HomeComponent },
    { path: '', component: SigninComponent },
    { path: 'users', component: UsersComponent },
];

export const routing = RouterModule.forRoot(routes);