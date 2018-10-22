import { Component } from '@angular/core';
import { Customers } from './Model/Customers';
import { SubscriberService } from './Service/subscriber.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Profile';

  rmn: number = 8591321751;
  myaccountinfo: Customers;

  ladyLogo: string;
  gentLogo: string;
  constructor(private subsriberserv: SubscriberService) {
    this.ladyLogo = "/assets/img_avatar2.png";
    this.gentLogo = "/assets/avatar2.png";
  }

  ngOnInit() {
    this.subsriberserv.getSubscriberByRmn(this.rmn).subscribe(
      data => this.myaccountinfo = data
    );

  }

  func() {
    console.log("Poo");
  }
}

