import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketDiscountFormComponent } from './ticket-discount-form.component';

describe('TicketDiscountFormComponent', () => {
  let component: TicketDiscountFormComponent;
  let fixture: ComponentFixture<TicketDiscountFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TicketDiscountFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketDiscountFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
