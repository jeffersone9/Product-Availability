import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocationListComponent } from './locations/location-list/location-list.component';
import { ProductListComponent } from './products/product-list/product-list.component';
import { HomeComponent } from './home/home.component';
import { ProductAvailableComponent } from './products/product-available/product-available.component';
import { ProductZipcodeComponent } from './products/product-zipcode/product-zipcode.component';
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'locations', component: LocationListComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'available', component: ProductAvailableComponent},
  { path: 'nearest', component: ProductZipcodeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
