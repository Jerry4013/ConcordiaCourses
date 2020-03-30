import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatToolbarModule, MatMenuModule, MatIconModule, MatListModule, MatSidenavModule, MatDialogModule, MatFormFieldModule, MatInputModule, MatProgressSpinnerModule, MatTooltipModule, MatSnackBarModule, MatCardModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatDialogModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatCardModule
  ],
  exports:[
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatDialogModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatCardModule
  ]
})
export class SharedModule { }
