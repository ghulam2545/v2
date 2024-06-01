import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { DescriptionComponent } from './pages/description/description.component';
import { ApplyComponent } from './pages/apply/apply.component';
import { PostComponent } from './pages/post/post.component';
import { ApplicantComponent } from './pages/applicant/applicant.component';
import { RecruiterComponent } from './pages/recruiter/recruiter.component';
import { SearchComponent } from './pages/search/search.component';
import { ReviewComponent } from './pages/review/review.component';
import { RouterLink } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientInterceptor } from './utils/http-client-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DescriptionComponent,
    ApplyComponent,
    PostComponent,
    ApplicantComponent,
    RecruiterComponent,
    SearchComponent,
    ReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterLink,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
