ALTER TABLE ECHEANCIER DROP FOREIGN KEY FK_ECHEANCIER_MATCH_IDMATCH
ALTER TABLE ECHEANCIER DROP FOREIGN KEY FK_ECHEANCIER_TOURNOI_IDTOURNOI
ALTER TABLE MATCHS DROP FOREIGN KEY FK_MATCHS_ECHEANCIER_IDECHEANCIER
ALTER TABLE MATCHS DROP FOREIGN KEY FK_MATCHS_TABLEAUELIMINATION_IDTABLEAUELIMINATION
ALTER TABLE MATCHS DROP FOREIGN KEY FK_MATCHS_POULE_IDPOULE
ALTER TABLE MATCHS DROP FOREIGN KEY FK_MATCHS_EQUIPE2_IDEQUIPE
ALTER TABLE MATCHS DROP FOREIGN KEY FK_MATCHS_EQUIPE1_IDEQUIPE
ALTER TABLE TABLEAU DROP FOREIGN KEY FK_TABLEAU_FORMAT_ID
ALTER TABLE TABLEAU DROP FOREIGN KEY FK_TABLEAU_TOURNOI_IDTOURNOI
ALTER TABLE TABLEAU DROP FOREIGN KEY TABLEAU_TABLEAUELIMINTATIONS_IDTABLEAUELIMINATION
ALTER TABLE RESULTAT DROP FOREIGN KEY FK_RESULTAT_EQUIPE2_IDEQUIPE
ALTER TABLE RESULTAT DROP FOREIGN KEY FK_RESULTAT_EQUIPE1_IDEQUIPE
ALTER TABLE RESULTAT DROP FOREIGN KEY FK_RESULTAT_MATCH_IDMATCH
ALTER TABLE TABLEAUELIMINATION DROP FOREIGN KEY FK_TABLEAUELIMINATION_TABLEAU_IDTABLEAU
ALTER TABLE EQUIPE DROP FOREIGN KEY FK_EQUIPE_TABLEAUELIMINATION_IDTABLEAUELIMINATION
ALTER TABLE EQUIPE DROP FOREIGN KEY FK_EQUIPE_ADHERENT_ID
ALTER TABLE EQUIPE DROP FOREIGN KEY FK_EQUIPE_PARTENAIRE_ID
ALTER TABLE EQUIPE DROP FOREIGN KEY FK_EQUIPE_POULE_IDPOULE
ALTER TABLE POULE DROP FOREIGN KEY FK_POULE_TABLEAU_IDTABLEAU
ALTER TABLE ADHERENT DROP FOREIGN KEY FK_ADHERENT_ID
ALTER TABLE ADHERENT DROP FOREIGN KEY FK_ADHERENT_CLUB_ID
ALTER TABLE ADHERENT DROP FOREIGN KEY FK_ADHERENT_CATEGORIE_ID
ALTER TABLE CLASSEMENT DROP FOREIGN KEY FK_CLASSEMENT_FORMAT_ID
ALTER TABLE TABLEAU_ADHERENT DROP FOREIGN KEY FK_TABLEAU_ADHERENT_adherent_ID
ALTER TABLE TABLEAU_ADHERENT DROP FOREIGN KEY FK_TABLEAU_ADHERENT_Tableau_IDTABLEAU
ALTER TABLE TABLEAU_CATEGORIE DROP FOREIGN KEY FK_TABLEAU_CATEGORIE_Tableau_IDTABLEAU
ALTER TABLE TABLEAU_CATEGORIE DROP FOREIGN KEY FK_TABLEAU_CATEGORIE_categories_ID
ALTER TABLE TABLEAU_CLASSEMENT DROP FOREIGN KEY FK_TABLEAU_CLASSEMENT_Tableau_IDTABLEAU
ALTER TABLE TABLEAU_CLASSEMENT DROP FOREIGN KEY FK_TABLEAU_CLASSEMENT_classements_ID
ALTER TABLE ADHERENT_CLASSEMENT DROP FOREIGN KEY FK_ADHERENT_CLASSEMENT_listeClassements_ID
ALTER TABLE ADHERENT_CLASSEMENT DROP FOREIGN KEY FK_ADHERENT_CLASSEMENT_Adherent_ID
DROP TABLE CATEGORIE
DROP TABLE ECHEANCIER
DROP TABLE MATCHS
DROP TABLE TABLEAU
DROP TABLE UTILISATEUR
DROP TABLE RESULTAT
DROP TABLE TABLEAUELIMINATION
DROP TABLE CLUB
DROP TABLE EQUIPE
DROP TABLE TOURNOI
DROP TABLE POULE
DROP TABLE ADHERENT
DROP TABLE FORMAT
DROP TABLE CLASSEMENT
DROP TABLE TABLEAU_ADHERENT
DROP TABLE TABLEAU_CATEGORIE
DROP TABLE TABLEAU_CLASSEMENT
DROP TABLE ADHERENT_CLASSEMENT
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
