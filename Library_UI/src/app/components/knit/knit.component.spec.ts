import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnitComponent } from './knit.component';

describe('KnitComponent', () => {
  let component: KnitComponent;
  let fixture: ComponentFixture<KnitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KnitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
