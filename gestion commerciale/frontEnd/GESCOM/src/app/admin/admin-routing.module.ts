import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuditsComponent } from './audits/audits.component';
import { ConfigurationComponent } from './configuration/configuration.component';
import { HealthComponent } from './health/health.component';
import { LogComponent } from './log/log.component';
import { MetricsComponent } from './metrics/metrics.component';
import { UserManagementComponent } from './user-management/user-management.component';

const AdminRoutes: Routes = [
  { path: 'audits', component: AuditsComponent ,data: { animation: 'audits' } },
  {path:'configuration',component:ConfigurationComponent},
  {path:'health',component:HealthComponent},
  {path:'log',component:LogComponent},
  {path:'metrics',component:MetricsComponent},
  {path:'user-management',component:UserManagementComponent},

];

@NgModule({
  imports: [RouterModule.forChild(AdminRoutes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
