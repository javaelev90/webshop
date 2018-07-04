import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private oauthService: OAuthService) { }

  loginToServer(accessToken: string, email: string){
    let url = "http://localhost:8080";
    this.http.get(url, {params:{accessToken: accessToken}}).subscribe(data => console.log("success:"+data), error => console.log("error:"+error));
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
