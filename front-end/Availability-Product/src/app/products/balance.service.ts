import { Location } from '../shared/location.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LocationService } from '../locations/location.service';
import { Balance } from '../shared/balance.model';
import { Product } from '../shared/product.model';
import { ProductService } from './product.service';
import { ZipcodeService } from '../locations/zipcode.service';
import { Zipcode } from '../shared/zipcode.model';
@Injectable({
  providedIn: 'root'
})
export class BalanceService {

  baseUrl: string = "http://localhost:8083/balances/"
  constructor(private http: HttpClient, private productService: ProductService,
    private locationService: LocationService, private zipcodeService: ZipcodeService) { }

  products: Product[];
  locations: Location[]
  balances: Balance[];
  zipcodes: Zipcode[];

  getBalances(){
    this.productService.getProducts().subscribe(
      (response:any) =>{
        this.products = response;
      }
    )
    this.locationService.getLocations().subscribe(
      (response:any) =>{
        this.locations = response;
      }
    )
    return this.http.get<Balance[]>(this.baseUrl)
    .pipe(map((responseData)=>{
      const balanceArray = [];
      for(const key in responseData){
        if(responseData.hasOwnProperty(key)){
          balanceArray.push(new Balance(responseData[key].id, responseData[key].balance, this.products[responseData[key].productId - 1], this.locations[responseData[key].locationId - 1]))
        }
      }
      return balanceArray;
    }));
  }

  getBalancesByNearestZipcode(zipcode: string, distance: string){
    this.productService.getProducts().subscribe(
      (response:any) =>{
        this.products = response;
      }
    )
    this.locationService.getLocations().subscribe(
      (response:any) =>{
        this.locations = response;
      }
    )
    this.zipcodeService.getNearestZipcodes(zipcode, distance).subscribe(
      (response:Zipcode[]) =>{
        this.zipcodes = response;
      }
    )
    return this.http.get<Balance[]>(this.baseUrl)
    .pipe(map((responseData)=>{
      const balanceArray = [];
      for(const key in responseData){
        if(responseData.hasOwnProperty(key)){
          for(const code in this.zipcodes){
            if(this.zipcodes[0][code].postalCode == this.locations[responseData[key].locationId - 1].zipcode){
              balanceArray.push(new Balance(responseData[key].id, responseData[key].balance, this.products[responseData[key].productId - 1], this.locations[responseData[key].locationId - 1]));
            }
          }
        }
      }
      return balanceArray;
    }));
  }
  getBalancesById(id:Number):Observable<Balance>{
    return this.http.get<Balance>(this.baseUrl + id);
  }
}
