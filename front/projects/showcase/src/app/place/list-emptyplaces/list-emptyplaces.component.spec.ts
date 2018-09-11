import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ListEmptyPlacesComponent } from "./list-emptyplaces.component";

describe("ListEmptyPlacesComponent", () => {
  let component: ListEmptyPlacesComponent;
  let fixture: ComponentFixture<ListEmptyPlacesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListEmptyPlacesComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListEmptyPlacesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
