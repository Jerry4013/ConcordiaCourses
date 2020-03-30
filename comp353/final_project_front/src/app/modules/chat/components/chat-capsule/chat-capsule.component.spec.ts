import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatCapsuleComponent } from './chat-capsule.component';

describe('ChatCapsuleComponent', () => {
  let component: ChatCapsuleComponent;
  let fixture: ComponentFixture<ChatCapsuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChatCapsuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatCapsuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
