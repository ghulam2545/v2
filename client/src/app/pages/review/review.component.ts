import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Application } from '../../models/application';
import { ApplicationService } from '../../services/application.service';
import { DataService } from '../../services/data.service';
import { Job } from '../../models/job';
import { JobService } from '../../services/job.service';
import { StorageService } from '../../services/storage.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrl: './review.component.css'
})
export class ReviewComponent {

  application!: Application;
  job_id: number = -1;
  job: Job = {
    id: 0,
    title: '',
    company: '',
    location: '',
    skills: '',
    experience: '',
    type: '',
    date: ''
  };

  constructor(
    private route: ActivatedRoute,
    private dataService: DataService,
    private jobService: JobService,
    private applicationService: ApplicationService,
    private storageService: StorageService,
    private router: Router
  ) { }

  ngOnInit() {
    this.job_id = this.route.snapshot.params['id'];

    this.jobService.get_job(this.job_id).subscribe({
      next: data => {
        this.job = data;
      },
      error: err => {
        console.error(err);
      }
    });

    this.application = this.dataService.getter();
  }

  submit_application(): void {
    const userId = Number(this.storageService.get('id'));
    const jobId = this.job_id;
    this.applicationService.save_application(userId, jobId, this.application).subscribe({

    });

    alert('Yoy submission is made.');
    this.router.navigate(['']);
  }

  print_application(): void {
    window.print();
  }

}
