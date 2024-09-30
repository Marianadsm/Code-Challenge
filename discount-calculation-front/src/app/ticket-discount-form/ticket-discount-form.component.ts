import { Component } from '@angular/core';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-ticket-discount-form',
  templateUrl: './ticket-discount-form.component.html',
  styleUrls: ['./ticket-discount-form.component.css'],
})
export class TicketDiscountFormComponent {
  ticketType: string = '';
  weekDay: string = '';
  hasStudentCard: boolean = false;
  finalPrice?: number;
  errorMessage: string = '';
  modalOpen: boolean = false;
  finalModalOpen: boolean = false;

  constructor(private ticketService: TicketService) {}

  selectTicketType(type: string) {
    this.ticketType = type;
    this.openModal();
  }

  openModal() {
    this.weekDay = '';
    this.modalOpen = true;
  }

  closeModal() {
    this.modalOpen = false;
  }

  closeFinalModal() {
    this.finalModalOpen = false;
  }

  confirmSelection() {
    if (!this.weekDay) {
      this.errorMessage = 'Por favor, selecione um dia da semana.';
      return;
    }

    this.modalOpen = false;
    this.calculateDiscount();
  }

  calculateDiscount() {
    this.ticketService
      .calculateDiscount(this.ticketType, this.weekDay, this.hasStudentCard)
      .subscribe(
        (price: number) => {
          this.finalPrice = price;
          this.errorMessage = '';
          this.showFinalModal();
        },
        (error) => {
          this.errorMessage =
            'Erro ao calcular o desconto. Verifique os parâmetros.';
          this.finalPrice = undefined;
        }
      );
  }

  showFinalModal() {
    this.finalModalOpen = true;
  }
}
