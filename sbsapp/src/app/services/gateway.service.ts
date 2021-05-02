/**
 * The following tutorial was referenced while implementing this service:
 * 
 * H. Schmitz. “Angular Authentication with JWT.” Okta Developer. https://developer.okta.com/blog/2019/05/16/angular-authentication-jwt (accessed Mar 28, 2021).
 */

import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const serverUrl = environment.apiBaseUrl;

@Injectable({
  providedIn: 'root'
})
export class GatewayService {

  private loggedIn = false;
  private jwt!: string;

  constructor(private http: HttpClient) { }

  setLoggedIn(loggedIn: boolean, jwt?: string) {
    this.loggedIn = loggedIn;
    this.jwt = jwt || "";
  }

  request(method: string, path: string, data?: any, parameters?: any) {
    if (method === 'GET') {
      return this.get(path, data);
    }

    const authHeader = (this.loggedIn) ? { Authorization: `Bearer ${this.jwt}` } : undefined;

    let params = new HttpParams();
    if (parameters !== undefined) {
      Object.getOwnPropertyNames(parameters).forEach(key => {
        params = params.set(key, parameters[key])
      });
    }

    return this.http.request(method, serverUrl + path, {
      body: data,
      responseType: 'json',
      observe: 'body',
      headers: authHeader,
      params
    });
  } 

  requestLog(path: string, data?: any) {
    return this.getLog(path, data)
  }

  get(path: string, data?: any) {
    const authHeader = (this.loggedIn) ? { Authorization: `Bearer ${this.jwt}` } : undefined
    
    let params = new HttpParams();
    if (data!== undefined) {
      Object.getOwnPropertyNames(data).forEach(key => {
        params = params.set(key, data[key])
      });
    }

    return this.http.get(serverUrl + path, {
      responseType: 'json',
      headers: authHeader,
      params
    });
  }

  getLog(path: string, data?: any) {
    const authHeader = (this.loggedIn) ? { Authorization: `Bearer ${this.jwt}` } : undefined;
    
    let params = new HttpParams();
    if (data!== undefined) {
      Object.getOwnPropertyNames(data).forEach(key => {
        params = params.set(key, data[key])
      });
    }

    return this.http.get(serverUrl + path, {
      responseType: 'text',
      headers: authHeader,
      params
    });
  }

}
