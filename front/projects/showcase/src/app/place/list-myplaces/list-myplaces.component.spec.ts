import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ListMyPlacesComponent } from "./list-myplaces.component";

describe("ListMyPlacesComponent", () => {
  let component: ListMyPlacesComponent;
  let fixture: ComponentFixture<ListMyPlacesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListMyPlacesComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMyPlacesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
