import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Customers } from '../Model/Customers';

@Injectable({
  providedIn: 'root'
})
export class SubscriberService {

  baseUrl: string;

  constructor(private http: Http) {
    this.baseUrl = "http://localhost:9191/myInfo";
  }

  getSubscriberByRmn(rmn:number): Observable<Customers> {
    return this.http.get(this.baseUrl+"/"+rmn).pipe(
      map(data => data.json())
    );
  }

}
