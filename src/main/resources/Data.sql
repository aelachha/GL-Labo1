INSERT INTO UNITE_ETUDE (id, nom)
VALUES
    (1, 'Informatique'),
    (2, 'Mathematique'),
    (3, 'Science Technique'),
    (4, 'Science Humaine');

INSERT INTO MATIERE (id, nom, credit, ue_id)
VALUES
    -- Informatique
    (1, 'Analyse',  3, 1),
    (2, 'Architecture',  4, 1),
    (3, 'Programmation',  2, 1),
    (4, 'Algorithmique',  3, 1),
    (5, 'Bases de données',  4, 1),

    -- Mathematique
    (6, 'Statistiques',  3, 2),
    (7, 'Theorie des graphes',  4, 2),
    (8, 'Mathematiques',  2, 2),

    -- ScientceTechnique

    (9, 'Base ordinateurs',  2, 3),

    -- ScienceHumaine
    (10, 'Droit', 3, 4),
    (11, 'Ethique', 4, 4),
    (12, 'Psychologie', 2, 4);

INSERT INTO ETUDIANT (id, matricule, nom, prenom, master_Type)
VALUES
    (1, 'ETUD0001', 'Sun'      ,'Wukong'  ,'Informatique'),
    (2, 'ETUD0002', 'Tang'     ,'Sanzang' ,'Informatique'),
    (3, 'ETUD0003', 'Long' ,'Sanjun'  ,'Informatique'),
    (4, 'ETUD0004', 'Zhu'      ,'Bajie'   ,'Informatique');

-- Étudiant 1 sur matières (M1 à M12)
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (1,  9.50, 1, 1);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (2,  11.00, 1, 2);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (3,  8.50,  1, 3);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (4,  7.00, 1, 4);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (5,  7.00,  1, 5);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (6,  5.00, 1, 6);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (7,  19.50, 1, 7);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (8,  12.00, 1, 8);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (9,  9.75,  1, 9);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (10,  0.00, 1, 10);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (11, 3.00, 1, 11);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (12, 9.25, 1, 12);

-- Étudiant 2 sur matières (M1 à M12)
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (13, 10.00, 2, 1);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (14, 14.50, 2, 2);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (15, 2.00,  2, 3);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (16, 19.00, 2, 4);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (17, 15.00, 2, 5);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (18, 13.75, 2, 6);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (19, 8.00,  2, 7);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (20, 11.50, 2, 8);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (21, 17.00, 2, 9);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (22, 5.00,  2, 10);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (23, 16.00, 2, 11);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (24, 9.00,  2, 12);

-- Étudiant 3 sur matières (M1 à M12)
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (25, 7.00,  3, 1);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (26, 12.00, 3, 2);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (27, 0.00,  3, 3);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (28, 10.00, 3, 4);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (29, 5.25,  3, 5);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (30, 20.00, 3, 6);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (31, 11.00, 3, 7);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (32, 3.00,  3, 8);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (33, 2.00,  3, 9);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (34, 8.50,  3, 10);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (35, 14.00, 3, 11);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (36, 17.25, 3, 12);

-- Étudiant 4 sur matières (M1 à M12)
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (37, 15.00, 4, 1);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (38, 14.00, 4, 2);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (39, 18.00, 4, 3);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (40, 19.00, 4, 4);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (41, 12.75, 4, 5);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (42, 10.00, 4, 6);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (43, 5.00,  4, 7);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (44, 1.00,  4, 8);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (45, 3.00,  4, 9);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (46, 20.00, 4, 10);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (47, 7.50,  4, 11);
INSERT INTO NOTE (id, cote, etudiant_id, matiere_id) VALUES (48, 4.00,  4, 12);
