import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { Observable } from 'rxjs';
import { ApplicantSignup } from '../models/applicant-signup';
import { Login } from '../models/login';
import { RecruiterSignup } from '../models/recruiter-signup';
import { LoginResponse } from '../models/login-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends BaseService {

  register_applicant(body: ApplicantSignup): Observable<any> {
    const url = this.BASE_URL + `/auth/register-applicant`;
    return this.http.post(url, body);
  }

  register_recruiter(body: RecruiterSignup): Observable<any> {
    const url = this.BASE_URL + `/auth/register-recruiter`;
    return this.http.post(url, body);
  }

  login_applicant(body: Login): Observable<LoginResponse> {
    const url = this.BASE_URL + `/auth/login-applicant`;
    return this.http.post<any>(url, body);
  }

  login_recruiter(body: Login): Observable<LoginResponse> {
    const url = this.BASE_URL + `/auth/login-recruiter`;
    return this.http.post<any>(url, body);
  }

}
