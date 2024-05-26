import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrl: './apply.component.css'
})
export class ApplyComponent {

  apply_form!: FormGroup;
  builder: FormBuilder = new FormBuilder();
  job_id: number = -1;
  job_title: string = 'Job title you are applying for';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private dataService: DataService
  ) { }

  ngOnInit() {
    this.job_id = this.route.snapshot.params['id'];

    this.apply_form = this.builder.group({
      fullname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      contact: ['', Validators.required],
      education: ['', Validators.required],
      field: ['', Validators.required],
      performance: ['', Validators.required],
      skills: ['', Validators.required],
      experience: ['', Validators.required],
      // resume, docs
      cover: [''],
      portfolio: [],
      linkedin: [],
      github: [],
      other: [],
      comments: []
    });
  }

  onSubmit() {
    this.dataService.setter(this.apply_form.value);
    this.router.navigate([`/review/${this.job_id}`]);
  }

  f(value: string) {
    return this.apply_form.get(value);
  }


}
