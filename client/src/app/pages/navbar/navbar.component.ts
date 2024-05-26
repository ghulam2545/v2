import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { StorageService } from '../../services/storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(
    private authService: AuthService,
    private storageService: StorageService
  ) {}

  is_logged(): boolean {
    return this.authService.is_logged();
  }

  logout(): void {
    this.authService.logout();
  }

  account(): string {
    const username = this.storageService.get('username');
    const role = this.storageService.get('role');

    if (role === 'ROLE_APPLICANT') {
      return `/applicant/${username}`;
    } else {
      return `/recruiter/${username}`;
    }
  }

}
