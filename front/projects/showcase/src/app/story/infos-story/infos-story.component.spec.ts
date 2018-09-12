import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { InfosStoryComponent } from "./infos-story.component";

describe("InfosStoryComponent", () => {
  let component: InfosStoryComponent;
  let fixture: ComponentFixture<InfosStoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InfosStoryComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosStoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
