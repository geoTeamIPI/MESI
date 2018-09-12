import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ListMyStoriesComponent } from "./list-mystories.component";

describe("ListMyStoriesComponent", () => {
  let component: ListMyStoriesComponent;
  let fixture: ComponentFixture<ListMyStoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListMyStoriesComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMyStoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
