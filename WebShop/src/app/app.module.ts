import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppComponent } from './app.component';
import { OAuthService, OAuthModule } from 'angular-oauth2-oidc';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ProductComponent } from './product/product.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './components/admin/admin.component';
import { FormsModule } from '@angular/forms';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'user', component: UserComponent},

];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationComponent,
    ProductComponent,
    UserComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    OAuthModule.forRoot()
  ],
  providers: [OAuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
