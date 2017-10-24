import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftBodyMenuComponent } from './left-body-menu.component';

describe('LeftBodyMenuComponent', () => {
  let component: LeftBodyMenuComponent;
  let fixture: ComponentFixture<LeftBodyMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftBodyMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftBodyMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
