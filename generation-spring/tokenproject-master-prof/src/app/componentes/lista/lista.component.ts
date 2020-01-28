import { Component, OnInit } from '@angular/core';
import { AlunosService } from 'src/app/servicos/alunos.service';
import { Aluno } from 'src/app/model/Aluno';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  public listaAlunos: Aluno[];
  constructor(private srv: AlunosService, private router: Router) { }

  ngOnInit() {
    this.srv.getAll().subscribe(
    (res: Aluno[])=>{
        this.listaAlunos = res;
    },
    (err)=>{
      alert("Nao autenticado!!");
      this.router.navigate(["/login"]);
    });
  }

}
