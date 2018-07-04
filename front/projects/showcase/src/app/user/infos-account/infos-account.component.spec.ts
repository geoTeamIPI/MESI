import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfosAccountComponent } from './infos-account.component';

describe('InfosAccountComponent', () => {
  let component: InfosAccountComponent;
  let fixture: ComponentFixture<InfosAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfosAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
