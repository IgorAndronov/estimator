import { Component, OnInit } from '@angular/core';
import {DomSanitizer, SafeStyle} from '@angular/platform-browser';
import {ClientsService} from '../services/client.service';
import {Client} from "../data/Client";
import {UserPresentationComponentComponent} from "../user-presentation-component/user-presentation-component.component";


@Component({
  selector: 'app-right-body-menu',
  templateUrl: './right-body-menu.component.html',
  styleUrls: ['./right-body-menu.component.css']

})
export class RightBodyMenuComponent implements OnInit {
  mainRightMenu= [];




  constructor(private sanitizer: DomSanitizer, private clientsService: ClientsService ) {
    console.info("!!!right-body-menu constructor");
    this.sanitizer = sanitizer;

  }

  ngOnInit() {
    console.info("!!!right-body-menu onInit");
    this.getExternalUsers();
  }

  getExternalUsers(): void {
    this.clientsService.getClientsIcons().then((clients) => {
      for (let client of clients){
        this.mainRightMenu.push({userId: client.userId,
                                  name: client.name,
                                 icon: this.sanitizer.bypassSecurityTrustStyle('url(' + client.urlIcon + ')')
                                });
        window.console.info( this.mainRightMenu);
      }

    });
  }

  onSelect(clientAvatar:Client): void {
    this.clientsService.getClientData(clientAvatar.userId).then((response) => {
       var userFotos =this.clientsService.getSelectedUserFotos();
      for (let entry of response.userFotos){

        userFotos.push({name: entry.info,
                             url: this.sanitizer.bypassSecurityTrustUrl(entry.url)
                            });

    }
      this.clientsService.setSelectedUserFotos(userFotos);
      var res2 = this.clientsService.getSelectedUserFotos();
    });
  }


}
