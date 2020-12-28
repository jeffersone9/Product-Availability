import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Zipcode } from '../shared/zipcode.model';

@Injectable({
  providedIn: 'root'
})
export class ZipcodeService {

  baseUrl: string = "http://api.geonames.org/findNearbyPostalCodesJSON?formatted=true&postalcode="
  constructor(private http: HttpClient) { }

  getNearestZipcodes(zipcode:string, distance:string){
    return this.http.get<Zipcode[]>(this.baseUrl + zipcode + "&country=US&radius=" + distance + "&username=jeffersone9&style=full")
    .pipe(map((responseData) =>{
      const zipcodes = [];
      for(const key in  responseData){
        if(responseData.hasOwnProperty(key)){
          zipcodes.push(responseData[key]);
        }
      }
      return zipcodes;
    }));
  }
}
