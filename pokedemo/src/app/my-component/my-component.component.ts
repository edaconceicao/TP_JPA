import { PokeDetail } from './../pokemon';
import { PokeAPIServiceService } from './../poke-apiservice.service';
import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../pokemon';
import { PokeShareService } from '../poke-share.service';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css'], 
  providers: [PokeAPIServiceService, PokeShareService]
})
export class MyComponentComponent implements OnInit {

  id: string = '';
  selectedPokemonId : string = '';
  searchPokemonName : string = '';
  pokeList : Pokemon[] = [];
  pokeDetail: PokeDetail;

  constructor(private pokeService : PokeAPIServiceService, 
    private pokeShare : PokeShareService) { 

  }

  ngOnInit(): void {
    this.pokeService.getPokemons().subscribe((data) => {
        data.results.forEach((e, index) => {
          this.pokeList.push(new Pokemon(index.toString(), e.name, e.url));
        });
      }
    );
  }

  go() : void{
    this.pokeShare.setValue(this.selectedPokemonId);
    if(this.selectedPokemonId != ''){
      let res = parseInt(this.selectedPokemonId)+1;
      this.pokeService.getPokemonInfo(res.toString()).subscribe(data => this.pokeDetail = data);
    }
  }
}
