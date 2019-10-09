import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Inject } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AgmCoreModule } from '@agm/core'
import { HttpClientModule } from '@angular/common/http';
import { DirectivesComponent } from './directives/directives.component';
import { LoginComponent } from './login/login.component';
import { AlertModule } from 'ngx-bootstrap';
import { SESSION_STORAGE, StorageServiceModule, WebStorageService } from 'angular-webstorage-service';
import { HeaderComponent } from './header/header.component';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DirectivesComponent,
    LoginComponent,
    HeaderComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAaaC181uQClpMqcLvbCPATlTAnKaIwGMA'
    }),
    HttpClientModule,
    AlertModule,
    StorageServiceModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(@Inject(SESSION_STORAGE) storage:WebStorageService){}
}
