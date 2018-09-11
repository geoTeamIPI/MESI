import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { InfosUserPublicComponent } from "./infos-userpublic.component";

describe("InfosUserPublicComponent", () => {
  let component: InfosUserPublicComponent;
  let fixture: ComponentFixture<InfosUserPublicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InfosUserPublicComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosUserPublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
