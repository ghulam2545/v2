import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../models/job';

@Injectable({
  providedIn: 'root'
})
export class JobService extends BaseService {

  all_jobs(): Observable<Job[]> {
    return this.http.get<any>(this.BASE_URL + `/jobs/jobs`);
  }

  get_job(id: number): Observable<Job> {
    const param = new HttpParams().set("id", id);
    return this.http.get<any>(this.BASE_URL + `/jobs/get-job`, { params: param })
  }

  post_job(id: number, body: Job): Observable<any> {
    const param = new HttpParams().set('id', id);
    return this.http.post<any>(this.BASE_URL + `/jobs/new-job`, body, { params: param });
  }

}
