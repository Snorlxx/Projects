import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { ActivePlansComponent } from './active-plans/active-plans.component';
import { MonthlyBillingComponent } from './monthly-billing/monthly-billing.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { EditDetailsComponent } from './edit-details/edit-details.component';

const routeMap:Routes=[
  {path:'',component:MyProfileComponent},
  {path:'ap', component:ActivePlansComponent},
  {path:'mb',component:MonthlyBillingComponent},
  {path:'ed/:rmn',component:EditDetailsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MyProfileComponent,
    ActivePlansComponent,
    MonthlyBillingComponent,
    EditDetailsComponent,
   
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routeMap),
    FormsModule, 
    HttpModule,AngularFontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
