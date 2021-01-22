import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../shared/product.model';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  baseUrl: string = "http://34.207.143.25:8082/products/"
  productList: Product[];

  constructor(private http: HttpClient) { }

  getProducts(){
    return this.http.get<Product[]>(this.baseUrl)
    .pipe(map((responseData) => {
      const productArray = [];
      for(const key in responseData){
        if(responseData.hasOwnProperty(key)){

          productArray.push(responseData[key])
        }
      }
      return productArray;
    }));
  }

  getProductsById(id: Number) {
    return this.http.get<Product>(this.baseUrl + id)
    .pipe(map((responseData) => {
      return responseData;
    }));
  }
}
