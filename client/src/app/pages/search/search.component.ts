import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  search_form!: FormGroup;
  builder: FormBuilder = new FormBuilder();

  constructor() { }

  ngOnInit() {
    this.search_form = this.builder.group({
      keyword: ['', Validators.required],
      location: [],
      type: []
    });
  }


  onSubmit() {
    console.log(this.search_form.value);

  }

  f(value: string) {
    return this.search_form.get(value);
  }

}
