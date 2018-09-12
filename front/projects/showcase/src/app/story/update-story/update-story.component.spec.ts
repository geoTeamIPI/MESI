import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStoryComponent } from './update-story.component';

describe('UpdateStoryComponent', () => {
  let component: UpdateStoryComponent;
  let fixture: ComponentFixture<UpdateStoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateStoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateStoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should update', () => {
    expect(component).toBeTruthy();
  });
});