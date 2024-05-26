import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  
  data: any;

  constructor() { }

  setter(data: any) {
    this.data = data;
  }

  getter() {
    return this.data;
  }
  
}
