import { Application } from "./application";

export interface Applicant {
    id: number,
    fullname: string,
    username: string,
    email: string,
    password: string,
    contact: string,
    skills: string,
    applications: Application[]
}