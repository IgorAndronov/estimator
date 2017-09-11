import { Injectable } from '@angular/core';
import {ExternalUser} from "../data/ExternalUser";
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class GetPhotosDashboardService {
  private url = 'http://localhost:8080/api/users/123';

  constructor(private http: Http) { }

  getPhotosDashboard(): Promise<ExternalUser[]> {
    return this.http.get(this.url)
      .toPromise()
      .then(this.handleResponse)
      .catch(this.handleError);
  }

  private handleResponse(response):ExternalUser[]{
    return response.json() as ExternalUser[];

  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }


}
