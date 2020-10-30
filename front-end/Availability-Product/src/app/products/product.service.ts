import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../shared/product.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  baseUrl: string = "http://localhost:8082/products/"
  constructor(private http: HttpClient) { }

  getProducts(){
    return this.http.get(this.baseUrl);
  }

  getProductsById(id: Number): Observable<Product> {
    return this.http.get<Product>(this.baseUrl + id);
  }
}
