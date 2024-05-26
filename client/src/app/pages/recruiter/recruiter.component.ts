import { Component } from '@angular/core';
import { Recruiter } from '../../models/recruiter';
import { StorageService } from '../../services/storage.service';
import { UserService } from '../../services/user.service';
import { Job } from '../../models/job';
import { Application } from '../../models/application';
import { JobService } from '../../services/job.service';

@Component({
  selector: 'app-recruiter',
  templateUrl: './recruiter.component.html',
  styleUrl: './recruiter.component.css'
})
export class RecruiterComponent {

  recruiter: Recruiter = {
    id: 0,
    fullname: '',
    email: '',
    password: '',
    contact: '',
    company: '',
    speciality: '',
    jobs: [],
    applications: []
  };
  jobs: Job[] = [];
  applications: Application[] = [];
  id: number = -1;

  constructor(
    private storageService: StorageService,
    private jobService: JobService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.id = Number(this.storageService.get('id'));

    this.userService.get_recruiter(this.id).subscribe({
      next: data => {
        this.recruiter = data;
        this.applications = this.recruiter.applications;
        this.jobs = this.recruiter.jobs;

      },
      error: err => {
        console.error(err);
      }
    });
  }
  
}
