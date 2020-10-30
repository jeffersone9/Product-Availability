import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Balance } from '../shared/balance.model';
@Injectable({
  providedIn: 'root'
})
export class BalanceService {

  baseUrl: string = "http://localhost:8083/balances/"
  constructor(private http: HttpClient) { }

  getBalances(){
    return this.http.get(this.baseUrl);
  }

  getBalancesById(id:Number):Observable<Balance>{
    return this.http.get<Balance>(this.baseUrl + id);
  }
}
