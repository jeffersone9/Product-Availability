import { Injectable } from '@angular/core';
import { Location } from '../shared/location.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LocationService {

  baseUrl: string = "http://54.167.119.38:8081/locations/";
  constructor(private http: HttpClient) { }

  getLocations(){
    return this.http.get(this.baseUrl);
  }

  getLocationById(id: Number): Observable<Location>{
    return this.http.get<Location>(this.baseUrl + id);
  }
}
