import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { ActivePlansComponent } from './active-plans/active-plans.component';
import { MonthlyBillingComponent } from './monthly-billing/monthly-billing.component';

const routeMap:Routes=[
  {path:'',component:MyProfileComponent},
  {path:'ap', component:ActivePlansComponent},
  {path:'mb',component:MonthlyBillingComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MyProfileComponent,
    ActivePlansComponent,
    MonthlyBillingComponent,
   
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routeMap),
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
