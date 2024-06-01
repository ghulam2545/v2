import { Injectable, inject } from '@angular/core';
import { Router, CanActivateFn } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  canActivate(): boolean {
    if (this.authService.signing_status()) {
      return true;
    } else {
      alert('Login first');
      this.router.navigate(['/']);
      return false;
    }
  }
}

export const authGuard: CanActivateFn = (route, state): boolean => {
  return inject(AuthGuardService).canActivate();
}