import { TestBed } from '@angular/core/testing';

import { PlayingService } from './playing.service';

describe('PlayingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlayingService = TestBed.get(PlayingService);
    expect(service).toBeTruthy();
  });
});
