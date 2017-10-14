import { Component, OnInit } from '@angular/core';
import {DomSanitizer, SafeStyle} from '@angular/platform-browser';
import {ClientsService} from '../services/client.service';


@Component({
  selector: 'app-user-presentation-component',
  templateUrl: './user-presentation-component.component.html',
  styleUrls: ['./user-presentation-component.component.css'],
  providers: [ClientsService]
})
export class UserPresentationComponentComponent implements OnInit {
  userFotos= [];

  constructor(private sanitizer: DomSanitizer, private clientsService: ClientsService ) {
    console.info("!!!right-body-menu constructor");
    this.sanitizer = sanitizer;

  }

  ngOnInit() {
    this.getUserFoto('1');
  }

  getUserFoto(userId): void {
    this.clientsService.getClientData(userId).then((response) => {
      for (let entry of response.userFotos){
        this.userFotos.push({name: entry.info,
          url: this.sanitizer.bypassSecurityTrustUrl(entry.url)
        });
        window.console.info( this.userFotos);
      }

    });
  }



}
