import { CardModule } from 'primeng/card';
import { RouterModule, Routes } from '@angular/router';
import { AgendamentoModuleModule } from './agendamentos/agendamento-module.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { AgendamentoPesquisaComponent } from './agendamentos/agendamento-pesquisa/agendamento-pesquisa.component';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';

registerLocaleData(localePt);

const routes: Routes = [

  { path: 'agendamentos', component: AgendamentoPesquisaComponent }
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes),

    AgendamentoModuleModule,
    CardModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
