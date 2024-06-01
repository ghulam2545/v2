import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { StorageService } from '../services/storage.service';

@Injectable()
export class HttpClientInterceptor implements HttpInterceptor {
    constructor(private $localStorage: StorageService) {

    }

    intercept(req: HttpRequest<any>,
        next: HttpHandler): Observable<HttpEvent<any>> {

        const token = this.$localStorage.get("token");

        if (token == null) {
            return next.handle(req);
        }

        console.log('jwt token ' + token);
        if (token) {
            const cloned = req.clone({
                headers: req.headers.set("Authorization",
                    "Bearer " + token)
            });

            return next.handle(cloned);
        }
        else {
            return next.handle(req);
        }
    }
}