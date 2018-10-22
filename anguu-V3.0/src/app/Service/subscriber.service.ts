import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
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

  getSubscriberByRmn(rmn: number): Observable<Customers> {
    return this.http.get(this.baseUrl + "/" + rmn).pipe(
      map(data => data.json())
    );
  }


  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }


  updateSubscriber(customer: Customers): Observable<Customers> {
    return this.http.put(this.baseUrl, JSON.stringify(customer), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

}
