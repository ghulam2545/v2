import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Application } from '../models/application';
import { BaseService } from './base.service';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService extends BaseService {

  save_application(userId: number, jobId: number, body: Application): Observable<Application> {
    const param = new HttpParams().set('userId', userId).set('jobId', jobId);
    return this.http.post<any>(this.BASE_URL + `/applications/new-application`, body, { params: param });
  }

  get_application(id: number): Observable<Application> {
    const param = new HttpParams().set('id', id);
    return this.http.get<any>(this.BASE_URL + `/applications/get-application`, { params: param });
  }

}
