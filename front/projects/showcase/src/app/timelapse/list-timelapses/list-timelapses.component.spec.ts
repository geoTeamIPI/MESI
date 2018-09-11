import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ListTimelapsesComponent } from "./list-timelapses.component";

describe("ListTimelapsesComponent", () => {
  let component: ListTimelapsesComponent;
  let fixture: ComponentFixture<ListTimelapsesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListTimelapsesComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListTimelapsesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
