import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';
import {Employee} from './services/employee'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'Sunrise Bank';
   
   public employees : Employee[];
   
   constructor(public authenticationService: AuthenticationService) {} 
   
   ngOnInit() {
   };
}
