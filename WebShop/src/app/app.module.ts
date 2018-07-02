import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppComponent } from './app.component';
import { OAuthService, OAuthModule } from 'angular-oauth2-oidc';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { NavigationComponent } from './navigation/navigation.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},


];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    MatToolbarModule,
    RouterModule.forRoot(appRoutes),
    OAuthModule.forRoot()
  ],
  providers: [OAuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
