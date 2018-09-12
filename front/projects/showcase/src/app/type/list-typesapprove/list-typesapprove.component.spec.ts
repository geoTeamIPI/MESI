import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ListTypesApproveComponent } from "./list-typesapprove.component";

describe("ListTypesApproveComponent", () => {
  let component: ListTypesApproveComponent;
  let fixture: ComponentFixture<ListTypesApproveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListTypesApproveComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListTypesApproveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
