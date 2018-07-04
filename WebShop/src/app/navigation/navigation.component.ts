import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private userService: UserService) {
  }

  public login() {
      this.userService.login();
  }

  public logout() {
      this.userService.logout();
  }

  public isAuthenticated() : boolean{
    return this.userService.isAuthenticated();
  }

  ngOnInit() {
  }

}
