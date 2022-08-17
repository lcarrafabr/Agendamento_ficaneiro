import { AgendamentoService } from './../agendamento.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agendamento-pesquisa',
  templateUrl: './agendamento-pesquisa.component.html',
  styleUrls: ['./agendamento-pesquisa.component.css']
})
export class AgendamentoPesquisaComponent implements OnInit {

  agendamentos = [];
  display: boolean;

  constructor(
    private agendamentoService: AgendamentoService
  ) { }

  ngOnInit(): void {
    this.listarTodosAgendamentos();

    //this.showModalDialog();
  }

  listarTodosAgendamentos() {

    this.agendamentoService.listarTodos()
    .then(response => {
      this.agendamentos = response;
      console.log(response);
    });
  }

  showModalDialog() {
    this.display = true;
}

}
