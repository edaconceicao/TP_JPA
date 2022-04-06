import { TestBed } from '@angular/core/testing';

import { PokeShareService } from './poke-share.service';

describe('PokeShareService', () => {
  let service: PokeShareService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PokeShareService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
