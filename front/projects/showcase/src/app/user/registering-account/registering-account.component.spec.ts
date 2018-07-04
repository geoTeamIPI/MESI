import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteringAccountComponent } from './registering-account.component';

describe('RegisteringAccountComponent', () => {
  let component: RegisteringAccountComponent;
  let fixture: ComponentFixture<RegisteringAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisteringAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisteringAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
