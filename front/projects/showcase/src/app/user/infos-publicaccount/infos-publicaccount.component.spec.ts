import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfosPublicAccountComponent } from './infos-publicaccount.component';

describe('InfosPublicAccountComponent', () => {
  let component: InfosPublicAccountComponent;
  let fixture: ComponentFixture<InfosPublicAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfosPublicAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosPublicAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
