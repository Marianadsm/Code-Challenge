import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  private apiUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) {}


  calculateDiscount(ticketType: string, weekDay: string, hasStudentCard: boolean): Observable<number> {
    const params = new HttpParams()
      .set('type', ticketType)
      .set('weekDay', weekDay)
      .set('hasStudentCard', hasStudentCard);

    return this.http.get<number>(`${this.apiUrl}/calculateDiscount`, { params });
  }
}
