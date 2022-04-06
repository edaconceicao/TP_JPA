import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PokeShareService {

  value : string ; 
  constructor() { }

  setValue(value : string){
    this.value = value;
  }
  
  getValue() : string{
    return this.value ; 
  }
}
