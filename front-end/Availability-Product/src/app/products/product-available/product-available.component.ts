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
  loading : boolean = true;
  location : number = 1;
  constructor(private balanceService: BalanceService) { 
    
  }

  ngOnInit(): void {
    this.loading = true;
    this.balanceService.getBalances().subscribe(
      (response: Balance[]) => {
          this.loading = false;
          this.balances = response;
      }
    )
    
  }

  changeLocation(input: number){
    this.location = input;
  }


}
