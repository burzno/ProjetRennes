CREATE TABLE CATEGORIE (ID VARCHAR(36), LIBELLE VARCHAR(255), LIBELLECOURT VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE ECHEANCIER (IDECHEANCIER VARCHAR(36), HORAIRE DATETIME, TOURNOI_IDTOURNOI VARCHAR(36), MATCH_IDMATCH VARCHAR(36), PRIMARY KEY (IDECHEANCIER))
CREATE TABLE MATCH (IDMATCH VARCHAR(36), EQUIPE1_IDEQUIPE VARCHAR(36), EQUIPE2_IDEQUIPE VARCHAR(36), POULE_IDPOULE VARCHAR(36), TABLEAUELIMINATION_IDTABLEAUELIMINATION VARCHAR(36), ECHEANCIER_IDECHEANCIER VARCHAR(36), PRIMARY KEY (IDMATCH))
CREATE TABLE TABLEAU (IDTABLEAU VARCHAR(36), NBPAX INTEGER, FORMAT_ID VARCHAR(36), TOUNOI_IDTOURNOI VARCHAR(36), TABLEAUELIMINTATIONS_IDTABLEAUELIMINATION VARCHAR(36), PRIMARY KEY (IDTABLEAU))
CREATE TABLE UTILISATEUR (ID VARCHAR(36), DTYPE VARCHAR(31), ADRESSE VARCHAR(255), ADRESSE_MAIL VARCHAR(255), CODE_POSTALE INTEGER, DATE_NAISSANCE DATE, FIXE VARCHAR(255), MOBILE VARCHAR(255), MOT_DE_PASSE VARCHAR(255), NOM VARCHAR(255), PRENOM VARCHAR(255), SEXE VARCHAR(255), VILLE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE RESULTAT (IDRESULTAT VARCHAR(36), RESULTATEQUIPE1 INTEGER, RESULTATEQUIPE2 INTEGER, SET INTEGER, EQUIPE1_IDEQUIPE VARCHAR(36), EQUIPE2_IDEQUIPE VARCHAR(36), MATCH_IDMATCH VARCHAR(36), PRIMARY KEY (IDRESULTAT))
CREATE TABLE TABLEAUELIMINATION (IDTABLEAUELIMINATION VARCHAR(36), TABLEAU_IDTABLEAU VARCHAR(36), PRIMARY KEY (IDTABLEAUELIMINATION))
CREATE TABLE CLUB (ID VARCHAR(36), NOM VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE EQUIPE (IDEQUIPE VARCHAR(36), ADHERENT_ID VARCHAR(36), PARTENAIRE_ID VARCHAR(36), POULE_IDPOULE VARCHAR(36), TABLEAUELIMINATION_IDTABLEAUELIMINATION VARCHAR(36), PRIMARY KEY (IDEQUIPE))
CREATE TABLE TOURNOI (IDTOURNOI VARCHAR(36), DATETOURNOI DATE, DUREEMATCH INTEGER, DUREERECUP INTEGER, LIEU VARCHAR(255), NBTERRAIN INTEGER, NOM VARCHAR(255), PRIMARY KEY (IDTOURNOI))
CREATE TABLE POULE (IDPOULE VARCHAR(36), NOM VARCHAR(255), TABLEAU_IDTABLEAU VARCHAR(36), PRIMARY KEY (IDPOULE))
CREATE TABLE ADHERENT (ID VARCHAR(36), ISREFERENT TINYINT(1) default 0, LICENCE_FCD VARCHAR(255), LICENCE_FFBA VARCHAR(255), CATEGORIE_ID VARCHAR(36), CLUB_ID VARCHAR(36), PRIMARY KEY (ID))
CREATE TABLE FORMAT (ID VARCHAR(36), LIBELLE VARCHAR(255), LIBELLECOURT VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE CLASSEMENT (ID VARCHAR(36), LIBELLE VARCHAR(255), FORMAT_ID VARCHAR(36), PRIMARY KEY (ID))
CREATE TABLE MATCH_RESULTAT (Match_IDMATCH VARCHAR(36), resultats_IDRESULTAT VARCHAR(36), PRIMARY KEY (Match_IDMATCH, resultats_IDRESULTAT))
CREATE TABLE TABLEAU_ADHERENT (Tableau_IDTABLEAU VARCHAR(36), adherent_ID VARCHAR(36), PRIMARY KEY (Tableau_IDTABLEAU, adherent_ID))
CREATE TABLE TABLEAU_CATEGORIE (Tableau_IDTABLEAU VARCHAR(36), categories_ID VARCHAR(36), PRIMARY KEY (Tableau_IDTABLEAU, categories_ID))
CREATE TABLE TABLEAU_CLASSEMENT (Tableau_IDTABLEAU VARCHAR(36), classements_ID VARCHAR(36), PRIMARY KEY (Tableau_IDTABLEAU, classements_ID))
CREATE TABLE TABLEAU_POULE (Tableau_IDTABLEAU VARCHAR(36), poules_IDPOULE VARCHAR(36), PRIMARY KEY (Tableau_IDTABLEAU, poules_IDPOULE))
CREATE TABLE TABLEAUELIMINATION_EQUIPE (TableauElimination_IDTABLEAUELIMINATION VARCHAR(36), equipes_IDEQUIPE VARCHAR(36), PRIMARY KEY (TableauElimination_IDTABLEAUELIMINATION, equipes_IDEQUIPE))
CREATE TABLE TABLEAUELIMINATION_MATCH (TableauElimination_IDTABLEAUELIMINATION VARCHAR(36), matchs_IDMATCH VARCHAR(36), PRIMARY KEY (TableauElimination_IDTABLEAUELIMINATION, matchs_IDMATCH))
CREATE TABLE EQUIPE_MATCH (Equipe_IDEQUIPE VARCHAR(36), matchs_IDMATCH VARCHAR(36), PRIMARY KEY (Equipe_IDEQUIPE, matchs_IDMATCH))
CREATE TABLE TOURNOI_ECHEANCIER (Tournoi_IDTOURNOI VARCHAR(36), echeanciers_IDECHEANCIER VARCHAR(36), PRIMARY KEY (Tournoi_IDTOURNOI, echeanciers_IDECHEANCIER))
CREATE TABLE TOURNOI_TABLEAU (Tournoi_IDTOURNOI VARCHAR(36), tableaux_IDTABLEAU VARCHAR(36), PRIMARY KEY (Tournoi_IDTOURNOI, tableaux_IDTABLEAU))
CREATE TABLE POULE_EQUIPE (Poule_IDPOULE VARCHAR(36), equipes_IDEQUIPE VARCHAR(36), PRIMARY KEY (Poule_IDPOULE, equipes_IDEQUIPE))
CREATE TABLE POULE_MATCH (Poule_IDPOULE VARCHAR(36), matchs_IDMATCH VARCHAR(36), PRIMARY KEY (Poule_IDPOULE, matchs_IDMATCH))
CREATE TABLE ADHERENT_CLASSEMENT (Adherent_ID VARCHAR(36), listeClassements_ID VARCHAR(36), PRIMARY KEY (Adherent_ID, listeClassements_ID))
ALTER TABLE ECHEANCIER ADD CONSTRAINT FK_ECHEANCIER_MATCH_IDMATCH FOREIGN KEY (MATCH_IDMATCH) REFERENCES MATCH (IDMATCH)
ALTER TABLE ECHEANCIER ADD CONSTRAINT FK_ECHEANCIER_TOURNOI_IDTOURNOI FOREIGN KEY (TOURNOI_IDTOURNOI) REFERENCES TOURNOI (IDTOURNOI)
ALTER TABLE MATCH ADD CONSTRAINT FK_MATCH_TABLEAUELIMINATION_IDTABLEAUELIMINATION FOREIGN KEY (TABLEAUELIMINATION_IDTABLEAUELIMINATION) REFERENCES TABLEAUELIMINATION (IDTABLEAUELIMINATION)
ALTER TABLE MATCH ADD CONSTRAINT FK_MATCH_EQUIPE2_IDEQUIPE FOREIGN KEY (EQUIPE2_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE MATCH ADD CONSTRAINT FK_MATCH_ECHEANCIER_IDECHEANCIER FOREIGN KEY (ECHEANCIER_IDECHEANCIER) REFERENCES ECHEANCIER (IDECHEANCIER)
ALTER TABLE MATCH ADD CONSTRAINT FK_MATCH_POULE_IDPOULE FOREIGN KEY (POULE_IDPOULE) REFERENCES POULE (IDPOULE)
ALTER TABLE MATCH ADD CONSTRAINT FK_MATCH_EQUIPE1_IDEQUIPE FOREIGN KEY (EQUIPE1_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE TABLEAU ADD CONSTRAINT FK_TABLEAU_FORMAT_ID FOREIGN KEY (FORMAT_ID) REFERENCES FORMAT (ID)
ALTER TABLE TABLEAU ADD CONSTRAINT FK_TABLEAU_TOUNOI_IDTOURNOI FOREIGN KEY (TOUNOI_IDTOURNOI) REFERENCES TOURNOI (IDTOURNOI)
ALTER TABLE TABLEAU ADD CONSTRAINT TABLEAU_TABLEAUELIMINTATIONS_IDTABLEAUELIMINATION FOREIGN KEY (TABLEAUELIMINTATIONS_IDTABLEAUELIMINATION) REFERENCES TABLEAUELIMINATION (IDTABLEAUELIMINATION)
ALTER TABLE RESULTAT ADD CONSTRAINT FK_RESULTAT_EQUIPE2_IDEQUIPE FOREIGN KEY (EQUIPE2_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE RESULTAT ADD CONSTRAINT FK_RESULTAT_EQUIPE1_IDEQUIPE FOREIGN KEY (EQUIPE1_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE RESULTAT ADD CONSTRAINT FK_RESULTAT_MATCH_IDMATCH FOREIGN KEY (MATCH_IDMATCH) REFERENCES MATCH (IDMATCH)
ALTER TABLE TABLEAUELIMINATION ADD CONSTRAINT FK_TABLEAUELIMINATION_TABLEAU_IDTABLEAU FOREIGN KEY (TABLEAU_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE EQUIPE ADD CONSTRAINT FK_EQUIPE_TABLEAUELIMINATION_IDTABLEAUELIMINATION FOREIGN KEY (TABLEAUELIMINATION_IDTABLEAUELIMINATION) REFERENCES TABLEAUELIMINATION (IDTABLEAUELIMINATION)
ALTER TABLE EQUIPE ADD CONSTRAINT FK_EQUIPE_ADHERENT_ID FOREIGN KEY (ADHERENT_ID) REFERENCES UTILISATEUR (ID)
ALTER TABLE EQUIPE ADD CONSTRAINT FK_EQUIPE_PARTENAIRE_ID FOREIGN KEY (PARTENAIRE_ID) REFERENCES UTILISATEUR (ID)
ALTER TABLE EQUIPE ADD CONSTRAINT FK_EQUIPE_POULE_IDPOULE FOREIGN KEY (POULE_IDPOULE) REFERENCES POULE (IDPOULE)
ALTER TABLE POULE ADD CONSTRAINT FK_POULE_TABLEAU_IDTABLEAU FOREIGN KEY (TABLEAU_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE ADHERENT ADD CONSTRAINT FK_ADHERENT_ID FOREIGN KEY (ID) REFERENCES UTILISATEUR (ID)
ALTER TABLE ADHERENT ADD CONSTRAINT FK_ADHERENT_CLUB_ID FOREIGN KEY (CLUB_ID) REFERENCES CLUB (ID)
ALTER TABLE ADHERENT ADD CONSTRAINT FK_ADHERENT_CATEGORIE_ID FOREIGN KEY (CATEGORIE_ID) REFERENCES CATEGORIE (ID)
ALTER TABLE CLASSEMENT ADD CONSTRAINT FK_CLASSEMENT_FORMAT_ID FOREIGN KEY (FORMAT_ID) REFERENCES FORMAT (ID)
ALTER TABLE MATCH_RESULTAT ADD CONSTRAINT FK_MATCH_RESULTAT_Match_IDMATCH FOREIGN KEY (Match_IDMATCH) REFERENCES MATCH (IDMATCH)
ALTER TABLE MATCH_RESULTAT ADD CONSTRAINT FK_MATCH_RESULTAT_resultats_IDRESULTAT FOREIGN KEY (resultats_IDRESULTAT) REFERENCES RESULTAT (IDRESULTAT)
ALTER TABLE TABLEAU_ADHERENT ADD CONSTRAINT FK_TABLEAU_ADHERENT_adherent_ID FOREIGN KEY (adherent_ID) REFERENCES UTILISATEUR (ID)
ALTER TABLE TABLEAU_ADHERENT ADD CONSTRAINT FK_TABLEAU_ADHERENT_Tableau_IDTABLEAU FOREIGN KEY (Tableau_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE TABLEAU_CATEGORIE ADD CONSTRAINT FK_TABLEAU_CATEGORIE_Tableau_IDTABLEAU FOREIGN KEY (Tableau_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE TABLEAU_CATEGORIE ADD CONSTRAINT FK_TABLEAU_CATEGORIE_categories_ID FOREIGN KEY (categories_ID) REFERENCES CATEGORIE (ID)
ALTER TABLE TABLEAU_CLASSEMENT ADD CONSTRAINT FK_TABLEAU_CLASSEMENT_Tableau_IDTABLEAU FOREIGN KEY (Tableau_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE TABLEAU_CLASSEMENT ADD CONSTRAINT FK_TABLEAU_CLASSEMENT_classements_ID FOREIGN KEY (classements_ID) REFERENCES CLASSEMENT (ID)
ALTER TABLE TABLEAU_POULE ADD CONSTRAINT FK_TABLEAU_POULE_poules_IDPOULE FOREIGN KEY (poules_IDPOULE) REFERENCES POULE (IDPOULE)
ALTER TABLE TABLEAU_POULE ADD CONSTRAINT FK_TABLEAU_POULE_Tableau_IDTABLEAU FOREIGN KEY (Tableau_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE TABLEAUELIMINATION_EQUIPE ADD CONSTRAINT FK_TABLEAUELIMINATION_EQUIPE_equipes_IDEQUIPE FOREIGN KEY (equipes_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE TABLEAUELIMINATION_EQUIPE ADD CONSTRAINT TBLLMINATIONEQUIPETbllminationIDTABLEAUELIMINATION FOREIGN KEY (TableauElimination_IDTABLEAUELIMINATION) REFERENCES TABLEAUELIMINATION (IDTABLEAUELIMINATION)
ALTER TABLE TABLEAUELIMINATION_MATCH ADD CONSTRAINT TBLLMINATIONMATCHTblliminationIDTABLEAUELIMINATION FOREIGN KEY (TableauElimination_IDTABLEAUELIMINATION) REFERENCES TABLEAUELIMINATION (IDTABLEAUELIMINATION)
ALTER TABLE TABLEAUELIMINATION_MATCH ADD CONSTRAINT FK_TABLEAUELIMINATION_MATCH_matchs_IDMATCH FOREIGN KEY (matchs_IDMATCH) REFERENCES MATCH (IDMATCH)
ALTER TABLE EQUIPE_MATCH ADD CONSTRAINT FK_EQUIPE_MATCH_Equipe_IDEQUIPE FOREIGN KEY (Equipe_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE EQUIPE_MATCH ADD CONSTRAINT FK_EQUIPE_MATCH_matchs_IDMATCH FOREIGN KEY (matchs_IDMATCH) REFERENCES MATCH (IDMATCH)
ALTER TABLE TOURNOI_ECHEANCIER ADD CONSTRAINT FK_TOURNOI_ECHEANCIER_echeanciers_IDECHEANCIER FOREIGN KEY (echeanciers_IDECHEANCIER) REFERENCES ECHEANCIER (IDECHEANCIER)
ALTER TABLE TOURNOI_ECHEANCIER ADD CONSTRAINT FK_TOURNOI_ECHEANCIER_Tournoi_IDTOURNOI FOREIGN KEY (Tournoi_IDTOURNOI) REFERENCES TOURNOI (IDTOURNOI)
ALTER TABLE TOURNOI_TABLEAU ADD CONSTRAINT FK_TOURNOI_TABLEAU_Tournoi_IDTOURNOI FOREIGN KEY (Tournoi_IDTOURNOI) REFERENCES TOURNOI (IDTOURNOI)
ALTER TABLE TOURNOI_TABLEAU ADD CONSTRAINT FK_TOURNOI_TABLEAU_tableaux_IDTABLEAU FOREIGN KEY (tableaux_IDTABLEAU) REFERENCES TABLEAU (IDTABLEAU)
ALTER TABLE POULE_EQUIPE ADD CONSTRAINT FK_POULE_EQUIPE_equipes_IDEQUIPE FOREIGN KEY (equipes_IDEQUIPE) REFERENCES EQUIPE (IDEQUIPE)
ALTER TABLE POULE_EQUIPE ADD CONSTRAINT FK_POULE_EQUIPE_Poule_IDPOULE FOREIGN KEY (Poule_IDPOULE) REFERENCES POULE (IDPOULE)
ALTER TABLE POULE_MATCH ADD CONSTRAINT FK_POULE_MATCH_matchs_IDMATCH FOREIGN KEY (matchs_IDMATCH) REFERENCES MATCH (IDMATCH)
ALTER TABLE POULE_MATCH ADD CONSTRAINT FK_POULE_MATCH_Poule_IDPOULE FOREIGN KEY (Poule_IDPOULE) REFERENCES POULE (IDPOULE)
ALTER TABLE ADHERENT_CLASSEMENT ADD CONSTRAINT FK_ADHERENT_CLASSEMENT_listeClassements_ID FOREIGN KEY (listeClassements_ID) REFERENCES CLASSEMENT (ID)
ALTER TABLE ADHERENT_CLASSEMENT ADD CONSTRAINT FK_ADHERENT_CLASSEMENT_Adherent_ID FOREIGN KEY (Adherent_ID) REFERENCES UTILISATEUR (ID)
