import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { catchError, retry } from 'rxjs/operators'
import { throwError } from 'rxjs';
import { Customer } from './customer';
@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {

  private _url: string= "http://localhost:8020/LoanMVCProj";
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getCustomer():Observable<Customer[]>
  {
    return this.http.get<Customer[]>(this._url+'');
  }
  createCustomer(customer: any): Observable<Customer> {
    console.log(customer);
    return this.http.post<Customer>(this._url + '/customer/create', JSON.stringify(customer), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));

  }
  loginCustomer(customerId:string):Observable<Customer>{
    return this.http.get<Customer>(this._url+'/customer/getCustomer/'+customerId);
  }
  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code : ${error.status} \n  Error Message : ${error.message}`
    }
    window.alert(errorMessage);
    return throwError(errorMessage);

  }
}
