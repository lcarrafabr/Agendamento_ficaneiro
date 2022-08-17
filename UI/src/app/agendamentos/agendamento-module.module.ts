import { AgendamentoCadastroComponent } from './agendamento-cadastro/agendamento-cadastro.component';
import { TableModule } from 'primeng/table';
import { AgendamentoPesquisaComponent } from './agendamento-pesquisa/agendamento-pesquisa.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardModule } from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {CalendarModule} from 'primeng/calendar';
import {InputNumberModule} from 'primeng/inputnumber';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AgendamentoPesquisaComponent,
    AgendamentoCadastroComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    CardModule,
    TableModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    CalendarModule,
    InputNumberModule,
    HttpClientModule
  ]
})
export class AgendamentoModuleModule { }
