import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  Title = 'Sunrise Bank';
  Description = 'Broaden your banking horizons.'

  constructor(public authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

  onLogout() {
    this.authenticationService.logout();
  }
}
