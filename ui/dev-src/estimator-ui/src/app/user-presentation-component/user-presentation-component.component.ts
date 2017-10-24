import {Component, Input, OnInit, Output} from '@angular/core';
import {DomSanitizer, SafeStyle} from '@angular/platform-browser';
import {ClientsService} from '../services/client.service';


@Component({
  selector: 'app-user-presentation-component',
  templateUrl: './user-presentation-component.component.html',
  styleUrls: ['./user-presentation-component.component.css']
})
export class UserPresentationComponentComponent implements OnInit {
   userFotos= [];


  constructor(private sanitizer: DomSanitizer, private clientsService: ClientsService ) {
    console.info("!!!right-body-menu constructor");
    this.sanitizer = sanitizer;

  }

  ngOnInit() {
    this.userFotos=this.clientsService.getSelectedUserFotos();
    window.console.info("!!! this = "+this);
  }





}
