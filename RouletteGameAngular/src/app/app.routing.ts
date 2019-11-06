import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './users/home/home.component';
import { SigninComponent } from './users/signin/signin.component';

const routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: '', component: SigninComponent }
];

export const routing = RouterModule.forRoot(routes);