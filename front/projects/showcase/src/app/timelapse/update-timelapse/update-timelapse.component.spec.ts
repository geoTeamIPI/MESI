import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { UpdateTimelapseComponent } from "./update-timelapse.component";

describe("UpdateTimelapseComponent", () => {
  let component: UpdateTimelapseComponent;
  let fixture: ComponentFixture<UpdateTimelapseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateTimelapseComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTimelapseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
