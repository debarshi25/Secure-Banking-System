import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GatewayService } from 'src/app/services/gateway.service';

@Component({
  selector: 'app-system-log',
  templateUrl: './system-log.component.html',
  styleUrls: ['./system-log.component.css']
})
export class SystemLogComponent implements OnInit {

  constructor(private gatewayService: GatewayService) { }
  
  public logFile: String;

  ngOnInit(): void {
    this.gatewayService.requestLog('/utility/getLogFile').subscribe(
      (response: any) => {
        this.logFile = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

}
