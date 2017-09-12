import { Component, OnInit } from '@angular/core';
import {DomSanitizer, SafeStyle} from '@angular/platform-browser';
import {ClientsService} from '../services/client.service';


@Component({
  selector: 'app-right-body-menu',
  templateUrl: './right-body-menu.component.html',
  styleUrls: ['./right-body-menu.component.css'],
  providers: [ClientsService]
})
export class RightBodyMenuComponent implements OnInit {
  mainRightMenu= [];


  constructor(private sanitizer: DomSanitizer, private clientsService: ClientsService ) {
    this.sanitizer = sanitizer;

  }

  ngOnInit() {
    this.getExternalUsers();
  }

  getExternalUsers(): void {
    this.clientsService.getClients().then((response) => {
      for (let entry of response){
        this.mainRightMenu.push({name: entry.name,
                                 icon: this.sanitizer.bypassSecurityTrustStyle('url(' + entry.urlIcon + ')')
                                });
        window.console.info( this.mainRightMenu);
      }

    });
  }



}
