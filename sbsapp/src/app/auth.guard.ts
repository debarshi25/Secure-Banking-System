import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild, CanDeactivate, CanLoad, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service'

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild, CanDeactivate<unknown>, CanLoad {
  
  constructor(private authenticationService: AuthenticationService, private router: Router) {}
  
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let url: string = state.url;
    return this.validateUser(route, url);
  }

  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.canActivate(childRoute, state);
  }

  canDeactivate(
    component: unknown,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }

  canLoad(
    route: Route,
    segments: UrlSegment[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }

  validateUser(route: ActivatedRouteSnapshot, url: any): boolean {
    if(this.authenticationService.isLoggedIn) {
      const role = this.authenticationService.getRole();
      if(route.data.role && route.data.role.indexOf(role) === -1) {
        switch (role) {
          case 'customer': {
            this.router.navigateByUrl('/home');
            break;
          }
          case 'tier1': {
            this.router.navigateByUrl('/tier1');
            break;
          } 
          case 'tier2': {
            this.router.navigateByUrl('/tier2');
            break;
          }
          case 'admin': {
            this.router.navigateByUrl('/admin');
            break;
          }
        }
        return false;
      }
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }

}
