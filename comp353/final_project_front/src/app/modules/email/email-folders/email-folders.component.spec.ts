import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailFoldersComponent } from './email-folders.component';

describe('EmailFoldersComponent', () => {
  let component: EmailFoldersComponent;
  let fixture: ComponentFixture<EmailFoldersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmailFoldersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailFoldersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
