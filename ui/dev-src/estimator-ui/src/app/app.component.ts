import { Component } from '@angular/core';
import {ClientsService} from "./services/client.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ClientsService]
})
export class AppComponent {
  title = 'app';
}
