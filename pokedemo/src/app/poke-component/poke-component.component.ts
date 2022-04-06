import { PokeDetail } from './../pokemon';
import { Component, Input, OnInit } from '@angular/core';
import { PokeShareService } from '../poke-share.service';

@Component({
  selector: 'app-poke-component',
  templateUrl: './poke-component.component.html',
  styleUrls: ['./poke-component.component.css'], 
  providers : [PokeShareService]
})
export class PokeComponentComponent implements OnInit {

  @Input('detail')
  details : PokeDetail;
  
  constructor(private pokeShare : PokeShareService) { }

  ngOnInit(): void {
    console.log(this.pokeShare.getValue());
  }

}
