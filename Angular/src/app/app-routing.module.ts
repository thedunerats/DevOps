import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';
import { CreateeventComponent } from './createevent/createevent.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [
  { path: '', component: HomeComponent }, //empty component path loads first
  { path: 'app-login', component: LoginComponent},
  { path: 'app-search', component: SearchComponent},
  { path: 'app-createevent', component: CreateeventComponent},
  { path: 'app-signup', component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
