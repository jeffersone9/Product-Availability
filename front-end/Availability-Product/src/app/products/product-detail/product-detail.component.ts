import { Component, Input, OnInit } from '@angular/core';
import { Balance } from 'src/app/shared/balance.model';
import { Location } from 'src/app/shared/location.model';
import { Product } from 'src/app/shared/product.model';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  @Input() balance: Balance;
  product: Product;
  location: Location;
  imagePath: string;

  constructor() { }

  ngOnInit(): void {
    this.location = this.balance.getLocation();
    this.product = this.balance.getProduct();

    this.imagePath = "assets/products/" + this.product.getName() + ".jpg";
  }

}
