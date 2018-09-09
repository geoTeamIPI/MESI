import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { InfosPlaceComponent } from "./infos-place.component";

describe("InfosPlaceComponent", () => {
  let component: InfosPlaceComponent;
  let fixture: ComponentFixture<InfosPlaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InfosPlaceComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
