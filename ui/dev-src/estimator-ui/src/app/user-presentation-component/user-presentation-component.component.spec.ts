import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPresentationComponentComponent } from './user-presentation-component.component';

describe('UserPresentationComponentComponent', () => {
  let component: UserPresentationComponentComponent;
  let fixture: ComponentFixture<UserPresentationComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserPresentationComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPresentationComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
