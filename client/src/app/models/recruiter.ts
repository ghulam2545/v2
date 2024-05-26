import { Application } from "./application";
import { Job } from "./job";

export interface Recruiter {
    id: number,
    fullname: string,
    email: string,
    password: string,
    contact: string,
    company: string,
    speciality: string,
    jobs: Job[],
    applications: Application[]
}