import { Injectable } from '@angular/core';
import {Client} from '../data/Client';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ClientsService {

  private userFotos= [];

  private url = 'http://localhost:8080/api/';

  constructor(private http: Http) { }

  getClientsIcons(): Promise<Client[]> {
    return this.http.get(this.url + "users/")
      .toPromise()
      .then(this.handleResponse)
      .catch(this.handleError);
  }

  getClientData(userId): Promise<Client> {
    return this.http.get(this.url + "users/get/" + userId)
      .toPromise()
      .then(this.handleResponseSingle)
      .catch(this.handleError);
  }

  private handleResponse(response): Client[] {
    return response.json() as Client[];

  }

  private handleResponseSingle(response): Client {
    return response.json() as Client;

  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  getSelectedUserFotos(){
    return this.userFotos;
  }


  setSelectedUserFotos(userFotos) {
    this.userFotos = userFotos;
  }
}
