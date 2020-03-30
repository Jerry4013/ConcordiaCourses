import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatBottomWindowComponent } from './chat-bottom-window.component';

describe('ChatBottomWindowComponent', () => {
  let component: ChatBottomWindowComponent;
  let fixture: ComponentFixture<ChatBottomWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChatBottomWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatBottomWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
