import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OAuthService } from 'angular-oauth2-oidc';
import { User } from './entities/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private oauthService: OAuthService) { }

  getUserInfo(accessToken: string): Observable<User>{
    let url = "http://localhost:8080";
    return this.http.get<User>(url, {params:{accessToken: accessToken}});
  }
  public login() {
    this.oauthService.initImplicitFlow();
  }

  public logout() {
    this.oauthService.logOut();
  }

  public isAuthenticated() : boolean{
    return this.oauthService.hasValidAccessToken();
  }

}
