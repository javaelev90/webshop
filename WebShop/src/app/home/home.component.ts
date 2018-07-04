import { Component, OnInit } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { UserService } from '../user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private oauthService: OAuthService, private userService: UserService) { 

  }

  ngOnInit() {
  }

  serverAuthTest(){
    let accessToken = this.oauthService.getAccessToken();
    let email = "anders.lum@gmail.com";
    console.log(accessToken);
    console.log(email);
    this.userService.loginToServer(accessToken, email);
  }
}
