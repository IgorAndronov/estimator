import { TestBed, inject } from '@angular/core/testing';

import { GetPhotosDashboardService } from './get-photos-dashboard.service';

describe('GetPhotosDashboardService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetPhotosDashboardService]
    });
  });

  it('should be created', inject([GetPhotosDashboardService], (service: GetPhotosDashboardService) => {
    expect(service).toBeTruthy();
  }));
});
