import { BrowserModule } from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppComponent } from './app.component';
import { LeftBodyMenuComponent } from './left-body-menu/left-body-menu.component';
import { RightBodyMenuComponent } from './right-body-menu/right-body-menu.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppMaterialComponentsModule} from './app-material-components/app-material-components.module';
import { UserPresentationComponentComponent } from './user-presentation-component/user-presentation-component.component';



@NgModule({
  declarations: [
    AppComponent,
    LeftBodyMenuComponent,
    RightBodyMenuComponent,
    UserPresentationComponentComponent
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    AppMaterialComponentsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
