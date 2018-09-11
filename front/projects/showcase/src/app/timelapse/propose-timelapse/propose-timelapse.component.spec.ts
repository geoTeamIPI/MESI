import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ProposeTimelapseComponent } from "./propose-timelapse.component";

describe("ProposeTimelapseComponent", () => {
  let component: ProposeTimelapseComponent;
  let fixture: ComponentFixture<ProposeTimelapseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ProposeTimelapseComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProposeTimelapseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should propose", () => {
    expect(component).toBeTruthy();
  });
});
