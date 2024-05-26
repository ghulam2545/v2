import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplicantComponent } from './pages/applicant/applicant.component';
import { ApplyComponent } from './pages/apply/apply.component';
import { DescriptionComponent } from './pages/description/description.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { PostComponent } from './pages/post/post.component';
import { RecruiterComponent } from './pages/recruiter/recruiter.component';
import { SearchComponent } from './pages/search/search.component';
import { SignupComponent } from './pages/signup/signup.component';
import { ReviewComponent } from './pages/review/review.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'description/:id', component: DescriptionComponent },
  { path: 'post', component: PostComponent },
  { path: 'applicant/:username', component: ApplicantComponent },
  { path: 'recruiter/:username', component: RecruiterComponent },
  { path: 'apply/:id', component: ApplyComponent },
  { path: 'review/:id', component: ReviewComponent },
  { path: 'search', component: SearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
