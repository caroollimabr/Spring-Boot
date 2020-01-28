import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TituloComponent } from './componentes/titulo/titulo.component';
import { LoginComponent } from './componentes/login/login.component';
import { ListaComponent } from './componentes/lista/lista.component';
import { HomeComponent } from './componentes/home/home.component';
import { UsuarioService } from './servicos/usuario.service';

@NgModule({
  declarations: [
    AppComponent,
    TituloComponent,
    LoginComponent,
    ListaComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
