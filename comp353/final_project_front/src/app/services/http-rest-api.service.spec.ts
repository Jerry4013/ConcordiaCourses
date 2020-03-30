import { TestBed } from '@angular/core/testing';

import { HttpRestAPIService } from './http-rest-api.service';

describe('HttpRestAPIService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpRestAPIService = TestBed.get(HttpRestAPIService);
    expect(service).toBeTruthy();
  });
});
