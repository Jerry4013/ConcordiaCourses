import { TestBed } from '@angular/core/testing';

import { GroupRepoService } from './group-repo.service';

describe('GroupRepoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GroupRepoService = TestBed.get(GroupRepoService);
    expect(service).toBeTruthy();
  });
});
