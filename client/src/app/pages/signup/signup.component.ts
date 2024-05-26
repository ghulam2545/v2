import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ApplicantSignup } from '../../models/applicant-signup';
import { RecruiterSignup } from '../../models/recruiter-signup';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  applicant!: ApplicantSignup;
  recruiter!: RecruiterSignup;

  applicant_form!: FormGroup;
  recruiter_form!: FormGroup;
  builder: FormBuilder = new FormBuilder();

  password_field_type: string = 'password';
  password_visibility(): void {
    this.password_field_type = this.password_field_type === 'password' ? 'text' : 'password';
  }

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    this.applicant_form = this.builder.group({
      fullname: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      contact: ['', Validators.required],
      skills: ['', Validators.required],
    });

    this.recruiter_form = this.builder.group({
      fullname: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      contact: ['', Validators.required],
      company: ['', Validators.required],
    });
  }

  onSubmit(role: string) {
    if (role === 'applicant') {
      this.applicant = this.applicant_form.value;

      this.authService.register_applicant(this.applicant).subscribe({
        next: data => {
          alert('Registration success');
        },
        error: err => {
          console.error(err);
        }
      });

      this.router.navigate(['']);
    } else {
      this.recruiter = this.recruiter_form.value;

      this.authService.register_recruiter(this.recruiter).subscribe({
        next: data => {
          alert('Registration success');
        },
        error: err => {
          console.error(err);
        }
      });

      this.router.navigate(['']);
    }
  }

  applicant_f(value: string) {
    return this.applicant_form.get(value);
  }

  recruiter_f(value: string) {
    return this.recruiter_form.get(value);
  }

}
