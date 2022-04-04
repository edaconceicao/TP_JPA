import { PokeAPIServiceService } from './../poke-apiservice.service';
import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../pokemon';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css'], 
  providers: [PokeAPIServiceService]
})
export class MyComponentComponent implements OnInit {

  id: string = '';
  selectedPokemonId : string = '';
  searchPokemonName : string = '';
  pokeList : Pokemon[] = [];

  constructor(private pokeService : PokeAPIServiceService) { 

  }

  ngOnInit(): void {
    this.pokeService.getPokemons().subscribe((data) => {
        data.results.forEach((e, index) => {
          this.pokeList.push(new Pokemon(''+index, e.name, e.url));
        });
      }
    );
  }

  go() : void{
    console.log(this.selectedPokemonId)
  }
}
