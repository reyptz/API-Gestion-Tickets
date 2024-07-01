DELIMITER $$

CREATE TRIGGER trigger_notifications
    AFTER INSERT ON tickets
    FOR EACH ROW
BEGIN
    IF NEW.status = 'EN_COURS' THEN
        INSERT INTO notifications(content, create_at, update_at, id_tickets)
        VALUES('Nouveau ticket créé', NOW(), NOW(), NEW.id);
    ELSEIF NEW.status = 'OUVERT' THEN
        INSERT INTO notifications(content, create_at, update_at, id_tickets)
        VALUES('Votre ticket a été ouvert', NOW(), NOW(), NEW.id);
    ELSEIF NEW.status = 'RESOLU' THEN
        INSERT INTO notifications(content, create_at, update_at, id_tickets)
        VALUES('Votre ticket a été résolu', NOW(), NOW(), NEW.id);
    END IF;
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER trigger_notifications_update
    AFTER UPDATE ON tickets
    FOR EACH ROW
BEGIN
    IF NEW.status = 'EN_COURS' THEN
        INSERT INTO notifications(content, create_at, update_at, id_tickets)
        VALUES('Nouveau ticket créé', NOW(), NOW(), NEW.id);
    ELSEIF NEW.status = 'OUVERT' THEN
        INSERT INTO notifications(content, create_at, update_at, id_tickets)
        VALUES('Votre ticket a été ouvert', NOW(), NOW(), NEW.id);
    ELSEIF NEW.status = 'RESOLU' THEN
        INSERT INTO notifications(content, create_at, update_at, id_tickets)
        VALUES('Votre ticket a été résolu', NOW(), NOW(), NEW.id);
    END IF;
END$$

DELIMITER ;



DELIMITER $$

CREATE TRIGGER trigger_respnotifs_insert
    AFTER INSERT ON reponses
    FOR EACH ROW
BEGIN
    UPDATE tickets SET status = 'RESOLU';
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER trigger_respnotifs_update
    AFTER UPDATE ON reponses
    FOR EACH ROW
BEGIN
    UPDATE tickets SET status = 'RESOLU';
END$$

DELIMITER ;

INSERT INTO tickets (title, content, status, create_at, update_at, id_apprenants, id_categorie)
VALUES ('Problème de connexion', 'Son Excellence Mr le Président ABS\r\nBonjour,\r\nJ\'ai un problème de connexion avec ma machine.', 'EN_COURS', '2024-06-12 10:04:31', '2024-06-12 10:04:31', '1', '1');