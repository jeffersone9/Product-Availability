import { Component, OnInit } from '@angular/core';
import { Balance } from 'src/app/shared/balance.model';
import { BalanceService } from '../balance.service';

@Component({
  selector: 'app-product-zipcode',
  templateUrl: './product-zipcode.component.html',
  styleUrls: ['./product-zipcode.component.css']
})
export class ProductZipcodeComponent implements OnInit {

  constructor(private balanceService:BalanceService) { }

  balances: Balance[];
  zipcode: string;
  distance: string;
  loading: boolean = true;

  ngOnInit(): void {
    this.zipcode = "71270";
    this.distance = "20";
    this.getBalances(this.zipcode, this.distance);
    
  }

  getBalances(zipcode: string, distance: string): void {
    this.loading = true;
    this.balanceService.getBalancesByNearestZipcode(zipcode, distance).subscribe(
      (response: Balance[]) =>{
        this.balances = response;
      }
    );
    this.loading = false;
  }

  changeZipcode(zipcode: string):void{
    this.zipcode = zipcode;
    this.getBalances(this.zipcode, this.distance);
  }

  changeDistance(distance: string): void{
    this.distance = distance;
    this.getBalances(this.zipcode, this.distance);
  }

}
