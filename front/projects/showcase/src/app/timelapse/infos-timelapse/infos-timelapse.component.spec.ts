import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { InfosTimelapseComponent } from "./infos-timelapse.component";

describe("InfosTimelapseComponent", () => {
  let component: InfosTimelapseComponent;
  let fixture: ComponentFixture<InfosTimelapseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InfosTimelapseComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosTimelapseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
