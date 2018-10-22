import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SubscriberService } from '../Service/subscriber.service';
import { Customers } from '../Model/Customers';

@Component({
  selector: 'app-edit-details',
  templateUrl: './edit-details.component.html',
  styleUrls: ['./edit-details.component.css']
})
export class EditDetailsComponent implements OnInit {

  customer: Customers;
  constructor(private activatedRoute: ActivatedRoute, private subsServ: SubscriberService, private router: Router) { }

  ngOnInit() {

    this.activatedRoute.params.subscribe(
      (params) => {
        let rmn = params['rmn'];
        if (rmn) {
          this.subsServ.getSubscriberByRmn(rmn).subscribe(
            (data) => {
              this.customer = data;
              //this.isEditing = true;
            }
          );
        }
      }
    );
  }

  save() {
    this.subsServ.updateSubscriber(this.customer).subscribe(
      (data) => {
        this.router.navigateByUrl("/");
      }
    );
  }

}
