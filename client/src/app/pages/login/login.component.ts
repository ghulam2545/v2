import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Login } from '../../models/login';
import { AuthService } from '../../services/auth.service';
import { StorageService } from '../../services/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  login!: Login;
  login_form!: FormGroup;
  builder: FormBuilder = new FormBuilder();

  password_field_type: string = 'password';
  password_visibility(): void {
    this.password_field_type = this.password_field_type === 'password' ? 'text' : 'password';
  }
  
  constructor(
    private authService: AuthService,
    private storageService: StorageService,
    private router: Router
  ) {}

  ngOnInit() {
    this.login_form = this.builder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(role: string) {
    if (role === 'applicant') {
      this.login = this.login_form.value;

      this.authService.login_applicant(this.login).subscribe({
        next: data => {
          const { id, username, role, token } = data;

          this.storageService.save("id", id.toString());
          this.storageService.save("username", username);
          this.storageService.save("role", role)
          this.storageService.save("token", token);

          alert('Login success');
          this.router.navigate(['']);

        },
        error: err => {
          console.error(err);
        }
      });

    } else {
      this.login = this.login_form.value;

      this.authService.login_recruiter(this.login).subscribe({
        next: data => {
          const { id, username, role, token } = data;

          this.storageService.save("id", id.toString());
          this.storageService.save("username", username);
          this.storageService.save("role", role)
          this.storageService.save("token", token);
          alert('Login success');
          this.router.navigate(['']);

        },
        error: err => {
          console.error(err);
        }
      });

    }
  }

  f(value: string) {
    return this.login_form.get(value);
  }

}
