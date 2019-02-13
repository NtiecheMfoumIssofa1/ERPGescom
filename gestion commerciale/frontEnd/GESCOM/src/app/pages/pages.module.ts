import { NgModule, Injector } from '@angular/core';
import { 
        MatCardModule,
        MatButtonModule,
        MatButtonToggleModule,
        MatInputModule,
        MatToolbarModule,
        MatIconModule,
        MatCheckboxModule,
        MatListModule,
       } from '@angular/material';
import { MatChipsModule } from '@angular/material/chips';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import { PagesRouterModule } from './pages.routes';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { ServicesComponent } from './services/services.component';
import { CoreModule } from '../core/core.module';
import { ArticlesComponent } from './articles/articles.component';
import { EntreesComponent } from './Stock/entrees/entrees.component';
import { SortiesComponent } from './Stock/sorties/sorties.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { ClientComponent } from './client/client.component';
import { CommandesComponent } from './Achat/commandes/commandes.component';
import { DepensesComponent } from './Achat/depenses/depenses.component';
import { VenteComponent } from './Ventes/vente/vente.component';
import { DevisComponent } from './Ventes/devis/devis.component';
import { TarifsComponent } from './Ventes/tarifs/tarifs.component';
import { FactureComponent } from './Ventes/facture/facture.component';
import { TaxesComponent } from './taxes/taxes.component';
import { DocumentsComponent } from './documents/documents.component';
import { ComptabiliteComponent } from './comptabilite/comptabilite.component';
import { LoginService } from '../services/login.service';
import { AccountService } from '../services/account.service';
import { AuthServerProvider } from '../services/auth-jwt.service';
import { Principal } from '../services/principal.service';
import { StateStorageService } from '../services/state-storage.service';


@NgModule({
    imports: [
        MatCardModule,
        CommonModule,
        FlexLayoutModule,
        MatButtonModule,
        MatButtonToggleModule,
        MatInputModule,
        MatToolbarModule,
        MatIconModule,
        MatCheckboxModule,
        MatListModule,
        MatChipsModule,
        CoreModule,
        PagesRouterModule ],
    declarations: [   
        ContactComponent,
        AboutComponent,
        ServicesComponent,
        ArticlesComponent,
        EntreesComponent,
        SortiesComponent,
        FournisseurComponent,
        ClientComponent,
        CommandesComponent,
        DepensesComponent,
        VenteComponent,
        DevisComponent,
        TarifsComponent,
        FactureComponent,
        TaxesComponent,
        DocumentsComponent,
        ComptabiliteComponent
    ],
    exports: [
    ],
    providers: [
        LoginService,
        AccountService,
        AuthServerProvider,
        Principal,
        StateStorageService,
    ]
})
export class PagesModule {
}
