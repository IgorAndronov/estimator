import { Component, OnInit } from '@angular/core';
import {DomSanitizer, SafeStyle} from "@angular/platform-browser";
import {GetPhotosDashboardService} from "../services/get-photos-dashboard.service";

@Component({
  selector: 'app-right-body-menu',
  templateUrl: './right-body-menu.component.html',
  styleUrls: ['./right-body-menu.component.css'],
  providers:[GetPhotosDashboardService]
})
export class RightBodyMenuComponent implements OnInit {
  mainRightMenu=[];


  constructor(private sanitizer: DomSanitizer, private photosDashboardService:GetPhotosDashboardService ) {
    this.sanitizer=sanitizer;

  }

  ngOnInit() {
    this.getExternalUsers();
  }

  getExternalUsers():void{
    this.photosDashboardService.getPhotosDashboard().then((response)=>{
      for(let entry of response){
        this.mainRightMenu.push({name:entry.name,
                                 icon: this.sanitizer.bypassSecurityTrustStyle('url(' + entry.urlIcon + ')')
                                });
      }

    });
  }



  // mainRightMenu = [
  //   {
  //     name: 'Marina',
  //     icon: this.sanitizer.bypassSecurityTrustStyle('url(' + '../../assets/ng1.jpg' + ')')
  //   },
  //
  //   {
  //     name: 'Marina',
  //     icon: this.sanitizer.bypassSecurityTrustStyle('url(' + '../../assets/ng2.jpg' + ')')
  //   },
  //   {
  //     name: 'Marina',
  //     icon: this.sanitizer.bypassSecurityTrustStyle('url(' + '../../assets/ng3.jpg' + ')')
  //   },
  //   {
  //     name: 'Marina',
  //     icon: this.sanitizer.bypassSecurityTrustStyle('url(' + '../../assets/ng4.jpg' + ')')
  //   },
  //   {
  //     name: 'Marina',
  //     icon: this.sanitizer.bypassSecurityTrustStyle('url(' + '../../assets/ng5.jpg' + ')')
  //   }
  //
  // ];


}
