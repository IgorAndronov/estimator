import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppComponent } from './app.component';
import { LeftBodyMenuComponent } from './left-body-menu/left-body-menu.component';
import { RightBodyMenuComponent } from './right-body-menu/right-body-menu.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {MdNativeDateModule} from '@angular/material';
import {AppMaterialComponentsModule} from './app-material-components/app-material-components.module';


@NgModule({
  declarations: [
    AppComponent,
    LeftBodyMenuComponent,
    RightBodyMenuComponent
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    MdNativeDateModule,
    ReactiveFormsModule,
    AppMaterialComponentsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
