import { Component, OnInit, Input } from '@angular/core';
import { User } from '../entities/User';
import { UserService } from '../user.service';
import { OAuthService } from 'angular-oauth2-oidc';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  @Input() user: User;
  edit: boolean = false;

  constructor(public userService: UserService, private oauthService: OAuthService) { }

  ngOnInit() {

    this.userService.getUserInfo(this.oauthService.getAccessToken()).subscribe(data => {
      this.user = data;
      console.log("first "+data.firstName);
      console.log("last "+data.lastName);
      console.log("billing address "+data.billingAddress);
      console.log("city "+data.city);
      console.log("zip code "+data.zipCode);
      console.log("email "+data.email);
    }, error => console.log(error));
  }

  toggleEdit(){
    this.edit = !this.edit;
  }

  save(){

  }

}
