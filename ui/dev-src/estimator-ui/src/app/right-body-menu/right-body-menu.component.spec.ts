import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RightBodyMenuComponent } from './right-body-menu.component';

describe('RightBodyMenuComponent', () => {
  let component: RightBodyMenuComponent;
  let fixture: ComponentFixture<RightBodyMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RightBodyMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RightBodyMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
