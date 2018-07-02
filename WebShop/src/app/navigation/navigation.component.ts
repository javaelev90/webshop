import { Component, OnInit } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private oauthService: OAuthService) {
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

  ngOnInit() {
  }

}
