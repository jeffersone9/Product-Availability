import { Product } from './product.model';
import { Location } from './location.model'
import { LocationService } from '../locations/location.service';
import { ProductService } from '../products/product.service';
import { Observable } from 'rxjs';
export class Balance{
    id: number;
    balance: number;
    productId: number;
    locationId: number;
    product: Product;
    location: Location;

    constructor(id: number, balance: number,  product: Product, location: Location){
        this.id = id;
        this.balance = balance;
        this.product = product;
        this.location = location;
    }

    public getId():Number{
        return this.id;
    }

    public setId(id:number){
        this.id = id;
    }

    public getBalance():number{
        return this.balance;
    }

    public setBalance(balance:number){
        this.balance = balance;
    }

    public getProduct():Product{
        
        return this.product;
    }

    public getLocation():Location{
        return this.location;
    }
}
