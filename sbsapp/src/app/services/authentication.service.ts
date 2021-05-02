/**
 * The following tutorial was referenced while implementing this service:
 * 
 * H. Schmitz. “Angular Authentication with JWT.” Okta Developer. https://developer.okta.com/blog/2019/05/16/angular-authentication-jwt (accessed Mar 28, 2021).
 */

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { GatewayService } from './gateway.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private loggedIn = new BehaviorSubject<boolean>(false);
  private loggedOut = new BehaviorSubject<boolean>(true);
  private loggedInCust = new BehaviorSubject<boolean>(false);
  private loggedInTier1 = new BehaviorSubject<boolean>(false);
  private loggedInTier2 = new BehaviorSubject<boolean>(false);
  private loggedInAdmin = new BehaviorSubject<boolean>(false);
  private loggedInEmp = new BehaviorSubject<boolean>(false);
  private invalidCreds = new BehaviorSubject<boolean>(false);
  private jwt?: string;
  private role!: string;
  private uName!: string;

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  get isLoggedOut() {
    return this.loggedOut.asObservable();
  }

  get isLoggedInCust() {
    return this.loggedInCust.asObservable();
  }

  get isLoggedInTier1() {
    return this.loggedInTier1.asObservable();
  }

  get isLoggedInTier2() {
    return this.loggedInTier2.asObservable();
  }

  get isLoggedInAdmin() {
    return this.loggedInAdmin.asObservable();
  }

  get isLoggedInEmp() {
    return this.loggedInEmp.asObservable();
  }

  get isInvalidCreds() {
    return this.invalidCreds.asObservable();
  }

  constructor(private router: Router, private server: GatewayService) {
    const user = localStorage.getItem('user');
    if(user) {
      const userData = JSON.parse(user);
      this.jwt = userData.jwt;
      this.server.setLoggedIn(true, this.jwt);
      this.loggedOut.next(false);
      this.loggedIn.next(true);
      this.role = userData.role;
      this.uName = userData.id;
      switch (this.role) {
        case 'customer': {
          this.loggedInCust.next(true);
          break;
        }
        case 'tier1': {
          this.loggedInTier1.next(true);
          this.loggedInEmp.next(true);
          break;
        } 
        case 'tier2': {
          this.loggedInTier2.next(true);
          this.loggedInEmp.next(true);
          break;
        }
        case 'admin': {
          this.loggedInAdmin.next(true);
          this.loggedInEmp.next(true);
          break;
        }
      }
    }
  }

  login(user: any) {
    if (user.id !== '' && user.pwd !== '') {
      return this.server.request('POST', '/authenticate', {
        id: user.id,
        pwd: user.pwd
      }).pipe(catchError(error => {
        this.invalidCreds.next(true);
        return new Observable;
      })
        ).subscribe((res: any) => {
        if (res.jwtToken !== undefined) {
          this.jwt = res.jwtToken;
          this.role = res.role;
          this.uName = user.id;
          this.invalidCreds.next(false);
          this.server.setLoggedIn(true, this.jwt);
          this.loggedOut.next(false);
          this.loggedIn.next(true);
          const uData = {
            jwt: this.jwt,
            role: this.role,
            id: this.uName
          };
          localStorage.setItem('user', JSON.stringify(uData));
          switch (this.role) {
            case 'customer': {
              this.loggedInCust.next(true);
              this.router.navigateByUrl('/home');
              break;
            }
            case 'tier1': {
              this.loggedInTier1.next(true);
              this.loggedInEmp.next(true);
              this.router.navigateByUrl('/tier1');
              break;
            } 
            case 'tier2': {
              this.loggedInTier2.next(true);
              this.loggedInEmp.next(true);
              this.router.navigateByUrl('/tier2');
              break;
            }
            case 'admin': {
              this.loggedInAdmin.next(true);
              this.loggedInEmp.next(true);
              this.router.navigateByUrl('/admin');
              break;
            }
          }
        } else {
          this.invalidCreds.next(true);
        }
      });
    } else {
      return null;
    }
  }

  logout() {
    this.server.setLoggedIn(false);
    delete this.jwt;
    this.loggedOut.next(true);
    this.loggedIn.next(false);
    this.loggedInCust.next(false);
    this.loggedInTier1.next(false);
    this.loggedInTier2.next(false);
    this.loggedInAdmin.next(false);
    this.loggedInEmp.next(false);
    localStorage.clear();
    this.router.navigate(['']);
  }

  getRole(): string {
    const user = JSON.parse(localStorage.getItem('user')!);
    this.role = user.role;
    return this.role;
  }

  getUsername(): string {
    const user = JSON.parse(localStorage.getItem('user')!);
    this.uName = user.id;
    return this.uName;
  }

}
