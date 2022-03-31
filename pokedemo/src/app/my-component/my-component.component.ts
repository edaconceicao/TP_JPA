import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../pokemon';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css']
})
export class MyComponentComponent implements OnInit {

  id: string = '';
  selectedPokemonId : string = '';
  searchPokemonName : string = '';
  pokeList : Pokemon[] = [];

  constructor() { 
    this.pokeList.push(new Pokemon('1','Pikachu'));
    this.pokeList.push(new Pokemon('2','Liputu'));
    this.pokeList.push(new Pokemon('3','Laporeille'));
    this.pokeList.push(new Pokemon('4','Lixy'));
    this.pokeList.push(new Pokemon('5','Ouisticram'));
  }

  ngOnInit(): void {
  }

}
