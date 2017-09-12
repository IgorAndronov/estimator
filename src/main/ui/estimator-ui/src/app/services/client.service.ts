import { Injectable } from '@angular/core';
import {Client} from '../data/Client';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ClientsService {

  private url = 'http://localhost:8080/api/users/123';

  constructor(private http: Http) { }

  getClients(): Promise<Client[]> {
    return this.http.get(this.url)
      .toPromise()
      .then(this.handleResponse)
      .catch(this.handleError);
  }

  private handleResponse(response): Client[] {
    return response.json() as Client[];

  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }


}
