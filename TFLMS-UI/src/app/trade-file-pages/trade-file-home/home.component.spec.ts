import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let compiled: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    compiled = fixture.nativeElement;
    fixture.detectChanges(); 
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should have "home" as the default activeTab', () => {
    expect(component.activeTab).toBe('home');
  });

  it('should change activeTab to "upload" when setActiveTab for upload is called', () => {
    component.setActiveTab('upload');
    expect(component.activeTab).toBe('upload');
  });

  it('should display the About section when activeTab is "home"', () => {
    component.setActiveTab('home');
    fixture.detectChanges();
    expect(compiled.textContent).toContain('Welcome to our Trade Data Processing System');
  });

  it('should change activeTab to "details" when setActiveTab for home upload details is called', () => {
    component.setActiveTab('details');
    expect(component.activeTab).toBe('details');
  });
});
