import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-active-plans',
  templateUrl: './active-plans.component.html',
  styleUrls: ['./active-plans.component.css']
})
export class ActivePlansComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  func(){
    console.log("Redirected to URL")
  }
}
