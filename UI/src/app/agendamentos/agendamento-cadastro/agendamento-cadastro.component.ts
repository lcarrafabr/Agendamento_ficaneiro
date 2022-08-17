import { AgendamentoService } from './../agendamento.service';
import { AgendamentoTransferencia } from './../../core/model';
import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm  } from '@angular/forms';

@Component({
  selector: 'app-agendamento-cadastro',
  templateUrl: './agendamento-cadastro.component.html',
  styleUrls: ['./agendamento-cadastro.component.css']
})
export class AgendamentoCadastroComponent implements OnInit {

  agendamento = new AgendamentoTransferencia;

  constructor(
    private agendamentoService: AgendamentoService
  ) { }

  ngOnInit(): void {


  }

  cadastrarCategoria(form: FormControl) {

    this.agendamentoService.cadastrarAgendamento(this.agendamento)
    .then(() => {
      //this.messageService.add({ severity: 'success', detail: 'Categoria cadastrada com sucesso!', closable: false });
      form.reset();
      this.agendamento = new AgendamentoTransferencia;
    });
    //.catch(erro => this.errorHandler.handle(erro));
  }


}
