import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateStoryNewComponent } from './create-storynew.component';

describe('CreateStoryNewComponent', () => {
  let component: CreateStoryNewComponent;
  let fixture: ComponentFixture<CreateStoryNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateStoryNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateStoryNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});