import { AgendamentoTransferencia } from './../core/model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {

  agendamentoURL = 'http://localhost:8080/agendamentos'

  constructor(
    private http: HttpClient
  ) { }

  listarTodos(): Promise<any> {

    return this.http.get(`${this.agendamentoURL}`)
    .toPromise()
    .then(response => response);
  }

//

cadastrarAgendamento(agendamento: AgendamentoTransferencia): Promise<AgendamentoTransferencia> {

  return this.http.post<AgendamentoTransferencia>(`${this.agendamentoURL}`, agendamento).toPromise();
}

}
