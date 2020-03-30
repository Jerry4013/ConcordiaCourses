import { TestBed } from '@angular/core/testing';

import { PostRepoService } from './post-repo.service';

describe('PostRepoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PostRepoService = TestBed.get(PostRepoService);
    expect(service).toBeTruthy();
  });
});
