import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Applicant } from '../models/applicant';
import { Recruiter } from '../models/recruiter';

@Injectable({
  providedIn: 'root'
})
export class UserService extends BaseService {

  get_applicant(id: number): Observable<Applicant> {
    const param = new HttpParams().set("id", id);
    return this.http.get<any>(this.BASE_URL + `/users/applicant`, { params: param });
  }

  get_recruiter(id: number): Observable<Recruiter> {
    const param = new HttpParams().set("id", id);
    return this.http.get<any>(this.BASE_URL + `/users/recruiter`, { params: param });
  }

}
