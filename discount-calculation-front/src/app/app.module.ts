import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AppComponent } from './app.component';
import { TicketDiscountFormComponent } from './ticket-discount-form/ticket-discount-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import localePt from '@angular/common/locales/pt'; 
import { registerLocaleData } from '@angular/common';
import { LOCALE_ID } from '@angular/core'; 
registerLocaleData(localePt); 

@NgModule({
  declarations: [AppComponent, TicketDiscountFormComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, NgbModule, MatSnackBarModule],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' }, 
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
