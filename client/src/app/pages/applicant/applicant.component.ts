import { Component } from '@angular/core';
import { StorageService } from '../../services/storage.service';
import { UserService } from '../../services/user.service';
import { Applicant } from '../../models/applicant';
import { Job } from '../../models/job';
import { JobService } from '../../services/job.service';

@Component({
  selector: 'app-applicant',
  templateUrl: './applicant.component.html',
  styleUrl: './applicant.component.css'
})
export class ApplicantComponent {

  jobs: Job[] = [];
  applicant: Applicant = {
    id: 0,
    fullname: '',
    username: '',
    email: '',
    password: '',
    contact: '',
    skills: '',
    applications: []
  };
  id: number = -1;

  constructor(
    private storageService: StorageService,
    private userService: UserService,
    private jobService: JobService
  ) { }

  ngOnInit() {
    this.id = Number(this.storageService.get('id'));

    this.userService.get_applicant(this.id).subscribe({
      next: data => {
        this.applicant = data;

        this.applicant.applications.forEach(app => {
          this.jobService.get_job(app.jobId).subscribe({
            next: data => {
              this.jobs.push(data);
            }, error: err => {
              console.error(err);
            }
          })
        })
      },
      error: err => {
        console.error(err);
      }
    });
  }

}
