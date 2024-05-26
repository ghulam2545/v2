import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Job } from '../../models/job';
import { JobService } from '../../services/job.service';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrl: './description.component.css'
})
export class DescriptionComponent {

  id: number = 0;
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
    private router: ActivatedRoute,
    private jobService: JobService
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.params['id'];

    this.jobService.get_job(this.id).subscribe({
      next: data => {
        this.job = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }

}
