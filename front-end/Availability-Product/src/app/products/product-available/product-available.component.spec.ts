import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductAvailableComponent } from './product-available.component';

describe('ProductAvailableComponent', () => {
  let component: ProductAvailableComponent;
  let fixture: ComponentFixture<ProductAvailableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductAvailableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductAvailableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
