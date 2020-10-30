import { Component, OnInit } from '@angular/core';
import { Balance } from 'src/app/shared/balance.model';
import { Product } from 'src/app/shared/product.model';
import { BalanceService } from '../balance.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-available',
  templateUrl: './product-available.component.html',
  styleUrls: ['./product-available.component.css']
})

export class ProductAvailableComponent implements OnInit {

  balances : Balance[];
  available: Product[] = [];
  private productService: ProductService;

  constructor(private balanceService: BalanceService, private service:ProductService) { 
    this.productService = service;
  }

  ngOnInit(): void {
    this.balanceService.getBalances().subscribe(
      (response: any) => {
          this.balances = response;
          this.balances.forEach(this.addToAvailable);
      }
    )
    
  }

  addToAvailable(item:Balance){
    console.log(item);
    if(item.balance > 0){
      this.productService.getProductsById(item.productId).subscribe(
        (response:any) =>{
          console.log(response);
        }
      )
      //this.available.push(item.getProduct());
    }
  }

}
