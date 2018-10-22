import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { Transaction } from '../Model/Tranasaction';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  baseUrl: string;

  constructor(private http: Http) {
    this.baseUrl = "http://localhost:9191/myInfo/trans";
  }

  getAllTransactions(): Observable<Transaction[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  
  getTransactionByYearAndMonth(month:number,year:number):Observable<Transaction[]>{
    return this.http.get(this.baseUrl+"/"+month+"/"+year).pipe(
      map(data => data.json())
    );
  }
}
