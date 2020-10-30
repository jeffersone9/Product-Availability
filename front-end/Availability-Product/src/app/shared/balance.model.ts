import { Product } from './product.model';
import { Location } from './location.model'
import { LocationService } from '../locations/location.service';
import { ProductService } from '../products/product.service';
import { Observable } from 'rxjs';
export class Balance{
    id: Number;
    balance: Number;
    productId: Number;
    locationId: Number;
    product: Product;
    location: Location;

    constructor(private locationService:LocationService, private productService:ProductService){
        locationService.getLocationById(this.locationId).subscribe(
            (response:any) =>{
                this.location = response;
            }
        )

        productService.getProductsById(this.productId).subscribe(
            (response: any) => {
                this.product = response;
            }
        )
    }

    public getId():Number{
        return this.id;
    }

    public setId(id:Number){
        this.id = id;
    }

    public getBalance():Number{
        return this.balance;
    }

    public setBalance(balance:Number){
        this.balance = balance;
    }

    public getProductId():Number{
        return this.productId;
    }

    public setProductId(product:Number){
        this.productId = product;
    }

    public getLocationId():Number{
        return this.locationId;
    }

    public setLocation(locationId:Number){
        this.locationId = locationId;
    }

    public getProduct():Product{
        this.productService.getProductsById(this.productId).subscribe(
            (response: Product) => {
                return response;
            }
        );
        return null;
    }

    public getLocation():Location{
        this.locationService.getLocationById(this.locationId).subscribe(
            (response: Location) => {
                return response;
            }
        );
        return null;
    }
}
