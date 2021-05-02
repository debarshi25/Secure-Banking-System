import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { GatewayService } from './gateway.service';

@Injectable({
  providedIn: 'root'
})
export class UtilityService {

  constructor(private gatewayService: GatewayService) { } 
  
  private apiServerUrl = environment.apiBaseUrl;

  public getLogFileAsString(): Observable<String> {
    return this.gatewayService.request('GET', '/utility/getLogFile').pipe(map((response: any) => response.data as String));
  }

}
