import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AuditsComponent } from './audits/audits.component';
import { ConfigurationComponent } from './configuration/configuration.component';
import { HealthComponent } from './health/health.component';
import { LogComponent } from './log/log.component';
import { MetricsComponent } from './metrics/metrics.component';
import { UserManagementComponent } from './user-management/user-management.component';

@NgModule({
  imports: [
    CommonModule,
    AdminRoutingModule
  ],
  declarations: [AuditsComponent, ConfigurationComponent, HealthComponent, LogComponent, MetricsComponent, UserManagementComponent]
})
export class AdminModule { }
