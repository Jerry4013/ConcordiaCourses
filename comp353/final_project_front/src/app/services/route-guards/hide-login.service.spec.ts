import { TestBed } from '@angular/core/testing';

import { HideLoginService } from './hide-login.service';

describe('HideLoginService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HideLoginService = TestBed.get(HideLoginService);
    expect(service).toBeTruthy();
  });
});
