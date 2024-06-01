import { Injectable } from '@angular/core';
import { StorageService } from './storage.service';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BaseService {

  public BASE_URL = 'http://localhost:8080/api/v2';
  login_status: boolean = false;

  constructor(
    public storageService: StorageService,
    public http: HttpClient
  ) { }

  is_logged(): boolean {
    if (this.storageService.get('token') != null) {
      this.login_status = true;
    }
    return this.login_status;
  }

  logout() {
    this.storageService.clear();
  }

  signing_status(): boolean {
    return this.login_status;
  }

}
