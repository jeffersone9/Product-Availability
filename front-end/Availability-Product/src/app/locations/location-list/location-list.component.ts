import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/shared/location.model';
import { LocationService } from '../location.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})
export class LocationListComponent implements OnInit {

  locations: Location[];
  loading : boolean = true;
  constructor(private locationService:LocationService) { }

  ngOnInit(): void {
    this.loading = true;
    this.locationService.getLocations().subscribe(
      (response:any) =>{
        this.loading = false;
        this.locations = response;
      }
    )
  }

}
