import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ProposeTypeComponent } from "./propose-type.component";

describe("ProposeTypeComponent", () => {
  let component: ProposeTypeComponent;
  let fixture: ComponentFixture<ProposeTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ProposeTypeComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProposeTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should propose", () => {
    expect(component).toBeTruthy();
  });
});
