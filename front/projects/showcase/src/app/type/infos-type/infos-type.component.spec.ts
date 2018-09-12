import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { InfosTypeComponent } from "./infos-type.component";

describe("InfosTypeComponent", () => {
  let component: InfosTypeComponent;
  let fixture: ComponentFixture<InfosTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InfosTypeComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
