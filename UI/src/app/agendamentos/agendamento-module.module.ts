import { TableModule } from 'primeng/table';
import { AgendamentoPesquisaComponent } from './agendamento-pesquisa/agendamento-pesquisa.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardModule } from 'primeng/card';
import {ButtonModule} from 'primeng/button';



@NgModule({
  declarations: [
    AgendamentoPesquisaComponent
  ],
  imports: [
    CommonModule,
    CardModule,
    TableModule,
    ButtonModule
  ]
})
export class AgendamentoModuleModule { }
