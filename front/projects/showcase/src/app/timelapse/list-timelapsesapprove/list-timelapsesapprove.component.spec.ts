import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ListTimelapsesApproveComponent } from "./list-timelapsesapprove.component";

describe("ListTimelapsesApproveComponent", () => {
  let component: ListTimelapsesApproveComponent;
  let fixture: ComponentFixture<ListTimelapsesApproveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListTimelapsesApproveComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListTimelapsesApproveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
