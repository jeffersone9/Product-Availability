import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/shared/product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  loading: boolean = true;
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
     this.loading = true;
     this.productService.getProducts().subscribe(
       (response:any)=> {
         this.loading = false;
         this.products = response;
         console.log(response);
       }
     );
  }

}
