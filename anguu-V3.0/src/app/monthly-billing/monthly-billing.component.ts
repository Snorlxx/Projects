import { Component, OnInit } from '@angular/core';
//import { FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { SubscriberService } from '../Service/subscriber.service';
import { Transaction } from '../Model/Tranasaction';
import { TransactionService } from '../Service/transaction.service';
@Component({
  selector: 'app-monthly-billing',
  templateUrl: './monthly-billing.component.html',
  styleUrls: ['./monthly-billing.component.css']
})


export class MonthlyBillingComponent implements OnInit {

  searchMonth: number = 0;
  searchYear: number = 0;
  searched: boolean;
  transactions: Transaction[];
  // months=['January','February','March','April','May','June','July','August','September','October','November','December'];
  constructor(private router: Router, private activatedRoute: ActivatedRoute, private transServ: TransactionService) {

  }


  ngOnInit() {
    this.searched = false;
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        let month = params['month'];
        let year = params['year'];

        if (month && year) {
          this.transServ.getTransactionByYearAndMonth(month, year).subscribe(
            (data) => this.transactions = data,
            (err) => this.transactions = undefined
          );
          this.searched = true;
        }
        else {
          //Fetch the transaction list HERE
          this.transServ.getAllTransactions().subscribe(
            (data) => this.transactions = data,
            (err) => this.transactions = undefined
          );
        }
      });
  }

  doSearch() {
    this.router.navigate(["/mb"], { queryParams: { month: this.searchMonth, year: this.searchYear } });
    console.log(this.searchMonth + "Year" + this.searchYear)
  }
}
