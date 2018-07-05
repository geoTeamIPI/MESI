import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { InfosUsersComponent } from "./infos-users.component";

describe("InfosUsersComponent", () => {
  let component: InfosUsersComponent;
  let fixture: ComponentFixture<InfosUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InfosUsersComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
