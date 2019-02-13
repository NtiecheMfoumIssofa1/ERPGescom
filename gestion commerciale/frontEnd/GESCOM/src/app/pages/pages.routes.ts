import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { ServicesComponent } from './services/services.component';
import { ArticlesComponent } from './articles/articles.component';
import { CommandesComponent } from './Achat/commandes/commandes.component';
import { DepensesComponent } from './Achat/depenses/depenses.component';
import { ClientComponent } from './client/client.component';
import { ComptabiliteComponent } from './comptabilite/comptabilite.component';
import { DocumentsComponent } from './documents/documents.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { EntreesComponent } from './Stock/entrees/entrees.component';
import { SortiesComponent } from './Stock/sorties/sorties.component';
import { TaxesComponent } from './taxes/taxes.component';
import { DevisComponent } from './Ventes/devis/devis.component';
import { FactureComponent } from './Ventes/facture/facture.component';
import { TarifsComponent } from './Ventes/tarifs/tarifs.component';
import { VenteComponent } from './Ventes/vente/vente.component';

const pagesRoutes: Routes = [
  	{ path: 'contact', component: ContactComponent ,data: { animation: 'contact' } },
  	{ path: 'about', component: AboutComponent ,data: { animation: 'about' }},
    { path: 'services', component: ServicesComponent ,data: { animation: 'services' }},
    { path: 'articles', component: ArticlesComponent },
    { path: 'achat/commandes', component: CommandesComponent },
    { path: 'achat/depenses', component: DepensesComponent },
    { path: 'client', component: ClientComponent },
    { path: 'comptabilite', component: ComptabiliteComponent },
    { path: 'documents', component: DocumentsComponent },
    { path: 'fournisseur', component: FournisseurComponent },
    { path: 'stock/entrees', component: EntreesComponent },
    { path: 'stock/sorties', component: SortiesComponent },
    { path: 'taxes', component: TaxesComponent },
    { path: 'ventes/devis', component: DevisComponent },
    { path: 'ventes/facture', component: FactureComponent },
    { path: 'ventes/tarifs', component: TarifsComponent },
    { path: 'ventes/vente', component: VenteComponent },
];

@NgModule({
  imports: [
    RouterModule.forChild(pagesRoutes)
  	],
  exports: [
    RouterModule
  ]
})
export class PagesRouterModule {}