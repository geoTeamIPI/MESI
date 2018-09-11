import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { CreateTimelapseComponent } from "./create-timelapse.component";

describe("CreateTimelapseComponent", () => {
  let component: CreateTimelapseComponent;
  let fixture: ComponentFixture<CreateTimelapseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CreateTimelapseComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTimelapseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
