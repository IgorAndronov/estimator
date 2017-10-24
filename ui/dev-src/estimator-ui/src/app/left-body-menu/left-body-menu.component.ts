import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-left-body-menu',
  templateUrl: './left-body-menu.component.html',
  styleUrls: ['./left-body-menu.component.css']
})
export class LeftBodyMenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  mainLeftMenu = [
    {
      name: 'My page',
      icon: 'account_circle'
    },
    {
      name: 'News',
      icon: 'local_library'
    },
    {
      name: 'Messages',
      icon: 'message'
    },
    {
      name: 'Friends',
      icon: 'people'
    }

  ];
  photoMenu = [
    {
      name: 'Photo estimate',
      icon: 'camera_alt'
    },
    {
      name: 'Best photo',
      icon: 'thumb_up'
    },
    {
      name: 'Photo concurs',
      icon: 'camera_alt'
    },
  ];


}
